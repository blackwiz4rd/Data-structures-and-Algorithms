/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtester;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author luca
 * @param <V>
 * @param <E>
 */
public class EdgeListGraph<V,E> implements Graph<V,E>{
    //Vertex estende position, ha un element. Riferimento alla propria pos?
    LinkedList<Vertex<V>> vertex; //ci memorizzo VertexNode
    LinkedList<Edge<E>> edge;
    
    public EdgeListGraph(){
        vertex = new LinkedList();
        edge = new LinkedList();
    }
    
    class VertexNode<V,E> implements VertexP<V,E>{
        private V element;      //data
        private String label;   //UNEXPLORED, VISITED
        private Edge<E> parent; //for printPath in BFS
        private int location;   //location aware
        
        public VertexNode(V element, int location){
            this.element = element;
            this.location = location;
            parent = null; //edge non valido
        }
        
        public int location(){
            return location;
        }
        
        //solo per attraversamenti
        @Override
        public void setLabel(String status) {
            label = status;
        }
        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public V element() {
            return element;
        }

        @Override
        public void setParent(Edge<E> e) {
            if(e!=null)
                System.out.println("setting parent: " + e);
            parent = e;
        }

        @Override
        public Edge<E> getParent() {
            return parent;
        }
        
        @Override
        public String toString(){
            return "VertexNode: " + element + "     label = " + label + "       parent = " + parent + "     location = " + location;      //data
        }
        
    }
    
    private class EdgeNode<E> implements Edge<E>{
        private  E element;
        private String label;
        private int location;
        private VertexNode<V,E> v, u;
        
        public EdgeNode(E element, int location, VertexNode<V,E> v, VertexNode<V,E> u){
            this.element = element;
            this.location = location;
            
            this.v = v;
            this.u = u;
        }
        
        @Override
        public void setLabel(String status) {
            label = status;
        }

        @Override
        public String getLabel() {
            return label;
        }
        
        public int location(){
            return location;
        }

        @Override
        public E element() {
            return element;
        }
        
        public String toString(){
            return "EdgeNode:     " + element + "     label = " + label + "   location = " + location + "     u = " + u.element + "   v = " + v.element;
        }
        
    }
    
    @Override
    public int numVertices() {
        return vertex.size();
    }

    @Override
    public int numEdges() {
        return edge.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertex;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return edge;
    }

    //NO CASTING IF VERTEX
    @Override
    public Iterable<Edge<E>> incidentEdges(Vertex<V> v) {
        LinkedList<Edge<E>> incidentEdge = new LinkedList();
        
        Iterator<Edge<E>> iter = edge.iterator();
        while(iter.hasNext()){
            EdgeNode<E> eNode = (EdgeNode<E>) iter.next();
            if(eNode.u == ((VertexNode)v) || eNode.v == ((VertexNode)v))
                incidentEdge.add(eNode);
        }
        /*
        Comparator c = new Comparator<Edge<E>>() {
            @Override
            public int compare(Edge<E> o1, Edge<E> o2) {
                if((Integer)o1.element() < (Integer)o2.element())//d(w) = d(v) + e.element()
                    return -1;
                else if((Integer)o1.element() > (Integer)o2.element())
                    return 1;
                
                return 0;
                
            }
        };
        incidentEdge.sort(c);
        
        iter = incidentEdge.iterator();
        while(iter.hasNext()){
            EdgeNode<E> eNode = (EdgeNode<E>) iter.next();
            System.out.print(eNode.element + "  ");
            System.out.println();
        }*/
        return incidentEdge;
        
    }
    
    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        //has to be part of the node
        VertexNode<V,E> vNode = (VertexNode<V,E>)v;
        VertexNode<V,E> opposite = null;
        int oppositeLocation = -1;
        
        EdgeNode<E> eNode = (EdgeNode<E>)e;
        
        if(vNode == eNode.u)
            oppositeLocation = eNode.v.location();
        else if(vNode == eNode.v)
            oppositeLocation = eNode.u.location();
        
        if(oppositeLocation == -1)
            return null;
        
        return vertex.get(oppositeLocation);
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        Vertex<V>[] vertices = new Vertex[1];
        EdgeNode<E> eNode = (EdgeNode<E>) e;
        
        vertices[0] = eNode.u;
        vertices[1] = eNode.v;
        
        return vertices;
    }

    @Override
    public boolean areAdjacent(Vertex<V> v, Vertex<V> u) {
        VertexNode<V,E> vNode = (VertexNode<V,E>)v;
        VertexNode<V,E> uNode = (VertexNode<V,E>)u;
        
        Iterator<Edge<E>> iter = edge.iterator();
        while(iter.hasNext()){
            EdgeNode<E> eNode = (EdgeNode<E>) iter.next();
            if((eNode.u == uNode && eNode.v == vNode) || (eNode.u == vNode && eNode.v == uNode))
                return true;
        }
        
        return false;
    }
    
    @Override
    public V replace(Vertex<V> v, V o) {
        V old = v.element();
        VertexNode<V,E> temp = (VertexNode<V,E>) v;
        vertex.set(temp.location, new VertexNode(o, temp.location));
        return old;
    }

    @Override
    public E replace(Edge<E> e, E o) {
        E old = e.element();
        EdgeNode<E> temp = (EdgeNode<E>) e;
        edge.set(temp.location, new EdgeNode(o, temp.location, temp.v, temp.u));
        return old;
    }

    @Override
    public Vertex<V> insertVertex(V o) {
        Vertex<V> v = new VertexNode(o, vertex.size());
        vertex.add(v);
        return v;
    }

    @Override
    public V removeVertex(Vertex<V> v) {
        return vertex.remove(((VertexNode<V,E>)v).location).element();
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E o) {
        //VertexNode<V> vNode = (VertexNode<V>) v;
        Edge<E> e = new EdgeNode(o, edge.size(), ((VertexNode<V,E>)u), ((VertexNode<V,E>)v));
        edge.add(e);
        return e;
    }

    @Override
    public E removeEdge(Edge<E> e) {
        return edge.remove(((EdgeNode<E>)e).location).element();
    }
    
}
