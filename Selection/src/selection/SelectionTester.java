/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selection;

import java.util.Arrays;

/**
 *
 * @author luca
 */
public class SelectionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Algorithms a = new Algorithms();
        String s = "thisismybestchoice";
        System.out.println(a.quickSelect(s.toCharArray(), s.length(), 1));  //finds the k-th smallest element, k = 1 smallest
    }
    
}
