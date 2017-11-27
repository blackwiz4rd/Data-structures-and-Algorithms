/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treetester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static treetester.Algorithms.setDepth3;

/**
 *
 * @author luca
 */
public class Exercices {
    //ESERCIZI
    
    //ES17
    //each node has depth set
    //height = max depth of leaves
    public static <T> int height(BinaryTree<Integer> t) throws InvalidPositionException, EmptyTreeException, BoundaryViolationException{
        setDepth3(t);
        Iterator<Position<Integer>> iter = t.positions().iterator();
        int max = 0;
        
        while(iter.hasNext()){
            Position<Integer> node = iter.next();
            System.out.println(node.element());
            if(t.isExternal(node)){
                if(node.element() > max){
                    max = node.element();
                }
            }
        }
        return max;
    }
    
    //ES18: Lowest common ancestor: antenato avente profondità massima
    public static <T> Position<T> LCA(BinaryTree<Integer> t, Position<T> v, Position<T> w) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        Position<T> u = null;   //profondità massima, antenato più vicino a entrambi
        LinkedBinaryTree lt = (LinkedBinaryTree) t;
        int depthV = lt.depth(v);
        int depthW = lt.depth(w);
        
        while(depthV > depthW){
            v = lt.parent(v);
            depthV--;
        }
        while(depthW > depthV){
            w = lt.parent(w);
            depthW--;
        }
        while(v != w){
            v = lt.parent(v);
            w = lt.parent(w);
        }
        return v;
    }
    
    //Es19
    public static <T> int distance(BinaryTree<Integer> t, Position<T> v, Position<T> w) throws InvalidPositionException, EmptyTreeException, BoundaryViolationException{
        LinkedBinaryTree lt = (LinkedBinaryTree) t;
        return lt.depth(v) + lt.depth(w) - 2*lt.depth(LCA(t,v,w));
    }
    
    //Es21
    public static <T> int getSumOfAllDepths(BinaryTree<T> t) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t.isEmpty())
            return 0;
        return getSumOfAllDepths(t,t.root(),0); //tree is empty
    }
    
    private static <T> int getSumOfAllDepths(BinaryTree<T> t, Position<T> v, int parentDepth) throws InvalidPositionException, BoundaryViolationException{
        LinkedBinaryTree<T> lt = (LinkedBinaryTree<T>) t;
        int depth;
        if(t.isRoot(v))
            depth = 0;
        else
            depth = 1 + parentDepth;
        
        int sum = depth;
        for(Position<T> c: t.children(v))
            if(c != null)
                sum = sum + getSumOfAllDepths(t, c, depth);
        return sum;
    }
    
    //Es24
    
    public static <T> void setAvg(Tree<Double> t) throws EmptyTreeException, InvalidPositionException{
        if(t!=null && !t.isEmpty())
            setAvg(t, t.root());
    }
    
    //per ogni nodo scrivo il grado medio dei suoi discendenti
    private static <T> int setAvg(Tree<Double> t, Position<Double> v) throws InvalidPositionException{
        int count = 1; //il nodo stesso è un discendente di se
        
        for(Position<Double> f: t.children(v)){
            if(f != null)
                count += setAvg(t,f);
        }
        
        double avg = (count - 1) / (double) count;  //numero di figli sottoalbero, tutti tranne la radice
        System.out.println(v + " " + avg + " " + count);
        t.replace(v, avg);
        
        return count;
    }
    
    //Es27: se e solo se: 
    //T1 E T2 SONO VUOTI
    //T1 E T2 HANNO SOLO ROOT
    //T1.LEFTS(ROOT) ISO T2.LEFTS(ROOT) && T1.RIGHTS(ROOT) ISO T2.RIGHTS(ROOT) 
    public static <T> boolean areIsomorph(BinaryTree<T> t1, BinaryTree<T> t2) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        /*if(t1.isEmpty() && t2.isEmpty())
        return true;
        if(t1.isEmpty() || t2.isEmpty())
        return false;
        
        //non sono vuoti
        Position<T> r1 = t1.root();
        Position<T> r2 = t2.root();
        
        if(t1.hasLeft(r1) != t1.hasRight(r1))
        return false;   //T1 non è proprio
        
        if(t2.hasLeft(r2) != t2.hasRight(r2))
        return false;   //T2 non è proprio
        
        
        if(t1.hasLeft(r1) != t2.hasLeft(r2))
        return false;
        
        if(t1.isExternal(r1))
        return true;
        
        return false;*/
        
        if(t1.size() != t2.size())
            return false;
        if(t1.isEmpty() && t2.isEmpty())
            return true;
        if(t1.isEmpty() || t2.isEmpty())
            return false;
        
        return areIsomorph(t1, t1.root(), t2, t2.root());
    }
    
    private static <T> boolean areIsomorph(BinaryTree<T> t1, Position<T> r1, BinaryTree<T> t2, Position<T> r2) throws InvalidPositionException, InvalidPositionException, BoundaryViolationException{
        if(t1.hasLeft(r1) != t1.hasRight(r1))
            return false; //T1 non è proprio
        if(t2.hasLeft(r2) != t2.hasRight(r2))
            return false; //T2 non è proprio
        if(t1.hasLeft(r1) != t2.hasLeft(r2))
            return false;
        
        if(t1.isExternal(r1))
            return true;
        
        return areIsomorph(t1,t1.left(r1), t2, t2.left(r2)) && areIsomorph(t1,t1.right(r1), t2, t2.right(r2));
    }
    
    //Esame1 - Esercizio4
    public static <T> boolean isTriangular(BinaryTree<T> t) throws InvalidArgumentException, EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t == null)
            throw new InvalidArgumentException();
        if(t.root() == null)
            return true;
        return -1 != getHeightIfTriangular(t, t.root());
    }
    
    public static <T> int getHeightIfTriangular(BinaryTree<T> t, Position<T> p) throws InvalidPositionException, BoundaryViolationException{
        if(t.isExternal(p))
            return 0;
        if(!t.hasLeft(p) || !t.hasRight(p))
            return -1;  //non è triangolare
        int left = getHeightIfTriangular(t, t.left(p));
        int right = getHeightIfTriangular(t, t.right(p));
        if(left == right && left != -1){
            return left + 1;    //altrimenti uno dei sottoalberi non è triangolare
        }
        
        return -1;
    }
    
    public static <T> boolean isTriangular2(BinaryTree<T> t) throws InvalidArgumentException, EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t == null)
            throw new InvalidArgumentException();
        if(t.root() == null)
            return true;
        int n = getSize(t, t.root());
        int h = getHeight(t, t.root());
        return n + 1 == (int)Math.round(Math.pow(2, h + 1));
    }
    
    public static <T> int getSize(BinaryTree<T> t, Position<T> p) throws InvalidPositionException, BoundaryViolationException{
        int n = 1;
        if(t.hasLeft(p))
            n += getSize(t, t.left(p));
        if(t.hasRight(p))
            n += getSize(t, t.right(p));
        return n;
    }
    
    public static <T> int getHeight(BinaryTree<T> t, Position<T> p) throws InvalidPositionException, BoundaryViolationException{
        int h = 0;
        if(t.hasLeft(p))
            h = 1 + getHeight(t, t.left(p));
        if(t.hasRight(p)){
            int x = 1 + getHeight(t, t.right(p));
            if(x > h)
                h = x;
        }
        return h;
    }
    
    //ES28 Algoritmo non ricorsivo che restituisce il nodo seguente a quello attraversato dal pre-orderTrasversal = base iteratore preordine

    //restituisce il nodo successivo a quello dato nell'attraversamento in preordine O(h) profondità max, O(n) catena
    public static <T> Position<T> preorderNext(BinaryTree<T> t, Position<T> v) throws java.util.NoSuchElementException, InvalidPositionException, BoundaryViolationException{
        //ho già il riferimento!!! Non serve attraversare tutto l'albero dall'inizio!!!
        if(t == null || t.isEmpty())
            throw new java.util.NoSuchElementException();
        
        try{
            if(t.hasLeft(v))
                return t.left(v);
            if(t.hasRight(v))
                return t.right(v);
        
            while(!t.isRoot(v)){
                Position<T> p = t.parent(v);
                //if(t.hasLeft(p) && v == t.left(p) && t.hasRight(p))
                //se v è figlio sinistro e ce n'è un destro diverso da v lo restituisco
                if(t.hasRight(p) && v != t.right(p))
                    return t.right(p);
                v = p;  //risalgo al genitore di v
            }
        }
        catch(InvalidPositionException e){
            
        }
        //non ho trovato l'elemento!
        throw new java.util.NoSuchElementException();
    }
    
    //per costruire l'iteratore
    public static <T> boolean hasPreorderNext(BinaryTree<T> t, Position<T> v) throws InvalidPositionException, BoundaryViolationException{
        try{
            preorderNext(t,v);
        }
        catch(java.util.NoSuchElementException e){
            return false;
        }
        return true;
    }
    
    /*public boolean hasPreorderNext(BinaryTree<T> t, Position<T> v) throws InvalidPositionException, BoundaryViolationException{
        if(t == null && t.isEmpty())
            return false;
        
        try{
            if(t.hasLeft(v) || t.hasRight(v))
                return true;
        
            while(!t.isRoot(v)){
                Position<T> p = t.parent(v);
                if(t.hasRight(p) && t.right(p) != v)
                    return true;
                v = p;  //se non lo metto va in loop!
            }
        }
        catch(InvalidPositionException e){
            
        }
        return false;
    }*/
    
    private class BTPreorderIterator<T> implements java.util.Iterator<Position<T>>{
        BinaryTree<T> tree;
        Position<T> current;
        
        public BTPreorderIterator(BinaryTree<T> t){
            if(t == null || tree.isEmpty())
                tree = null;
            else{
                tree = t;
                current = null;
            }
        }
        
        @Override
        public boolean hasNext() {
            /*if(tree == null)
            return false;
            if(current == null) //il prossimo è la radice
            return true;
            try {
            return Exercices.hasPreorderNext(tree,current);   //current non è nullo e quindi il prossimo non è la radice ma un altro nodo se esiste
            } catch (InvalidPositionException | BoundaryViolationException ex) {
            
            }
            return false;*/
            boolean x = true;
            Position<T> old = current;
            try{
                next();
            }
            catch(java.util.NoSuchElementException e){
                x = false;
            }
            current = old; //!ripristino lo stato
            return x;
        }

        @Override
        public Position<T> next() {
            if(tree == null)
                throw new java.util.NoSuchElementException();
            try{
                if(current == null)
                    current = tree.root();
                else
                    current = Exercices.preorderNext(tree,current);
            }
            catch(EmptyTreeException | NoSuchElementException | InvalidPositionException | BoundaryViolationException ex){
                
            } 
            
            return current;
        }
        
    }
    
    public static<T> Position<T> inorderNext(BinaryTree<T> t, Position<T> v) throws BoundaryViolationException, InvalidPositionException{
        if(t == null || t.isEmpty())
            throw new java.util.NoSuchElementException();
        try{
            if(t.hasRight(v)){
                v = t.right(v);
                while(t.hasLeft(v))
                    v = t.left(v);

                return v;
            }

            while(!t.isRoot(v)){
                Position<T> p = t.parent(v);
                if(t.hasLeft(v) && t.left(p) == v)
                    return p;
                v = p;
            }
        }
        catch(InvalidPositionException e){
            
        }
        
        throw new java.util.NoSuchElementException();
        
    }
    
    public static<T> boolean hasInorderNext(BinaryTree<T> t, Position<T> v) throws BoundaryViolationException, InvalidPositionException{
        try{
            inorderNext(t,v);
        }
        catch(java.util.NoSuchElementException e){
            return false;
        }
        
        return true;
    }
    
    private class BTInorderIterator<T> implements java.util.Iterator<Position<T>>{
        BinaryTree<T> tree;
        Position<T> current;
        
        public BTInorderIterator(BinaryTree<T> t){
            if(t == null || tree.isEmpty())
                tree = null;
            else{
                tree = t;
                current = null;
            }
        }
        
        @Override
        public boolean hasNext() {
                boolean x = true;
            Position<T> old = current;
            try{
                next();
            }
            catch(java.util.NoSuchElementException e){
                x = false;
            }
            current = old; //!ripristino lo stato
            return x;
        }

        @Override
        public Position<T> next() {
            if(tree == null)
                throw new java.util.NoSuchElementException();
            try{
                if(current == null)
                    current = tree.root();
                else
                    current = getFirstInorder();
            }
            catch(EmptyTreeException | NoSuchElementException | InvalidPositionException | BoundaryViolationException ex){
                
            } 
            
            return current;
        }

        private Position<T> getFirstInorder() throws EmptyTreeException, InvalidPositionException, BoundaryViolationException {
            Position<T> v = tree.root();
            while(tree.hasLeft(v))
                v = tree.left(v);
            return v;
        }
    }
    
    
    //ES30 Distanza massima tra l'attraveramento in ordine simmetrico
    public static <T> int findDelta(BinaryTree<T> t) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t.isEmpty())
            return 0;
        return findDelta(t,t.root())[0];
    }
    
    private static<T> int[] findDelta(BinaryTree<T> t, Position<T> w) throws InvalidPositionException, BoundaryViolationException{
        int[] delta = new int[3];
        int dL,d,e,dR;
        
        if(t.hasLeft(w)){
            delta = findDelta(t,t.left(w));
            d = Math.max(delta[0],delta[2]+1);
            dL = delta[1] + 1;
        }
        else{
            d = 0;
            dL = 0;
        }
        
        if(t.hasRight(w)){
            delta = findDelta(t,t.right(w));
            e = Math.max(delta[0], delta[1] + 1);
            dR = delta[2] + 1;
        }
        else{
            e = 0;
            dR = 0;
        }
        
        delta[0] = Math.max(d, e);
        delta[1] = dL;
        delta[2] = dR;
        
        return delta;
    }
    
    //ES31: diametro = distanza massima tra due nodi: modifica di height(Tree<T> t)
    public static <T> int diameter(BinaryTree<T> t) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        if(t == null || t.isEmpty())
            throw new EmptyTreeException();
        return postTrasversal(t,t.root())[0];
    }
    
    public static <T> int[] postTrasversal(BinaryTree<T> t, Position<T> v) throws InvalidPositionException, BoundaryViolationException{
        int[] dh = new int[2];
        int[] dhleft = new int[2];
        int[] dhright = new int[2];
        
        if(t.hasLeft(v))           
            dhleft = postTrasversal(t,t.left(v));
        else{
            dhleft[0] = 0;
            dhleft[1] = -1;
        }
        if(t.hasRight(v))
            dhright = postTrasversal(t,t.right(v));
        else{
            dhright[0] = 0;
            dhright[1] = -1;
        }
        int max_temp = Math.max(dhleft[1] + dhright[1] + 2, dhleft[0]);
        dh[0] = Math.max(max_temp, dhright[0]);
        dh[1] = 1 + Math.max(dhleft[1], dhright[1]);
        return dh;  //if t.isExternal(v) returns 0, 0
    }
    
    //ES33
    //HEAP
    public static <T> Iterator<Integer> getListOfEntriesWithKeyLessThan(BinaryTree<Integer> t, int k) throws EmptyTreeException, InvalidPositionException{
        if(t == null || t.isEmpty())
            return null;
        
        ArrayList<Integer> list = new ArrayList<>();
        preOrderTrasversal(t, t.root(), k, list);
        return list.iterator();
    }
    
    public static <T> void preOrderTrasversal(BinaryTree<Integer> t, Position<Integer> v, int k, ArrayList<Integer> list) throws InvalidPositionException{
        //visit
        if(v == null || v.element() >= k)
            return; //evita di scendere per i figli se l'elemento è maggiore
        
        list.add(v.element());
        //end visit
        
        for(Position<Integer> c: t.children(v))
            preOrderTrasversal(t,c,k,list);
    }
}
