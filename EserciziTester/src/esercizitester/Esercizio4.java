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
public class Esercizio4 {
    //a ordinato
    public boolean binarySearchX(double [] a, double x){
        if(a == null || a.length == 0)
            return false;
        return binarySearchX(a, x, 0, a.length);
    }

    //1,2,3,4,5,6,7,8,9
    public boolean binarySearchX(double[] a, double x, int from, int to){
        //1)caso base ricorsione
        if(from > to)
            return false;
        
        int mid = (from + to)/2;
        
        System.out.println(mid);
        if(a[mid] == x)
            return true;
        else if(x > a[mid])
            return binarySearchX(a,x,mid + 1, to);
        else if(x < a[mid])
            return binarySearchX(a,x,from, mid);
        return false;
    }
    
    //NON RICORSIVO
    //a ordinato
    public boolean binarySearchXIterative(double [] a, double x){
        if(a == null || a.length == 0)
            return false;
        
        int from = 0;
        int to = a.length;
        while(from < to){
            int mid = (from + to)/2;
        
            System.out.println(mid);
            if(a[mid] == x)
               return true;
            else if(x > a[mid])
                from = mid + 1;
            else if(x < a[mid])
                to = mid;
        }
        return false;
    }
    
}
