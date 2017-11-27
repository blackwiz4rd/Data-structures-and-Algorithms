/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizitester;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author luca
 */
public class Esercizio9<T> {
    public boolean findInStack(Stack<T> s, T x){
        PriorityQueue<T> q = new PriorityQueue<>();
        boolean found = false;
        
        while(!s.isEmpty()){
            if(x == null){
                if(s.peek() == null)
                    found = true;
            }
            else if(s.peek().equals(x)){
                found = true;
            }
            
            q.add(s.pop());
        }
            
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        
        while(!q.isEmpty()){
            s.add(q.poll());
        }
        
        return found;    
    }
}
