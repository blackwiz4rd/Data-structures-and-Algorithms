/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maptester;

/**
 *
 * @author luca
 */
public class EntrySet<K,V> implements Entry<K,V> {
    private V value;
    private K key;
    
    @Override
    public String toString(){
        return key +  " " + value;
    }
    
    EntrySet(K newKey, V newValue){
        key = newKey;
        value = newValue;
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
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
    
}
