/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PqTester;

/**
 *
 * @author luca
 */
public class SimpleEntry<K,V> implements Entry<K,V>, Comparable<Entry<K,V>>{
    private K key;
    private V value;
    
    public SimpleEntry(K k, V v){
        key = k;
        value = v;
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

    @Override
    //compare couples
    public int compareTo(Entry<K, V> o) {
        if(o.getKey() instanceof Comparable && getKey() instanceof Comparable){
            Comparable a = (Comparable) getKey();
            Comparable b = (Comparable) o.getKey();
            
            return a.compareTo(b);
        }
        return 0;
    }
    
    @Override
    public String toString(){
        return getKey() + " " + getValue();
    }

}
