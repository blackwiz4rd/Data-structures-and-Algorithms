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
public class Algorithms {
    //Esame 5: Es3
    //realizzare get in un bst, NON RICORSIVO
    public static <T> boolean search(String s, BSTree<String> t){
        if(t.isEmpty())
            return false;
        
        return search(s,t);   
    }
    
    private static <T> boolean serach(String s, BSTree<String> t) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException{
        Position<String> v = t.root();
        
        while(!t.isExternal(v)){
            Position<String> next = null;
            if(v.element().equals(s))
                return true;
            else if(s.compareTo(v.element()) < 0)
                next = t.left(v);
            else
                next = t.right(v);
            v = next;
        }
        
        return false;
        
    }
}
