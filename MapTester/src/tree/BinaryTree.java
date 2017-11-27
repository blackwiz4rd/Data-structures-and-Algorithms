
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author luca
 */
public interface BinaryTree<T> extends Tree<T>{
    boolean hasLeft(Position<T> v) throws InvalidPositionException;
    boolean hasRight(Position<T> v) throws InvalidPositionException;
    
    Position<T> left(Position<T> v) throws BoundaryViolationException, InvalidPositionException;
    Position<T> right(Position<T> v) throws BoundaryViolationException, InvalidPositionException;
    
    /*!NON FANNO PARTE DELL'INTERFACCIA, USATO SOLO PER REALIZZARE LA CLASSE
    Position<T> addRoot(T element) throws NonEmptyTreeException;
    Position<T> addRight(Position<T> v, T element) throws InvalidPositionException;
    Position<T> addLeft(Position<T> v, T element) throws InvalidPositionException;
    
    Position<T> sibiling(Position<T> v) throws BoundaryViolationException, InvalidPositionException;
    Position<T> remove(Position<T> v) throws InvalidPositionException;
    Position<T> attach(Position<T> v, BinaryTree<T> left, BinaryTree<T> right) throws InvalidPositionException;
    !NON FANNO PARTE DELL'INTERFACCIA, USATO SOLO PER REALIZZARE LA CLASSE*/
}
