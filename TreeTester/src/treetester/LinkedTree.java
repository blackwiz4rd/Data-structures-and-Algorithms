/*
 * 2nd class created -> implements Tree  UNABLE TO BE COMPLETED, too hard to set childs, partents..
 */
package treetester;

import java.util.Iterator;

/**
 *
 * @author lucaattanasio
 * @param <T>
 */
public class LinkedTree<T> implements Tree<T> {
    class TreeNode<T> implements Position<T>{ //possiede un elemento
        private T element;
        private TreeNode<T> parent;
        private Iterable<Position<T>> children; //LISTA DI POSIZIONI ITERABILE
        
        public TreeNode(T element, TreeNode<T> parent, Iterable<Position<T>> children){
            this.element = element;
            this.parent = parent;
            this.children = children;
        }
        
        @Override
        public T element(){ //unica caratteristica importante all'esterno di questa classe
            return element;
        }
        
        public void setElement(T element){
            this.element = element;
        }
        
        public TreeNode<T> getParent(){
            return parent;
        }
        
        public void setParent(TreeNode<T> parent){
            this.parent = parent;
        }
        
        public Iterable<Position<T>> getChildren(){
            return children;
        }
        
        public void setChildren(Iterable<Position<T>> children){
            this.children = children;
        }
        
        //INCOMPLETE
        public void addChild(Position<T> child){
            
        }
        
        public Position<T> removeChild(Position<T> child){
            return child;
        }
        
    }
    
    public LinkedTree(){
        v = new TreeNode[INTSIZE]; //array di nodi
        vSize = 0;
        //makeEmpty
        for(int i = 0; i < INTSIZE; i++)
            v[i] = new TreeNode("empty", null, null);   //array di nodi inizializzato a valori nulli
        
        for(int i = 0; i < INTSIZE; i++)
           System.out.println(v[i].element());
    }
    
    @Override
    public Position<T> root() throws EmptyTreeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<T> parent(Position<T> v) throws BoundaryViolationException, InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Position<T>> children(Position<T> v) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numChildren(Position<T> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(Position<T> v) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(Position<T> v) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExternal(Position<T> v) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return vSize == 0;
    }

    @Override
    public int size() {
        return vSize;
    }
    
    private Position[] v;    //array di posizioni di nodi
    private int vSize;
    private static final int INTSIZE = 100;
}


