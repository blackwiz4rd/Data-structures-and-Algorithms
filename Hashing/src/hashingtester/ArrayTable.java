/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashingtester;

import java.util.LinkedList;

/**
 *
 * @author luca
 */
//chiavi intere comprese tra 0 e N-1
public class ArrayTable<K,V> implements Map<K,V> {
    Object[] e;
    int N;
    
    public ArrayTable(int N){   //se N - 1 non noto a priori applico un ridimensionamento e ..
        e = new Object[N];
        this.N = N;
    }
   
    public int keyInt(K key){
        int keyInt = (Integer)key;
        if(keyInt >= 0 && keyInt < N)
            return keyInt;
        return -1;
    }
    
    @Override
    public V put(K key, V val) {    //put diventa tetha(N), analisi ammortizzata
        int keyInt=keyInt(key);
        if(keyInt == -1)
            return null;
        
        V old = get(key);
        e[keyInt] = val;
        return old;
    }

    @Override
    public V get(K key) {
        return (V) e[keyInt(key)];
    }

    @Override
    public V remove(K key) {
        int keyInt=keyInt(key);
        if(keyInt == -1)
            return null;
        
        V removed = get(key);
        e[keyInt] = null;
        return removed;
    }

    @Override
    public Iterable<K> keys() {
        LinkedList l = new LinkedList();
        for(int i = 0; i < N; i++)
            l.add(i);
        return l;
    }

    @Override
    public Iterable<V> values() {
        LinkedList l = new LinkedList();
        for(int i = 0; i < N; i++)
            l.add(e[i]);
        return l;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }
    
}
