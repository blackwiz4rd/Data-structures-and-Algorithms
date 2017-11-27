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
public interface Entry<K,V> {
    public K getKey();
    public V getValue();
    public V setValue(V newValue);
}
