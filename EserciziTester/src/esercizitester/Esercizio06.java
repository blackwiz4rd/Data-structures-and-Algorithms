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
public class Esercizio06 {
    public int findBottle(boolean[] bottles, int k){   //n = numero di bottiglie, j = bottiglia avvelenata
        int n = bottles.length;
        int n_assaggiatori = (int) Math.ceil(Math.log10(n)/Math.log10(2));
        System.out.println(n_assaggiatori);
        bottles[k] = true;  //avvelenata
        
        
        boolean[] assaggiatori = new boolean[n_assaggiatori];
        for(int i = 0; i < n_assaggiatori; i++){
            System.out.println(i);
            for(int j = 1; j < n; j++){
                if(Integer.toBinaryString(j).length() > i && Integer.toBinaryString(j).charAt(i) == '1'){
                    bottles[i] = true;  //assaggiata
                    System.out.println("bott ass: " + j);
                    System.out.println(j + " " + k);
                    if(j == k)
                        assaggiatori[i] = true;
                }
                
                
            }
        }
        
        
        String bottle_index = "";
        for(int i = 0; i < n_assaggiatori; i++){
            System.out.println("stato ass: " + assaggiatori[i]);
            
            if(assaggiatori[i] == true)
                bottle_index = 1 + bottle_index;
            else
                bottle_index = 0 + bottle_index;
        }
        
        return Integer.parseInt(bottle_index, 2);
    }
}
