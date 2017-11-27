/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PqTester;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author luca
 * @param <K>
 * @param <V>
 */
public class ListPQ<K,V> implements PriorityQueue<K,V> {
    private ArrayList<Entry<K,V>> list;
    
    public ListPQ(){
        list = new ArrayList();
    }
    
    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        Entry<K, V> temp = new SimpleEntry(key, value);
       
        list.add(temp);
        
        /*        System.out.println("insert " + temp);
        
        System.out.println("-- full list");
        
        Iterator<Entry<K,V>> iter1 = list.iterator();
        while(iter1.hasNext())
        System.out.println(iter1.next());
        
        System.out.println("-- end list");
        System.out.println();*/
        
        return temp;
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        Iterator<Entry<K,V>> iter = list.iterator();
        SimpleEntry<K,V> min = (SimpleEntry<K,V>) iter.next();
        
        while(iter.hasNext()){
            SimpleEntry<K,V> entry = (SimpleEntry<K,V>) iter.next();
            if(entry.compareTo(min) < 0)
                min = entry;
        }
        return min;   
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        Entry<K,V> min = min();
        list.remove(min);
        System.out.print("removeMin ");
        return min;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }
    
}
