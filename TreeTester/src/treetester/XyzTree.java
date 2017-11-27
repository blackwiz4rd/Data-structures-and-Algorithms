/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treetester;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class XyzTree<T> implements Tree<T>{
    @Override
    public Iterable<Position<T>> positions(){
        ArrayList<Position<T>> list = new ArrayList<>();
        if(isEmpty())
            return (Iterable<Position<T>>) list;
        
        try {
            preOrderAppendPosition(list, root());
        } catch (EmptyTreeException ex) {
            Logger.getLogger(XyzTree.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidPositionException ex) {
            Logger.getLogger(XyzTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.trimToSize();
        return (Iterable<Position<T>>) list;
    }
    
    private void preOrderAppendPosition(ArrayList<Position<T>> list, Position<T> v) throws InvalidPositionException{
        list.add(v);
        for(Position<T> c : children(v))
            preOrderAppendPosition(list, c);
    }

}
