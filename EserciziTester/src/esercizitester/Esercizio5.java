/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizitester;

/**
 *
 * @author luca
 */
public class Esercizio5 {
    public double[] selectionSort(double[] a, int aSize){   //non iterativo
        for(int i = 0; i < aSize; i++){
                        int minPos = i;
            for(int j = i + 1; j < aSize; j++){
                //findMinPos
                if(a[j] < a[minPos])
                    minPos = j;
                //swap
                if(minPos != i){
                    double tmp = a[i];
                    a[i] = a[minPos];
                    a[minPos] = tmp;
                }    
            }
        }
        
        
        for(int i = 0; i < aSize; i++){
            System.out.print(a[i] + ",  ");
        }
        
        return a;
    }
    
}