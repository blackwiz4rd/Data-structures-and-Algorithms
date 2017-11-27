/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selection;

/**
 *
 * @author luca
 */
public class Algorithms {
    public char quickSelect(char[] S, int sSize, int k){
        
        int n = sSize;
        //CASO BASE
        if(n == 1)  //k = 1, i = 0
            return S[0];
        //DIVISIONE: pivot e LEG
        int x = pivot(n);   //scelta pensata
        System.out.println("pivot " +  S[x] + " " + x);
        char[] L,E,G;   //partizioni di S
        L = new char[n];
        E = new char[n];
        G = new char[n];
        
        int l = 0; 
        int e = 0; 
        int g = 0;
        
        System.out.println(S);
        for(int i = 0; i < n; i++){
            //System.out.println(S[i]);
            if(S[i] < S[x])
                L[l++] = S[i];
            else if(S[i] == S[x])
                E[e++] = S[i];
            else if(S[i] > S[x])
                G[g++] = S[i];
        }
        
        System.out.println(L);
        System.out.println(E);
        System.out.println(G);
        
        if(k <= l)
            return quickSelect(L, l, k);
        else if(k <= l + e)
            return E[0];
        else
            return quickSelect(G, g, k - l - e);
    }

    private int pivot(int n) {
        return n/2;
    }
}
