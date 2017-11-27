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

//K insieme totalmente ordinato, livelli di priorità
public interface PriorityQueue<K,V> extends Container{
    Entry<K,V> insert(K key, V value) throws InvalidKeyException; //if keys are not in the sorted set
    Entry<K,V> min() throws EmptyPriorityQueueException;    //coppia con chiave minima
    Entry<K,V> removeMin() throws EmptyPriorityQueueException;
}