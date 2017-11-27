/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizitester;

import java.util.Stack;

/**
 *
 * @author luca
 */
public class EserciziTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] unsorted = new double[] {3,5,7,1,5,9,8,2,10};
        Esercizio1 es1 = new Esercizio1();
        double[] a = es1.findMinMax(unsorted);
        double min = a[0];
        double max = a[1];
        System.out.println(min + " " + max);
        
        Esercizio4 es4 = new Esercizio4();
        double[] b = new double[] {1,2,4,7,11,33,40,51,55,99};
        System.out.println(es4.binarySearchX(b, 4));
        System.out.println(es4.binarySearchXIterative(b, 4));
        
        Esercizio5 es5 = new Esercizio5();
        es5.selectionSort(unsorted, unsorted.length - 1);
        System.out.println();
        //1,9,6,7,
        
        Esercizio9 es6 = new Esercizio9();
        int x = 5;
        Stack<Integer> s = new Stack<>();
        
        s.add(3);
        s.add(8);
        s.add(7);
        s.add(6);
        System.out.println(es6.findInStack(s, x));
        
        
        Esercizio10 es10 = new Esercizio10();
        int[] intA = {1,2,3,5,6,7,0,0};
        System.out.println(es10.missingNumber(intA, intA.length));
        
        
        Esercizio06 es06 = new Esercizio06(); 
        //System.out.println(es06.findBottle(new boolean[100], 7));
        
        Esercizio23 es23 = new Esercizio23();
        int[] intNums = {1, 2, 3, 7, 9, 15};
        System.out.println(es23.sumExists(intNums, intNums.length, 9));
        
        Esame1 esame1 = new Esame1();
        int[] intArray = {11, 22, 33, 77, 99, 155};
        System.out.println(esame1.Esercizio2(intArray, 24));
        
        int[][] matrix = new int[4][4];
        for(int j = 0; j < 4; j++){    
            for(int i = 0; i < 4; i++)
                if(i <= j)
                    matrix[j][i] = 1;
        }
        System.out.println(Esercizio53.countOnes(matrix));
        
        
        int[] ar = {1,3,4,8,9,11};
        int[] br = {0,2,7,9,13,15};
        //System.out.println(Esame3.esercizio3Count(ar, br));
        
        Esame7.Es4(ar, br);
    }
    
}
