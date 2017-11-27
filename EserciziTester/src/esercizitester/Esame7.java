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
public class Esame7 {
    public static int[] Es4(int[] a, int[] b) {
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                c[k++] = a[i];
                i++;
                j++;
            }
            else if(a[i] < b[j]){
                c[k++] = a[i++];
            }
            else{
                c[k++] = b[j++];
            }       
        }
        //System.out.println(i);
        while(i < a.length)
            c[k++] = a[i++];
        while(j < b.length)
            c[k++] = b[j++];
        
        for(k = 0; k < c.length; k++)
            System.out.println("we " + c[k]);
        return c;
    }
}
