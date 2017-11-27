/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashingtester;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author luca
 */
public class HashingTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayTable<Integer, String> a = new ArrayTable(10); //sempre integer per il momento
        a.put(1, "ciao");
        a.put(6, "ciccio");
        a.put(3, "mi");
        a.put(5, "chiamo");
        a.put(5, "test");
        
        System.out.println("removed: " + a.remove(1));
        
        Iterator<String> iter = a.values().iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        
        System.out.println("--");
        
        ArrayBucketsTable1<Integer, String> b = new ArrayBucketsTable1(10);
        b.put(1, "ciao");
        b.put(6, "ciccio");
        b.put(3, "mi");
        b.put(5, "chiamo");
        b.put(5, "test");
        
        iter = b.values().iterator();
        while(iter.hasNext())
            System.out.println("v " + iter.next());
        
        Iterator<Integer> iter1;
        iter1 = b.keys().iterator();
        while(iter1.hasNext())
            System.out.println("k " + iter1.next());
        
                
        Iterator<Entry<Integer,String>> iter2;
        iter2 = b.getAll(5).iterator();
        while(iter2.hasNext()){
            Entry<Integer,String> e = iter2.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        
        iter2 = b.entries().iterator();
        while(iter2.hasNext()){
            Entry<Integer,String> e = iter2.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        
        System.out.println("--");
        
        Algorithms alg = new Algorithms();
        Iterator<Entry<Integer,String>> iterAlg = alg.bucketSort(alg.getList()).iterator();
        while(iterAlg.hasNext())
            System.out.println(iterAlg.next().getKey());
            
        /*ArrayBucketsTable<String, String> c = new ArrayBucketsTable(10); //sempre integer per il momento
        c.put("a", "ciao");
        c.put("e", "ciccio");
        c.put("d", "mi");
        c.put("a", "chiamo");
        c.put("f", "test");
        
        c.put("f", "marco");
        
        c.put("f", "giovanni");
        
        c.put("f", "tizio");
        
        c.put("f", "caio");
        
        c.put("z", "caio");
        
        c.put("m", "caio");
        
        c.put("o", "caio");
        
        iter = c.values().iterator();
        while(iter.hasNext())
            System.out.println("v = " + iter.next());
        
        Iterator<String> iter1S;
        iter1S = c.keys().iterator();
        while(iter1S.hasNext())
            System.out.println("k = " + iter1S.next());
        
                
        Iterator<Entry<String,String>> iter2S;
        iter2S = c.getAll("f").iterator();
        while(iter2S.hasNext()){
            Entry<String,String> e = iter2S.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        
        System.out.println(c.size());*/
    }
    
}
