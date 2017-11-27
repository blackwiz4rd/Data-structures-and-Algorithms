/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PqTester;

import java.util.Iterator;

/**
 *
 * @author luca
 * @param <T>
 */

//non ho apportato modifiche per controllare se completo etc.
public class ArrayCompleteBT<T> implements CompleteBinaryTree<T> {
    private Position<T> v[];
    private Position<T> root;
    private int vSize;
    private final int INITSIZE = 100;
    
    public ArrayCompleteBT(){
        v = new Position[INITSIZE];
        //for(int i = 0; i < INITSIZE; i++)
          //  v[i] = new BTNode(null);
        vSize = 0;
        root = v[0];
    }
    
    private class BTNode<T> implements Position<T>{
        private T element;
        private BTNode<T> left;
        private BTNode<T> right;
        private BTNode<T> parent;

        public BTNode(T element){
            this.element = element;
            this.left = null;
            this.right = null;
            
            System.out.println("Nodo aggiunto " + element);
        }
        
        public void setElement(T element){
            this.element = element;
        }
        
        public void setParent(BTNode<T> parent){
            this.parent = parent;
        }
        
        public void setLeft(BTNode<T> left){
            this.left = left;
        }
        
        public void setRight(BTNode<T> right){
            this.right = right;
        }
        
        @Override
        public T element() {
            return element;
        }
        
        public BTNode<T> getParent(){
            return parent;
        }
        
        public BTNode<T> getLeft(){
            return left;
        }
        
        public BTNode<T> getRight(){
            return right;
        }
        
        @Override
        public String toString(){
            return ""+element();    //da rivedere il casting da T a String
        }
    }
    
    private BTNode<T> checkPosition(Position<T> v){
        if(!isEmpty())
            return (BTNode<T>)v;
        return null;    //invalid pos
    }
    
    @Override
    public Position<T> add(T element) {
        return v[vSize++] = new BTNode(element);
    }

    @Override
    public T remove() throws EmptyTreeException {
        return v[--vSize].element();
    }

    //TUTTI I METODI SOTTO NON CI INTERESSANO: CHE BELLO!! :D
    
    @Override
    public boolean hasLeft(Position<T> v) throws InvalidPositionException {
        BTNode<T> n = checkPosition(v);
        return (n.left != null);
    }

    @Override
    public boolean hasRight(Position<T> v) throws InvalidPositionException {
        BTNode<T> n = checkPosition(v);
        return (n.right != null);
    }

    @Override
    public Position<T> left(Position<T> v) throws BoundaryViolationException, InvalidPositionException {
        BTNode<T> n = checkPosition(v);
        if(hasLeft(n))
            return n.left;
        return new BTNode<>(null);
    }

    @Override
    public Position<T> right(Position<T> v) throws BoundaryViolationException, InvalidPositionException {
        BTNode<T> n = checkPosition(v);
        if(hasRight(n))
            return n.right;
        return new BTNode<>(null);
    }

    @Override
    public Position<T> root() throws EmptyTreeException {
        if(!isEmpty())
            return root;
        return new BTNode<>(null);
    }
    
    @Override
    public Position<T> parent(Position<T> v) throws BoundaryViolationException, InvalidPositionException {
        BTNode<T> n = checkPosition(v);
        return n.getParent();
    }

    @Override
    public Iterable<Position<T>> children(Position<T> v) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numChildren(Position<T> v) {
        BTNode<T> n = checkPosition(v);
        int numChildren = 0;
        if(n.getLeft()!=null)
            numChildren++;
        if(n.getRight()!=null)
            numChildren++;
        
        return numChildren;
    }

    @Override
    public boolean isRoot(Position<T> v) throws InvalidPositionException {
        return root == v;
    }

    @Override
    public boolean isInternal(Position<T> v) throws InvalidPositionException {
        BTNode<T> n = (BTNode<T>) v;
        return n.getLeft() != null || n.getRight() != null;
    }

    @Override
    public boolean isExternal(Position<T> v) throws InvalidPositionException {
        BTNode<T> n = (BTNode<T>) v;
        return n.getLeft() == null && n.getRight() == null;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Position<T>> positions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T replace(Position<T> v, T element) throws InvalidPositionException {
        T old = v.element();
        BTNode<T> n = (BTNode<T>) v;
        n.setElement(element);
        return old;
    }
    

    @Override
    public boolean isEmpty() {
        return vSize == 0;
    }

    @Override
    public int size() {
        return vSize;
    }
    
}
