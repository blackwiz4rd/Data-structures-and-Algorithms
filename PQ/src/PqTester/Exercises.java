/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PqTester;

import java.util.LinkedList;

/**
 *
 * @author luca
 */
public class Exercises {
    
    //ES35 selezione k-esimo elemeneto
    public static char select(char[] S, int sSize, int k) throws InvalidKeyException, EmptyPriorityQueueException{
        //dato l'array di char lo inserisco in heap
        HeapPQ heap = new HeapPQ();
        for(int i = 0; i < S.length; i++)
            heap.insert((int)S[i], S[i]);
        for(int j = 0; j < k; j++)
            heap.removeMin();
        return (char) heap.min().getValue();
    }
    
    //ES37 UNIONE ALBERI NON COMPLETI (rispettano heap-property) -> ALBERO NON COMPLETO (RISPETTA HEAP-PROPERTY)
    //deve essere un metodo interno alla classe
    private static <T> Position<T> getLeaf(BinaryTree<T> t1) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        Position<T> v = t1.root();
        Position<T> next = t1.root();
        while(!t1.isExternal(v)){
            if(!t1.hasRight(v))
                next = t1.left(v);
            else{
                System.out.println(t1.left(v).element());
                if(t1.left(v).element() instanceof Integer){
                    if((Integer)t1.left(v).element() < (Integer)t1.right(v).element())
                        next = t1.left(v);
                    else
                        next = t1.right(v);
                }
            }
            
            v = next;
        }
        
        //remove leaf
        return next;
    }
    
    public static <T> BinaryTree<T> unifyUncompleteTrees(BinaryTree<T> t1, BinaryTree<T> t2) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException, NonEmptyTreeException{
        //seleziono una foglia di t1
        Position<T> leaf = getLeaf(t1);
        System.out.println("leaf " + leaf);
        LinkedBinaryTree<T> t = new LinkedBinaryTree();
        t.addRoot((T) leaf);
        //leaf sx = t1.root, leaf dx = t2.root
        //downheapbubling(t.root());
        return t;
    }
    
    //ES38
    public static <K,V> LinkedList mergeK(LinkedList[] l) throws InvalidKeyException, EmptyPriorityQueueException{
        LinkedList mergeL = new LinkedList();
        HeapPQ PQ = new HeapPQ();
        int k = l.length;
        for(int i = 0; i < k; i++)
            PQ.insert(l[i].removeFirst(), i);
        
        while(!PQ.isEmpty()){
                Entry<Integer,Integer> entry = PQ.removeMin();
                mergeL.addLast(entry.getKey());
                if(!l[entry.getValue()].isEmpty())
                    PQ.insert(l[entry.getValue()].removeFirst(), entry.getValue());
        }
        
        return mergeL;
    }
    
    //restituisce le prime m entries di h in ordine crescente, trovare le m chaivi più piccole in heap
    
    //può usare minPQ ausiliaria implementata tramite heap = heapPQ, dimensione max = 2m
    //heapPQ -> insert, min, removeMin()
    //devo inserire lo heap nella heapPQ e rimovereMin m volte
    public static <T> LinkedList minKeys(CompleteBinaryTree<T> heap, int m) throws EmptyTreeException, InvalidKeyException, EmptyPriorityQueueException{
        int n = heap.size();
        if(m > n)
            return null;
        LinkedList keys = new LinkedList();
        HeapPQ pq = new HeapPQ();
        //Entry entry = ;
        //pq.insert(pq, pq);
        pq.insert(((Entry) heap.root().element()).getKey(), ((Entry) heap.root().element()).getValue());    //devo usare una pq modificata: location-aware
        //deve memorizzare anche root()
        /*pq.insert(heap.root(), ((Entry) heap.root().element()).getKey(), ((Entry) heap.root().element()).getValue())*/
        
        int countdown = m;
        while(countdown > 0){
            m--;
            Entry entry = pq.removeMin();   //estraggo anche il riferimento al nodo, quindi ho sia entry che i figli
            //EntryNode entryNode = pq.removeMin();
            keys.addLast(entry);
            
            /*pq.insert(removed, ((Entry) removed.element()).getKey(), ((Entry) removed.element()).getValue())*/
        }
        return keys;
    }
}
