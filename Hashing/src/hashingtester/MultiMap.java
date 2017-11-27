/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashingtester;

/**
 *
 * @author luca
 * @param <K>
 * @param <V>
 */

//DIZIONARIO
public interface MultiMap<K,V> extends Container {
    Entry<K,V> put(K key, V val);
    Entry<K,V> remove(Entry<K,V> entry);    //perchè ci sono coppie con la stessa chiave, non solo k
    Entry<K,V> get(K key);
    
    //tutte le coppie di una chiave
    Iterable<Entry<K,V>> getAll(K key);
    //tutte le coppie del dizionario
    Iterable<Entry<K,V>> entries();
    
    Iterable<K> keys(); //ci possono duplicati
    Iterable<V> values();
    
}
