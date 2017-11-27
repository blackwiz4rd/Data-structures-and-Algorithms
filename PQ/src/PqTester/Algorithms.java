/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PqTester;

/**
 *
 * @author luca
 * @param <K>
 * @param <V>
 */
public class Algorithms<K,V> {
    public static <K, V> void sortPQ(ListPQ<K, V> S) throws InvalidKeyException, EmptyPriorityQueueException{
        ListPQ<K, V> P = new ListPQ();
        while(!S.isEmpty()){
            Entry<K,V> minEntry = S.removeMin();
            P.insert(minEntry.getKey(), minEntry.getValue());
        }
        
        while(!P.isEmpty()){
            Entry<K,V> minEntry = P.removeMin();
            S.insert(minEntry.getKey(), minEntry.getValue());
        }
            
    }
    
    public static <K, V> void sortPQ(SortedListPQ<K, V> S) throws InvalidKeyException, EmptyPriorityQueueException{
        SortedListPQ<K, V> P = new SortedListPQ();
        while(!S.isEmpty()){
            Entry<K,V> minEntry = S.removeMin();
            P.insert(minEntry.getKey(), minEntry.getValue());
        }
        
        while(!P.isEmpty()){
            Entry<K,V> minEntry = P.removeMin();
            S.insert(minEntry.getKey(), minEntry.getValue());
        }
            
    }
    
    public static <K, V> void sortPQ(HeapPQ<K, V> S) throws InvalidKeyException, EmptyPriorityQueueException{
        HeapPQ<K, V> P = new HeapPQ();
        while(!S.isEmpty()){
            Entry<K,V> minEntry = S.removeMin();
            P.insert(minEntry.getKey(), minEntry.getValue());
        }
        
        while(!P.isEmpty()){
            Entry<K,V> minEntry = P.removeMin();
            S.insert(minEntry.getKey(), minEntry.getValue());
        }
            
    }
}
