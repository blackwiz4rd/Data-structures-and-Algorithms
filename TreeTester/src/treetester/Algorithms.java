/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treetester;

import java.util.ArrayList;
import java.util.LinkedList;

public class Algorithms<T> {

    public Algorithms(){
        
    }
    
    //T is generic type, has to be modified, ex int to count nodes
    public static <T> void preOrderTrasversal(Tree<T> tree) throws EmptyTreeException, InvalidPositionException{
        if(tree.isEmpty())
            throw new EmptyTreeException();
            
        preOrderTrasversal(tree, tree.root());
    }
    
    private static <T> void preOrderTrasversal(Tree<T> tree, Position<T> v) throws InvalidPositionException{
        //visit(v)
        
        //Iterable<Position <T>> children = tree.children(v);
        
        for(Position<T> w: tree.children(v))
            preOrderTrasversal(tree, w);
    }
    
    public static void setDepth(Tree<Integer> tree) throws EmptyTreeException, InvalidPositionException{
        if(tree!=null&&!tree.isEmpty())
            throw new EmptyTreeException();
            
        setDepth(tree, tree.root(), 0);
    }
    
    private static void setDepth(Tree<Integer> tree, Position<Integer> v, int depthV) throws InvalidPositionException{
        tree.replace(v, depthV);
        
        Iterable<Position <Integer>> children = tree.children(v);
        
        for(Position<Integer> x: children)
            setDepth(tree, x, depthV+1);
        
    }
    
    public static void setDepth2(Tree<Integer> tree) throws InvalidPositionException, EmptyTreeException, BoundaryViolationException{
        if(tree!=null || tree.isEmpty())
            throw new EmptyTreeException();
        
        setDepth2(tree, tree.root());
    }
    
    private static void setDepth2(Tree<Integer> tree, Position<Integer> v) throws InvalidPositionException, BoundaryViolationException{
        int depthV = 0;
        Position<Integer> current = v;
        while(!tree.isRoot(current)){   //vedi codice dopo :) -> parte dalla radice ma scende sui figli
            depthV++;
            current = tree.parent(current);
        }
        
        tree.replace(v, depthV);
        
        for(Position<Integer> x : tree.children(v))
            setDepth2(tree, x);
    }
    
    public static void setDepth3(Tree<Integer> tree) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(tree==null || tree.isEmpty())
            throw new EmptyTreeException();
        
        setDepth3(tree, tree.root());
    }
    
    public static void setDepth3(Tree<Integer> tree, Position<Integer> v) throws InvalidPositionException, BoundaryViolationException{
        if(tree.isRoot(v))
            tree.replace(v, 0);
        else
            tree.replace(v, 1 + tree.parent(v).element());
        for(Position<Integer> x: tree.children(v))
            if(x != null)
                setDepth3(tree, x);
    }
    
    public static int countLeaves;
    
    public static <T> void wordsCountLeaves(Tree<T> tree) throws EmptyTreeException, InvalidPositionException{
        countLeaves = 0;
        if(tree!=null && !tree.isEmpty())
            throw new EmptyTreeException();
        
        wordsCountLeaves(tree, tree.root());
    }
    
    private static <T> void wordsCountLeaves(Tree<T> tree, Position<T> v) throws InvalidPositionException{
        if(tree.isExternal(v))
            countLeaves++;
        for(Position<T> x : tree.children(v))
            wordsCountLeaves(tree, x);
    }
    
    public static <T> int countLeaves(Tree<T> tree) throws EmptyTreeException, InvalidPositionException{
        if(tree == null || tree.isEmpty())
            throw new EmptyTreeException();
        
        return countLeaves(tree, tree.root());
    }
    
    private static <T> int countLeaves(Tree<T> tree, Position<T> v) throws InvalidPositionException{
        if(tree.isExternal(v))
            return 1;
        int count = 0;
        for(Position<T> x: tree.children(v))
            count += countLeaves(tree, x);
        return count;
    }
    
    public static <T> int countInternals(Tree<T> tree) throws InvalidPositionException, EmptyTreeException{
        if(tree==null && tree.isEmpty())
            return 0;
        
        return countInternals(tree, tree.root());   
    }
    
    private static <T> int countInternals(Tree<T> tree, Position<T> v) throws InvalidPositionException{
        if(tree.isExternal(v))
            return 0;
        int count = 1;
        for(Position<T> x : tree.children(v))
            count += countInternals(tree, x);
        return count;
    }
    
    public static <T> int countNodes(Tree<T> tree) throws EmptyTreeException, InvalidPositionException{
        if(tree==null || tree.isEmpty())
            return 0;
        return countNodes(tree, tree.root());
    }
    
    private static <T> int countNodes(Tree<T> tree, Position<T> v) throws InvalidPositionException{
        if(tree.isExternal(v))
            return 1;
        int count = 1;
        for(Position<T> x : tree.children(v))
            count += countNodes(tree, x);
        return count;
    }
    
        //T is generic type, has to be modified, ex int to count nodes
    public static <T> void postOrderTrasversal(Tree<T> tree) throws EmptyTreeException, InvalidPositionException{
        if(tree.isEmpty())
            throw new EmptyTreeException();
            
        postOrderTrasversal(tree, tree.root());
    }
    
    private static <T> void postOrderTrasversal(Tree<T> tree, Position<T> v) throws InvalidPositionException{
        
        Iterable<Position <T>> children = tree.children(v);
        
        for(Position<T> w: children)
            preOrderTrasversal(tree, w);
        
        //visit(v)
        
    }
    
    public static void setHeight(Tree<Integer> tree) throws EmptyTreeException, InvalidPositionException{
        if(tree!=null && !tree.isEmpty())
            setHeight(tree, tree.root());
    }
    
    private static int setHeight(Tree<Integer> tree, Position<Integer> v) throws InvalidPositionException{
        int height = 0;
        for(Position<Integer> x : tree.children(v)){
            int h = setHeight(tree, x);
            if(h + 1 > height)
                height = h + 1;
        }
        
        tree.replace(v, height);
        return height;
    }
    
    private static void setHeight1(Tree<Integer> tree, Position<Integer> v) throws InvalidPositionException{
        int height = 0;
        for(Position<Integer> x : tree.children(v)){
            int h = x.element();
            if(h + 1 > height)
                height = h + 1;
        }
        
        tree.replace(v, height);
    }

    public static <T> void levelOrderTrasversal(Tree<T> tree) throws EmptyTreeException, InvalidPositionException{
        if(tree.isEmpty())
            throw new EmptyTreeException();
        
        LinkedList<Position<T>> list = new LinkedList();
        list.addFirst(tree.root());
        while(!list.isEmpty()){
            Position<T> v = list.removeLast();
            //VISIT V
            for(Position<T> x: tree.children(v))
                list.addFirst(x);
        }
    }
    
    //BINARY TREES ONLY
    public static <T> void preOrderTrasversal(BinaryTree<T> t) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t.isEmpty())
            throw new EmptyTreeException();
        preOrderTrasversal(t, t.root());
    }
    
    private static <T> void preOrderTrasversal(BinaryTree<T> t, Position<T> v) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        //visit(v)
        System.out.println(v);
        if(t.hasLeft(v))
            preOrderTrasversal(t,t.left(v));
        if(t.hasRight(v))
            preOrderTrasversal(t,t.right(v));
    }
    
    public static <T> void postOrderTrasversal(BinaryTree<T> t) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t.isEmpty())
            throw new EmptyTreeException();
        postOrderTrasversal(t, t.root());
    }
    
    private static <T> void postOrderTrasversal(BinaryTree<T> t, Position<T> v) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t.hasLeft(v))
            postOrderTrasversal(t,t.left(v));
        if(t.hasRight(v))
            postOrderTrasversal(t,t.right(v));
        //visit(v)
        System.out.println(v);
        
    }
    
    //ATTRAVERSAMENTO IN ORDINE SIMMETRICO
    public static <T> void inOrderTrasversal(BinaryTree<T> tree) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(!tree.isEmpty())
            throw new EmptyTreeException();
            
        inOrderTrasversal(tree, tree.root());
    }
    
    //! POTRESTI PENSARE CHE VISITI SOLO UNO DEI DUE FIGLI MA LI VISITA ENTRAMBI PERCH`E NON C'E ELSE
    private static <T> void inOrderTrasversal(BinaryTree<T> tree, Position<T> v) throws InvalidPositionException, BoundaryViolationException{
        if(tree.hasLeft(v))
            inOrderTrasversal(tree, tree.left(v));
        if(tree.hasRight(v))
            inOrderTrasversal(tree, tree.right(v));
        
    }
    
    
    
    
    
    
}
