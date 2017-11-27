/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PqTester;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author luca
 */
public class PQTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidKeyException, EmptyPriorityQueueException, NonEmptyTreeException, EmptyTreeException, BoundaryViolationException, InvalidPositionException {
        //SONO MIN PQ
        /*ListPQ listPQ = new ListPQ();
        System.out.println("LISTPQ");
        listPQ.insert(2, "pasta");
        listPQ.insert(2, "percoche");
        listPQ.insert(3, "latte");
        listPQ.insert(1, "spazzolino");
        listPQ.insert(4, "biscotti");
        System.out.println(listPQ.min());
        System.out.println(listPQ.removeMin());
        
        System.out.println();
        System.out.println("sortPQ");
        Algorithms.sortPQ(listPQ);
        
        System.out.println();
        System.out.println("SORTEDLISTPQ");
        SortedListPQ sortedListPQ = new SortedListPQ();
        sortedListPQ.insert(2, "pasta");
        sortedListPQ.insert(2, "percoche");
        sortedListPQ.insert(3, "latte");
        sortedListPQ.insert(1, "spazzolino");
        sortedListPQ.insert(4, "biscotti");
        System.out.println(sortedListPQ.min());
        System.out.println(sortedListPQ.removeMin());
        
        System.out.println();
        System.out.println("sortPQSortedList"); //perchè ordinarla se lo è già?
        Algorithms.sortPQ(sortedListPQ);*/
        
        System.out.println();
        System.out.println("heapPQ");
        HeapPQ heapPQ = new HeapPQ();
        
        heapPQ.insert(3, "pasta");
        heapPQ.insert(7, "percoche");
        heapPQ.insert(6, "latte");
        heapPQ.insert(1, "spazzolino");
        heapPQ.insert(5, "biscotti");
        
        heapPQ.removeMin();
        System.out.println("min " + heapPQ.min());
        //Algorithms.sortPQ(heapPQ);
        String s = "what";
        System.out.println(Exercises.select(s.toCharArray(), s.length(), 3));  //finds the k-th smallest element, k = 1 smallest
        
        //EXERCICES
        System.out.println("EXERCICES");
        //ES37
        LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<>();  //root
        LinkedBinaryTree<Integer> t2 = new LinkedBinaryTree<>();  //root
        createBT(t1,t2);
        Exercises.unifyUncompleteTrees(t1, t2);
        
        //ES38: ERRARTO
        LinkedList[] l = new LinkedList[2];
        for(int i = 0; i < l.length; i++)
            l[i] = new LinkedList();
        l[0].add(19);
        l[0].add(33);
        l[0].add(68);
        
        l[1].add(22);
        l[1].add(55);
        l[1].add(90);
        Iterator<Integer> iter = Exercises.mergeK(l).iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    }
    
    private static void createBT(LinkedBinaryTree<Integer> t1,LinkedBinaryTree<Integer> t2) throws NonEmptyTreeException, EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        t1.addRoot(0);
        
        t1.addLeft(t1.root(), 1);
        t1.addRight(t1.root(), 2);
        
        t1.addLeft(t1.left(t1.root()), 3);
        t1.addRight(t1.left(t1.root()), 4);
        
        t1.addLeft(t1.right(t1.root()), 5);
        t1.addRight(t1.right(t1.root()), 6);
        
        t1.addLeft(t1.left(t1.left(t1.root())), 7);
        t1.addRight(t1.left(t1.left(t1.root())), 8);
        
        
        
        t2.addRoot(0);
        
        t2.addLeft(t2.root(), 1);
        t2.addRight(t2.root(), 2);
        
        t2.addLeft(t2.left(t2.root()), 3);
        t2.addRight(t2.left(t2.root()), 4);
        
        t2.addLeft(t2.right(t2.root()), 5);
        t2.addRight(t2.right(t2.root()), 6);
        
        t2.addLeft(t2.left(t2.left(t2.root())), 7);
        t2.addRight(t2.left(t2.left(t2.root())), 8);
    }
    
}
