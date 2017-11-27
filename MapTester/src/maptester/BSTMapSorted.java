/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maptester;
import tree.*;
/**
 *
 * @author luca
 */

//BinaryTree diventa BST
public class BSTMapSorted<K, V> implements Map<K, V> {
    //overrides entry if available
    BSTree<Entry<K, V>> t;
    
    public BSTMapSorted() throws NonEmptyTreeException{
        t = new BSTree();   //albero vuoto
        t.addRoot(null);
    }
    
    @Override
    public V put(K key, V val) {
        V oldV = null;
        try {
            Position<Entry<K, V>> old = searchInBST(t, key, t.root());
            
            t.replace(old, new EntrySet(key, val));
            
            oldV = old.element().getValue();
            //aggiungo nodo se placeholder, aggiorno valore se presente
        } catch (EmptyTreeException | InvalidPositionException | BoundaryViolationException ex) {
            
        }
        return oldV;
        
    }

    @Override
    public V get(K key) {
        try {
            return searchInBST(t, key, t.root()).element().getValue();
        } catch (EmptyTreeException | InvalidPositionException | BoundaryViolationException ex) {
            
        }
        
        return null;
    }

    @Override
    public V remove(K key) {
        V oldV = null;
        try {
            Position<Entry<K, V>> toRemove = searchInBST(t, key, t.root());
            if(toRemove.element().getKey() == null && toRemove.element().getValue() == null)
                return null;
            
            oldV = toRemove.element().getValue();
            t.remove(toRemove);
            
            //aggiungo nodo se placeholder, aggiorno valore se presente
        } catch (EmptyTreeException | InvalidPositionException | BoundaryViolationException ex) {
            
        }
        return oldV;
    }

    @Override
    public Iterable<K> keys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<V> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return t.isEmpty();
    }

    @Override
    public int size() {
        return t.size();
    }
    
    private Position<Entry<K, V>> searchInBST(BSTree<Entry<K, V>> t, K k, Position<Entry<K, V>> v) throws InvalidPositionException, BoundaryViolationException{
        if(t.isExternal(v))
            return v;
        else if(k == v.element().getKey())
            return v;
        else if((Integer)k < (Integer)v.element().getKey())
            return searchInBST(t, k, t.left(v));
        else
            return searchInBST(t, k, t.right(v));
    }
    
}
