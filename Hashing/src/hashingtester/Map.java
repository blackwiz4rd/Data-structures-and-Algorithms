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
 */

//chiavi anche non ordinabili, solo .equals (di Object) è richiesto
public interface Map<K,V> extends Container{
    V put(K key, V val);    //inserisce anche se già presente
    V get(K key);   //null = valore invalido
    V remove(K key);    //null = valore invalido
    
    Iterable<K> keys();     //in corrispondenza delle values ma in ordine casuale
    Iterable<V> values();
}
