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
public class Esercizio53 {
    public static int countOnes(int[][] m){ //n * O(logn)
        int sum = 0;
        System.out.println();
        for(int i = 0; i < m.length; i++){
            sum += binarySearch(m, i);  //O(logn)
            //System.out.println(sum);
        }
        
        return sum;
    }
    
    private static int binarySearch(int[][] m, int row){
        return binarySearch(m, row, 0, m[row].length - 1);
    }
    
    //cerco un uno
    private static int binarySearch(int[][] m, int row, int from, int to){
        int mid = (from + to)/2;
        //System.out.println(mid + " " + from + " " + to );
        if(from > to)   //nullo se non ci sono 1
            return 0;
        
        if((m[row][mid] == 1 && mid == m[row].length - 1) || (m[row][mid] == 1 && m[row][mid + 1] == 0))
            return mid + 1; //RANGO!!! non l'indice
        if(m[row][mid] == 0) //è zero
            return binarySearch(m, row, from, mid);
        else   //cerco lo zero a destra
            return binarySearch(m, row, mid + 1, to);
    }
    
    private static int binarySearch2(int[][] m, int row, int from, int to){
        int mid = (from + to)/2;
        if(to - from == 0)  //caso base
            return 0; 
        if(m[row][from] == 0)   //la prima cella non contiene 1
            return 0;
        
        if(m[row][to - 1] == 1) //la penultima cella contiene 1
            return to;          //rango della penultima cella
        
        int c = (int) Math.floor(((from + (to - from)/2)));
        if(m[row][c] == 0 && m[row][c - 1] == 1)
            return c;
        if(m[row][c] == 1)
            return binarySearch2(m, row, c + 1, to);
        return binarySearch2(m, row, from, c);
    }
    
}
