/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtester;

import java.util.Iterator;

/**
 *
 * @author luca
 * PD > TV
 * PD > TR
 * @param <V>
 * @param <E>
 */
public class GraphTester<V,E> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph<String,Integer> G = new EdgeListGraph<>();
        
        Vertex<String> temp = G.insertVertex("Padova");
        Edge<Integer> tempE = G.insertEdge(temp, G.insertVertex("Treviso"), 70);
        Vertex<String> temp2 = G.insertVertex("Trieste");
        G.insertEdge(temp, temp2, 150);
        
        //G.removeEdge(tempE);
        //G.removeVertex(temp);
        //G.replace(temp, "Genova");
        //G.replace(tempE, 80);
        
        //G.insertEdge(G.insertVertex("NYC"), G.insertVertex("Londra"), 7000);
     
        System.out.print("Vertices list: ");
        Iterator iterator = G.vertices().iterator();
        while(iterator.hasNext())
            System.out.print(((Vertex<String>)iterator.next()).element() + " ,");
        
        System.out.println();
        System.out.print("Edges list: ");
        Iterator iterator1 = G.edges().iterator();
        while(iterator1.hasNext())
            System.out.print(((Edge<Integer>)iterator1.next()).element() + " ,");
        
        System.out.println();
        System.out.println("numEdges: " + G.numEdges());
        System.out.println("numVertices: " + G.numVertices());  
        
        System.out.println();
        System.out.println("opposite: " + (G.opposite(temp, tempE)));
        System.out.println();
        
        
        Algorithms a = new Algorithms();
        
        System.out.println("DFS");
        a.DFS(G);
        
        iterator = G.vertices().iterator();
        while(iterator.hasNext())
            System.out.println((Vertex<String>)iterator.next());
        
        
        a.findSpanningForest(G);
        
        iterator = G.vertices().iterator();
        System.out.println("findSpanningForest");
        while(iterator.hasNext())
            System.out.println((Vertex<String>)iterator.next());
        
        System.out.println("pathDFS");
        System.out.println(a.pathDFS(G, temp, temp2));
        System.out.println();
        
        System.out.println("BFS");
        a.BFS(G);
        
        iterator = G.vertices().iterator();
        while(iterator.hasNext())
            System.out.println((Vertex<String>)iterator.next());

        iterator1 = G.edges().iterator();
        while(iterator1.hasNext())
            System.out.println((Edge<Integer>)iterator1.next());
        
        System.out.println("printPath");
        a.printPath(G, temp, temp2);
        
        
        
        
        
        
        //new graph
        G = new EdgeListGraph();
        Vertex<String> A = G.insertVertex("A");
        Vertex<String> B = G.insertVertex("B");
        Vertex<String> C = G.insertVertex("C");
        Vertex<String> D = G.insertVertex("D");
        Vertex<String> E = G.insertVertex("E");
        Vertex<String> F = G.insertVertex("F");
        
        Edge<Integer> AB = G.insertEdge(A,B, 8);
        Edge<Integer> AC = G.insertEdge(A,C, 2);
        Edge<Integer> AD = G.insertEdge(A,D, 4);
        
        
        Edge<Integer> BC = G.insertEdge(B,C, 7);
        Edge<Integer> CD = G.insertEdge(C,D, 1);
        
        
        Edge<Integer> BE = G.insertEdge(B,E, 2);
        Edge<Integer> EC = G.insertEdge(E,C, 3);
        Edge<Integer> CF = G.insertEdge(C,F, 9);
        Edge<Integer> FD = G.insertEdge(F,D, 5);
        
        System.out.println("BFS");
        a.BFS(G);
        
        iterator = G.vertices().iterator();
        while(iterator.hasNext())
            System.out.println((Vertex<String>)iterator.next());

        iterator1 = G.edges().iterator();
        while(iterator1.hasNext())
            System.out.println((Edge<Integer>)iterator1.next());
        
        System.out.println("printPath");
        a.printPath(G, A, F);
        
        /*System.out.println("Dijkstra");
        a.Dijkstra(G);
        
        iterator = G.vertices().iterator();
        while(iterator.hasNext())
            System.out.println((Vertex<String>)iterator.next());

        iterator1 = G.edges().iterator();
        while(iterator1.hasNext())
            System.out.println((Edge<Integer>)iterator1.next());
        
        System.out.println("printPath");
        a.printPath(G, A, F);*/
        
        
        Graph<String,Integer> GP = new EdgeListGraph<>();
        Vertex<String> A1 = GP.insertVertex("A");
        Vertex<String> B1 = GP.insertVertex("B");
        Vertex<String> C1 = GP.insertVertex("C");
        Vertex<String> D1 = GP.insertVertex("D");
        
        Edge<Integer> AB1 = GP.insertEdge(A1,B1, 8);
        Edge<Integer> AC1 = GP.insertEdge(A1,C1, 2);
        Edge<Integer> BD1 = GP.insertEdge(B1,D1, 4);
        Edge<Integer> CD1 = GP.insertEdge(C1,D1, 4);
        //Edge<Integer> AD1 = GP.insertEdge(A1,D1, 4);
        
        System.out.println("paintGraph");
        System.out.println("Colored: " + a.paintGraph(GP));
        
        iterator = GP.vertices().iterator();
        while(iterator.hasNext())
            System.out.println((Vertex<String>)iterator.next());

        iterator1 = GP.edges().iterator();
        while(iterator1.hasNext())
            System.out.println((Edge<Integer>)iterator1.next());
        
    }
    
}
