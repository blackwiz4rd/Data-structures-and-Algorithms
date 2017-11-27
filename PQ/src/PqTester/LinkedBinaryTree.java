package PqTester;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


return new BTNode<T>(null); is not a node, it's an invalid node to keep the program working
 */



/**
 *
 * @author luca
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTree<T>{
    private Position<T> root;
    private ArrayList<Position<T>> nodes;
    
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
    
    @Override
    public String toString(){
        String s = "";
        Iterator<T> iter = iterator();
        while(iter.hasNext())
            s += iter.next() + ", ";
        return s;
    }
    
    public LinkedBinaryTree(){
        nodes = new ArrayList<>();
    }

    //da rivedere
    private BTNode<T> checkPosition(Position<T> v){
        if(!isEmpty())
            return (BTNode<T>)v;
        return null;    //invalid pos
    }
    
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
    /*!NON FANNO PARTE DELL'INTERFACCIA, USATO SOLO PER REALIZZARE LA CLASSE*/
    public Position<T> addRoot(T element) throws NonEmptyTreeException {
        if(!isEmpty())
            throw new NonEmptyTreeException();
        root = new BTNode<>(element);
        nodes.add(root);
        return root;
    }

    public Position<T> addRight(Position<T> v, T element) throws InvalidPositionException {
        if(hasRight(v))
            throw new InvalidPositionException();
        BTNode<T> p = (BTNode<T>) v;
        BTNode<T> n = new BTNode<>(element);
        p.setRight(n);
        n.setParent(p);
        
        nodes.add(n);
        return n;
    }

    public Position<T> addLeft(Position<T> v, T element) throws InvalidPositionException {
        if(hasLeft(v))
            throw new InvalidPositionException();
        BTNode<T> p = (BTNode<T>) v;
        BTNode<T> n = new BTNode<>(element);
        p.setLeft(n);
        n.setParent(p);
        
        nodes.add(n);
        return n;
        
    }

    public Position<T> sibiling(Position<T> v) throws BoundaryViolationException, InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Position<T> remove(Position<T> v) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Position<T> attach(Position<T> v, BinaryTree<T> left, BinaryTree<T> right) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*!NON FANNO PARTE DELL'INTERFACCIA, USATO SOLO PER REALIZZARE LA CLASSE*/
    
    @Override
    public Position<T> root() throws EmptyTreeException {
        if(!isEmpty())
            return root;
        return new BTNode<>(null);
    }

    @Override
    public Position parent(Position v) throws BoundaryViolationException, InvalidPositionException {
        BTNode<T> n = checkPosition(v);
        return n.getParent();
    }

    @Override
    public Iterable<Position <T>> children(Position<T> v) throws InvalidPositionException {
        ArrayList<Position<T>> children = new ArrayList<>();
        BTNode<T> n = checkPosition(v);
        
        children.add(n.left);
        children.add(n.right);
        
        //System.out.println("children " + n.left + " " + n.right);
        
        return children;
    }

    @Override
    public int numChildren(Position v) {
        BTNode<T> n = checkPosition(v);
        int numChildren = 0;
        if(n.getLeft()!=null)
            numChildren++;
        if(n.getRight()!=null)
            numChildren++;
        
        return numChildren;
    }

    @Override
    public boolean isRoot(Position v) throws InvalidPositionException {
        return root == v;
    }

    @Override
    public boolean isInternal(Position v) throws InvalidPositionException {
        BTNode<T> n = (BTNode<T>) v;
        return n.getLeft() != null || n.getRight() != null;
    }

    @Override
    public boolean isExternal(Position v) throws InvalidPositionException {
        BTNode<T> n = (BTNode<T>) v;
        return n.getLeft() == null && n.getRight() == null;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<Position<T>> iter = positions().iterator();
        ArrayList<T> elements = new ArrayList<>();
        while(iter.hasNext())
            elements.add(iter.next().element());
        return elements.iterator();
    }

    @Override
    public Iterable<Position<T>> positions() {
        return nodes;
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
        return nodes.isEmpty();
    }

    @Override
    public int size() {
        return nodes.size();
    }
    
    
    public int depth(Position<T> v) throws InvalidPositionException{
        if(isRoot(v)){
            return 0;
        }
        
        BTNode<T> n = (BTNode<T>) v;
        return depth(n.getParent()) + 1;
    }
    
}
