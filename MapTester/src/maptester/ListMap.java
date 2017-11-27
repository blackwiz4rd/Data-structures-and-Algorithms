/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maptester;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author luca
 * @param <K>
 * @param <V>
 */
public class ListMap<K,V> implements Map<K,V> {
    private LinkedList<EntryNode<K,V>> l = new LinkedList();
    
    class EntryNode<K,V> implements Entry<K,V>{
        private K key;
        private V value;
        
//        System.out.println("key = " + key + ", value = " + value);
        
        public EntryNode(K key, V value){
            this.key = key;
            this.value = value;
            
            System.out.println(key + " " + value);
        }
        
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V old = value;
            value = newValue;
            return old;
        }
        
    }
    
    @Override
    public V put(K key, V val) {
        V old = null;
        int oldIndex = -1;
        int i = 0;
        
        
        Iterator<EntryNode<K,V>> iter = l.iterator();
        while(iter.hasNext()){
            EntryNode<K,V> en = iter.next();
            if(en.key.equals(key)){
                old = en.value;
                oldIndex = i;
            }
            i++;
        }
        
        if(old==null)
            l.add(new EntryNode(key, val));
        else
            l.set(oldIndex, new EntryNode(key, val));
        
        return old;
    }

    @Override
    public V get(K key) {
        Iterator<EntryNode<K,V>> iter = l.iterator();
        while(iter.hasNext()){
            EntryNode<K,V> en = iter.next();
            if(en.key.equals(key))
                return en.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        V old = null;
        int oldIndex = -1;
        int i = 0;
        
        
        Iterator<EntryNode<K,V>> iter = l.iterator();
        while(iter.hasNext()){
            EntryNode<K,V> en = iter.next();
            if(en.key.equals(key)){
                old = en.value;
                oldIndex = i;
            }
            i++;
        }
        
        l.remove(oldIndex);
        return old;
    }

    @Override
    public Iterable<K> keys() {
        LinkedList<K> keys = new LinkedList();
        Iterator<EntryNode<K,V>> iter = l.iterator();
        while(iter.hasNext())
            keys.add(iter.next().key);
        
        return keys;
    }

    @Override
    public Iterable<V> values() {
        LinkedList<V> values = new LinkedList();
        Iterator<EntryNode<K,V>> iter = l.iterator();
        while(iter.hasNext())
            values.add(iter.next().value);
        
        return values;
    }

    @Override
    public boolean isEmpty() {
        return l.size() == 0;
    }

    @Override
    public int size() {
        return l.size();
    }
    
}
