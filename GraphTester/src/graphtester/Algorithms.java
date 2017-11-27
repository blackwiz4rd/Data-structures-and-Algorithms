/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtester;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author luca
 * @param <V>
 * @param <E>
 */
public class Algorithms<V,E> {
    //Depth-First Search : DOVREBBE RESTITUIRE ALMENO CONNECTEDCOMPONENTS
    public void DFS(Graph G){   //theta(n+m)
        //imposta ogni vertice come inesplorato
        Iterator<Vertex<V>> iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> u = iterV.next();
            u.setLabel("UNEXPLORED");
        }
        
        //imposta ogni ramo inesplorato
        Iterator<Edge<E>> iterE = G.edges().iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            e.setLabel("UNEXPLORED");
        }
        
        int connectedComponents = 0;
        //per ogni vertice se inesplorato attraversa la sua comp. connessa
        iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> v = iterV.next();
            if("UNEXPLORED".equals(v.getLabel()))
                connectedComponents++;
                DFS(G, v);
        }
    }

    private void DFS(Graph G, Vertex<V> s) {
        //visita il nodo e i suoi rami incidenti, poi passa al nodo opposto
        s.setLabel("VISITED");
        Iterator<Edge<E>> iterE = G.incidentEdges(s).iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            if("UNEXPLORED".equals(e.getLabel()))
                e.setLabel("VISITED");
            
            //è un vertice
            Vertex<V> w = G.opposite(s, e);
            if("UNEXPLORED".equals(w.getLabel()))
                DFS(G, w);
        }
    }
    
    //DOVREBBE RESTITUIRE UNA PILA CON LA SPANNING FOREST PER ESSERE UTILE
    public void findSpanningForest(Graph G){
        Iterator<Vertex<V>> iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> u = iterV.next();
            u.setLabel("UNEXPLORED");
        }
        
        Iterator<Edge<E>> iterE = G.edges().iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            e.setLabel("UNEXPLORED");
        }
        
        int connectedComponents = 0;
        
        iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> v = iterV.next();
            if("UNEXPLORED".equals(v.getLabel()))
                connectedComponents++;
                DFS(G, v);
        }
    }
    
    
    
    private void findSpanningForest(Graph G, Vertex<V> s) {
        s.setLabel("VISITED");
        Iterator<Edge<E>> iterE = G.incidentEdges(s).iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            if("UNEXPLORED".equals(e.getLabel())){
                Vertex<V> w = G.opposite(s, e);
                //imposta il ramo come discovery o back
                if("UNEXPLORED".equals(w.getLabel())){    
                    e.setLabel("DISCOVERY");
                    DFS(G,w);   //visita il nodo
                }
                else{
                    e.setLabel("BACK");
                }
            } 
        }
    }
    
    
    public boolean hasCycle(Graph G){
        findSpanningForest(G);  //imposta le labels
        //per risparmiare tempo potrei copiare il codice e modificarlo
        
        //se ha rami BACK ha un ciclo
        Iterator<Edge<E>> iterE = G.edges().iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            if("BACK".equals(e.getLabel()))
                return true;
        }
        
        return false;
    }
    
    //se NON ha rami di tipo back -> NON ha cicli, è foresta
    public boolean isForest(Graph G){
       if(!hasCycle(G)){
           return true;
       }
       
       return false;
    }
    
    //pathExistsDFS
    public boolean pathDFS(Graph G, Vertex<V> v, Vertex<V> z){
        //imposta ogni vertice come inesplorato
        Iterator<Vertex<V>> iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> u = iterV.next();
            u.setLabel("UNEXPLORED");
        }
        
        //imposta ogni ramo inesplorato
        Iterator<Edge<E>> iterE = G.edges().iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            e.setLabel("UNEXPLORED");
        }
        
        //LA STACK E' INUTILIZZATA!
        Stack S = new Stack();
        return pathDFS(G, v, z, S);
    }

    private boolean pathDFS(Graph G, Vertex<V> v, Vertex<V> z, Stack S) {
        //visita il nodo e i suoi rami incidenti, poi passa al nodo opposto
        v.setLabel("VISITED");
        S.push(v);
        //CASO BASE
        if(v.equals(z))
            return true;
        
        Iterator<Edge<E>> iterE = G.incidentEdges(v).iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            if("UNEXPLORED".equals(e.getLabel())){
                Vertex<V> w = G.opposite(v,e);
                if("UNEXPLORED".equals(w.getLabel())){
                    e.setLabel("DISCOVERY");
                    S.push(e);
                    //se esiste un percorso da w a z ritorna vero
                    if(pathDFS(G, w, z, S))
                        return true;
                    S.pop();    //tolgo edge, poichè non c'è percorso tra w e z
                }
                else{
                    e.setLabel("BACK");
                }
            }
        }
        S.pop();    //tolgo vertex, poichè non c'è percorso tra w e z
        return false;
    }
    
    
    
    
    
    
    public void BFS(Graph G){
        //imposta ogni vertice come inesplorato
        Iterator<Vertex<V>> iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> u = iterV.next();
            u.setLabel("UNEXPLORED");
        }
        
        //imposta ogni ramo inesplorato
        Iterator<Edge<E>> iterE = G.edges().iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            e.setLabel("UNEXPLORED");
        }
        
        int connectedComponents = 0;
        //per ogni vertice se inesplorato attraversa la sua comp. connessa
        iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> v = iterV.next();
            //System.out.println(v.getLabel());
            if("UNEXPLORED".equals(v.getLabel())){
                connectedComponents++;
                BFS(G, (VertexP<V, E>) v);  //non aggiorna G!!!!
                //System.out.println(connectedComponents);
            }
        }
    }
    
    private void BFS(Graph G, VertexP<V,E> s){
        LinkedList<Vertex<V>> L[] = new LinkedList[G.numVertices()];    //liste di Livelli: contengono vertici da visitare di ciascun livello del B
        
        L[0] = new LinkedList();
        L[0].addLast(s);
        
        s.setLabel("VISITED");  //vengono salvati solo questi
        s.setParent(null);
        
        int i = 0;
        while(!L[i].isEmpty()){
            L[i + 1] = new LinkedList();
            
            for(Vertex<V> v: L[i]){     //lista di vertici successivi da visitare, parte da L[0] = s L[1] = incident(s) = .., .., .., L[2] = ..
                Iterator<Edge<E>> iterE = G.incidentEdges(v).iterator();
                while(iterE.hasNext()){
                    Edge<E> e = iterE.next();
                    if(e.getLabel().equals("UNEXPLORED")){
                        VertexP<V,E> w = (VertexP<V,E>) G.opposite(v, e);
                        if(w.getLabel().equals("UNEXPLORED")){
                            e.setLabel("DISCOVERY");
                            w.setLabel("-VISITED");
                            w.setParent((Edge<E>)e);
                            
                            L[i + 1].addLast(w);
                        }
                        else{
                            e.setLabel("CROSS");
                        }
                    }
                }
            }
            
            i++;
        }
        
    }
    
    public void printPath(Graph G,Vertex<V> s,Vertex<V> v){
        if(!v.equals(s)){
            Vertex<V> u = G.opposite(v, ((VertexP<V,E>)v).getParent());
            printPath(G, s, u);
            System.out.println(((VertexP<V,E>)v).getParent());    //must
        }
        System.out.println(v);    //must
    }
    
    public void Dijkstra(Graph G){
        //imposta ogni vertice come inesplorato
        Iterator<Vertex<V>> iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> u = iterV.next();
            u.setLabel("inf");
        }
        
        //imposta ogni ramo inesplorato
        Iterator<Edge<E>> iterE = G.edges().iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            e.setLabel("UNEXPLORED");
        }
        
        int connectedComponents = 0;
        //per ogni vertice se inesplorato attraversa la sua comp. connessa
        iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> v = iterV.next();
            //System.out.println(v.getLabel());
            if("inf".equals(v.getLabel())){
                connectedComponents++;
                Dijkstra(G, (VertexP<V, E>) v);  //non aggiorna G!!!!
                //System.out.println(connectedComponents);
            }
        }
    }
    
    private void Dijkstra(Graph G, VertexP<V,E> s){
        LinkedList<Vertex<V>> L[] = new LinkedList[G.numVertices()];    //liste di Livelli: contengono vertici da visitare di ciascun livello del B
        
        L[0] = new LinkedList();
        L[0].addLast(s);
        
        s.setLabel(""+0);   //da modificare
        s.setParent(null);
        
        int i = 0;
        while(!L[i].isEmpty()){
            L[i + 1] = new LinkedList();
            
            for(Vertex<V> v: L[i]){     //lista di vertici successivi da visitare, parte da L[0] = s L[1] = incident(s) = .., .., .., L[2] = ..
                Iterator<Edge<E>> iterE = G.incidentEdges(v).iterator();
                while(iterE.hasNext()){
                    Edge<E> e = iterE.next();
                    
                    if(e.getLabel().equals("UNEXPLORED")){
                        VertexP<V,E> w = (VertexP<V,E>) G.opposite(v, e);
                        
                        System.out.println(v.element() + "" + w.element() + " distance: "+ e.element());
                        
                        if(w.getLabel().equals("inf")){
                            e.setLabel("DISCOVERY");
                            int dw = Integer.parseInt(v.getLabel()) + Integer.parseInt("" + e.element());
                            //if(dw < Integer.parseInt(w.getLabel()) || w.getLabel().equals("inf"))
                            w.setLabel(""+dw);    //errato: d(w) = d(v) + e.element()
                            w.setParent((Edge<E>)e);    
                            
                            L[i + 1].addLast(w);
                        }
                        else{
                            e.setLabel("CROSS");
                        }
                    }
                }
            }
            
            i++;
        }
        
    }
    
    //solo per controllo
    public void getAllParents(Graph G){
        Iterator<Vertex<V>> iter = G.vertices().iterator();
        while(iter.hasNext())
        {
            VertexP<V,E> v = (VertexP<V,E>)iter.next();
            if(v.getParent()!=null)
                System.out.println(v.getParent());
        }
    }
    
    //Esame2 - Esercizio 3: vertici adiacenti con colori diversi O(n+m) oppure non colorabile
        public boolean paintGraph(Graph G){
        //imposta ogni vertice come inesplorato O(n + m) n = nodi, m = rami
        Iterator<Vertex<V>> iterV = G.vertices().iterator();
        while(iterV.hasNext()){
            Vertex<V> u = iterV.next();
            u.setLabel("UNCOLORED");
        }
        
        //imposta ogni ramo inesplorato
        Iterator<Edge<E>> iterE = G.edges().iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            e.setLabel("UNEXPLORED");
        }
        
        iterV = G.vertices().iterator();
        return paintGraph(G, iterV.next(), false);
    }

    private boolean paintGraph(Graph G, Vertex<V> s, boolean color) {
        //visita il nodo e i suoi rami incidenti, poi passa al nodo opposto
        s.setLabel("COLORED " + color);
        Iterator<Edge<E>> iterE = G.incidentEdges(s).iterator();
        while(iterE.hasNext()){
            Edge<E> e = iterE.next();
            if("UNEXPLORED".equals(e.getLabel()))
                e.setLabel("VISITED");
            
            //è un vertice
            Vertex<V> w = G.opposite(s, e);
            if("UNCOLORED".equals(w.getLabel()))
                return paintGraph(G, w, !color);
            
            //if(e.getLabel().equals("UNEXPLORED") || w.getLabel().equals("UNCOLORED"))
              //  return false;                
        }
        
        return false;
    }
}