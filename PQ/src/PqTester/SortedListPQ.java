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
 */
public class SortedListPQ<K,V> implements PriorityQueue<K,V> {
    private ArrayList<Entry<K,V>> list;
    
    public SortedListPQ(){
        list = new ArrayList();
    }
    
    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        SimpleEntry<K, V> temp = new SimpleEntry(key, value);
        System.out.println("insert " + temp);
        
        int addIndex = 0;
        Iterator<Entry<K,V>> iter = list.iterator();
        boolean flag = true;
        while(iter.hasNext() && flag)
            if(temp.compareTo(iter.next()) > 0)
                addIndex++;
            else
                flag = false;
        
        list.add(addIndex, temp); //in order
        
        System.out.println("-- full list");
        
        Iterator<Entry<K,V>> iter1 = list.iterator();
        while(iter1.hasNext())
        System.out.println(iter1.next());
        
        System.out.println("-- end list");
        return temp;
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        return list.get(0);   
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        Entry<K,V> min = list.remove(0);
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
