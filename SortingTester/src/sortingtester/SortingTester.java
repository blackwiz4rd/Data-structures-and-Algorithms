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
public class SortingTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Comparable> test = new LinkedList();
        test.add(3);
        test.add(1);
        test.add(4);
        test.add(2);
        test.add(8);
        
        System.out.println(Algorithms.mergeSort(test));
    }
    
}
