/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maptester;

import java.util.LinkedList;

/**
 *
 * @author luca
 */
public class ArrayMultiMapSorted<K,V> implements MultiMap<K,V>{
    Entry<K,V> e[];
    int eSize;
    int INITSIZE = 100;
    
    public ArrayMultiMapSorted(){
        e = new Entry[INITSIZE];
        for(int i = 0; i < e.length; i++)
            e[i] = new EntrySet(null,null);
        eSize = 0;
    }
    
    //inserisco coppie ed eseguo insertionSort
    //ci possono essere coppie con la stessa chiave
    @Override
    public Entry<K, V> put(K key, V val) {
        e[eSize] = new EntrySet(key, val);
        Entry<K, V> added = e[eSize++];
        insertionSort(e, eSize);
        
        return added;
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> entry) {
        Entry<K, V> remove = entry;
        int index = binarySearch(e, entry.getKey(), eSize);
        for(int i = index; i < eSize - 1; i++)
            e[i] = e[i + 1];
        eSize--;
        return remove;
    }

    @Override
    public Entry<K, V> get(K key) {
        return e[binarySearch(e, key, eSize - 1)];
    }

    @Override
    public Iterable<Entry<K, V>> getAll(K key) {
        LinkedList<Entry<K, V>> entries = new LinkedList(); 
        Entry<K, V> tmp = get(key);
        int i = binarySearch(e, key, eSize - 1);
        int p = -1;
        for(i = eSize - 1; i >= 0 && e[i].getKey().equals(key); i--)
            p = i;
        
        for(int j = p; j <= eSize - 1 && e[j].getKey().equals(key); j++)
            entries.add(e[j]);
        
        return entries;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        LinkedList<Entry<K, V>> entries = new LinkedList();
        for(int i = 0; i < eSize; i++)
            entries.add(e[i]);
        
        return entries;
    }

    @Override
    public Iterable<K> keys() {
        LinkedList<K> keys = new LinkedList();
        for(int i = 0; i < eSize; i++)
            keys.add(e[i].getKey());
        
        return keys;
    }

    @Override
    public Iterable<V> values() {
        LinkedList<V> values = new LinkedList();
        for(int i = 0; i < eSize; i++)
            values.add(e[i].getValue());
        
        return values;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return eSize;
    }
    
    private void insertionSort(Entry<K,V>[] e, int eSize) {
     int j = 0;
     for(int i = 1; i < eSize; i++){
         Entry<K,V> tmp = e[i];
         //System.out.println(" "+tmp);
         for(j = i - 1; (j >= 0)&&((Integer)e[j].getKey() > (Integer)tmp.getKey()); j--)
             e[j + 1] = e[j];   //scambia successivo con precedente
         
         e[j + 1] = tmp;
     }
        
        
        
        
     /*int j; //N.B. dichiaro qui j altrimenti non può essere vista dall'ultima istruzione 
        for (int i = 1; i < eSize; i++) {
           Entry<K,V> tmp = array[i];  // l'elemento viene rimosso dalla lista

           for (j = i - 1; (j >= 0) && ((Integer)array[j].getKey() > (Integer)tmp.getKey()); j--) {
               array[j + 1] = array[j];
           }

           array[j + 1] = tmp;  // l'elemento rimosso viene reinserito nella giusta posizione
                          // del sottoinsieme ordinato 0..i
        }*/
    }
    
    private int binarySearch(Entry<K, V>[] e, K key, int size) {
        return binarySearch(e, key, 0, size);
    }

    private int binarySearch(Entry<K, V>[] e, K key, int from, int to) {
        int mid = (from + to)/2;
        Entry<K, V> midEntry = e[mid];
        K midKey = midEntry.getKey();
        //CASO BASE
        if(from > to)
            return -1;
        //System.out.println(from + " " + to + " " + mid);
        //System.out.println(midEntry);
        
        if(midKey.equals(key))
            return mid;
        else if((Integer)key < (Integer)midKey)
            return binarySearch(e, key, from, mid);
        else
            return binarySearch(e, key, mid + 1, to);
    }
    
    
    
}
