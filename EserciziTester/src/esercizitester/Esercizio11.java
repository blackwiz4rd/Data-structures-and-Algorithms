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
public class Esercizio11 {
    public int findSumXYdiffZ(int[] a, int aSize){
        int max = a[0];
        for(int i = 1; i < aSize; i++)
            if(a[i] > max)
                max = a[i];
        return 2*max+1;
    }
}
