/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingtester;

import java.util.LinkedList;

/**
 *
 * @author luca
 */
public class Algorithms {
    public static <T> LinkedList<Comparable> mergeSort(LinkedList<Comparable> list){
        //System.out.println(list.size());
        if(list.size() < 2)
            return list;
        int mid = list.size()/2;
        LinkedList<Comparable> left = new LinkedList();
        LinkedList<Comparable> right = new LinkedList();
        int i = 0;
        while((i++)!=mid)
            left.addLast(list.removeFirst());
        System.out.println(left);
        
        right = list;
        System.out.println(right);
        
        mergeSort(left);
        mergeSort(right);
        
        return merge(left, right);
    }

    private static <T> LinkedList<Comparable> merge(LinkedList<Comparable> s1, LinkedList<Comparable> s2) {
        LinkedList<Comparable> s = new LinkedList();
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.getFirst().compareTo(s2.getFirst()) < 0)
                s.addLast(s1.removeFirst());
            else
                s.addLast(s2.removeFirst());
        }
        
        while(!s1.isEmpty())
            s.addLast(s1.removeFirst());
        
        while(!s2.isEmpty())
            s.addLast(s2.removeFirst());
        return s;
    }
    
    
}
