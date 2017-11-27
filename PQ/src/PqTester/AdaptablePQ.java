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
public interface AdaptablePQ<K,V> extends PriorityQueue<K,V>{
    Entry<K,V> replaceKey(Entry<K,V> entry, K key) throws InvalidEntryException;
    Entry<K,V> replaceValue(Entry<K,V> entry, V value) throws InvalidEntryException, InvalidKeyException;
    Entry<K,V> remove(Entry<K,V> entry) throws InvalidEntryException;

    public static class InvalidEntryException extends Exception {

        public InvalidEntryException() {
        }
    }
}
