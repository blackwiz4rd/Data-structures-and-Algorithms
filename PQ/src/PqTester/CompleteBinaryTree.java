/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PqTester;

/**
 *
 * @author luca
 * @param <T>
 */
public interface CompleteBinaryTree<T> extends BinaryTree<T>{
    Position<T> add(T element); //ultimo nodo
    T remove() throws EmptyTreeException;   //ultimo nodo
}
