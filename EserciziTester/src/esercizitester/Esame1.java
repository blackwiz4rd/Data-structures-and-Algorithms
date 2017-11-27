/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizitester;

import java.util.ArrayList;

/**
 *
 * @author luca
 */
public class Esame1 {
    public boolean Esercizio2(int[] a, int z){
        int count = 0;
        int min = 0;
        int max = a.length - 1;
        while(min < max){
            
            count++;
            System.out.println("cycle count" + count + " " + (a.length-1)*Math.log((a.length-1)));
            
            if(a[min] + a[max] < z)
                min++;
            else if(a[min] + a[max] > z)
                max--;
            if(a[min] + a[max] == z)
                return true;
            
        }
        
        

        return false;
    }
    
    class Esercizio3<T>{
        private Node<T> head, tail;
        
        private class Node<T> {
            T element;
            Node<T> next;
            
            public Node(T element, Node<T> next){
                this.element = element;
                this.next = next;
            }
            
            public void setNext(Node<T> next){
                this.next = next;
            }
            
            public void setElement(T element){
                this.element = element;
            }
            
            public Node<T> getNext(){
                return next;
            }
            
            public T getElement(){
                return element;
            }
        }
        
        public Esercizio3(){
            tail = new Node(null, null);
            head = new Node(null, tail);
        }
        
        public void add(T e){
            tail.setElement(e);
            tail = new Node(null, tail);
       //     System.out.println("head " + head +  " tail " + tail +  "  element added: " + e);
        }
        
        public T remove(T e){
            T old = head.getElement();
            head = head.getNext();
            head.setElement(null);
            return old;
        }
    }
}
