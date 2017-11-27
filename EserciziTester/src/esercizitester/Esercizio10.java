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
public class Esercizio10 {
    public int missingNumber(int[] a, int n){   //a numeri compresi tra 0 e n-1 senza ripetizioni
        //array da 0 a n-1
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += a[i];
        
        int realSum = (n)*(n - 1)/2;
        System.out.println(realSum);
        System.out.println(sum);
        return realSum - sum;
        
    }
}
