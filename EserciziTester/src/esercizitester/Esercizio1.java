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
public class Esercizio1 {
    public double[] findMinMax(double[] a){
        if(a == null || a.length == 0)
            throw new IllegalArgumentException();
        
        //confronto le coppie
        double min = a[0];
        double max = a[0];
        int n = 0;
        
        for(int i = 1; i < a.length - 1; i+=2){
            System.out.println("a[i]: " + a[i] + " a[i+1]:" + a[i+1]);
            if(a[i] < a[i + 1]){
                if(a[i] < min)
                    min = a[i];
                if(a[i + 1] > max)
                    max = a[i + 1];
                n+=2;   //confronti necessari ma so già chi può essere min e chi max
                        //ho ridotto il problema a coppie di dati
            }
            else{
                if(a[i + 1] < min)
                    min = a[i + 1];
                if(a[i] > max)
                    max = a[i];
                n+=2;
            }
            n++; //confronto base
        }
        
        if(a.length % 2 == 0){
            System.out.println("ultimo: " + a[a.length - 1]);
            if(a[a.length - 1] < min)
                min = a[a.length - 1];
            if(a[a.length - 1] > max)
                max = a[a.length - 1];
            n++;
        }
        
        System.out.println("n confronti = floor(3*a.length/2) = " +n);
        return new double[] {min, max};
        
    }
}
