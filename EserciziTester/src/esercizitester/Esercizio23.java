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
public class Esercizio23 {
    //Es23 array crescente, esiste z = x  + y? spazio tetha(1), prestazioni O(n)
    //USO DOPPIO INDICE POICHE' ORDINATO: 1, 2, 3, 4, 5         z = 3 decrese max only
    public boolean sumExists(int[] A, int n, int z){   //n is ASize
        int min = 0, max = n - 1;
        while(min < max){
            if(A[min] + A[max] == z)
                return true;
            else if(A[min] + A[max] < z)
                min++;
            else
                max--;
        }
        return false;
    }
}
