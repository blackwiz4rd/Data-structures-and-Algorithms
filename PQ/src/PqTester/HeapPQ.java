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

//uno heap è un albero binario completo!
public class HeapPQ<K,V> implements PriorityQueue<K,V> {
    ArrayHeap<K,V> heap;
    
    public HeapPQ(){
        heap = new ArrayHeap();
    }
    
    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        //modificato per rispettare la prop heap
        //O(logn)
        return (Entry<K, V>) heap.add(new SimpleEntry(key, value)).element();
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        //O(1)
        Entry<K,V> entry = null;
        try{
            entry = heap.root().element();
        }
        catch(EmptyTreeException e){
            
        }
        return entry;
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        //O(logn) aggiusta l'albero per rispettare la prop di heap
        Entry<K,V> entry = null;
        try{
            entry = heap.remove();
        }
        catch(EmptyTreeException e){
            
        }
        return entry;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }
    
}
