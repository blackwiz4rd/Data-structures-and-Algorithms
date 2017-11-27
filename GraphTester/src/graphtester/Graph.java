/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtester;

/**
 *
 * @author luca
 * @param <V>
 * @param <E>
 */
public interface Graph<V,E> {   //non orientato
    int numVertices();
    int numEdges();
    
    Iterable<Vertex<V>> vertices(); //tetha(n)
    Iterable<Edge<E>> edges();  //tetha(m)
    Iterable<Edge<E>> incidentEdges(Vertex<V> v);
    
    Vertex<V> opposite(Vertex<V> v, Edge<E> e);
    Vertex<V>[] endVertices(Edge<E> e);
    
    boolean areAdjacent(Vertex<V> v, Vertex<V> u);
    
    V replace(Vertex<V> v, V o);
    E replace(Edge<E> e, E o);
    
    Vertex<V> insertVertex(V o);
    V removeVertex(Vertex<V> v);
    
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E o);
    E removeEdge(Edge<E> e);
    
    
}
