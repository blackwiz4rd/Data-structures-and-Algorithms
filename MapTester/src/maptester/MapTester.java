/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maptester;

import java.util.Iterator;

/**
 *
 * @author luca
 */
public class MapTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<Integer,String> m = new ListMap();
        m.put(0, "Fasano");
        m.put(1, "Pezze");
        m.put(2, "Cisternino");
        m.put(2, "Overrides");
        
        System.out.println(m.get(1));
        //m.remove(1);
        
        Iterator<Integer> iter = (Iterator<Integer>) m.keys().iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        Iterator<String> iterV = (Iterator<String>) m.values().iterator();
        while(iterV.hasNext())
            System.out.println(iterV.next());
        
        /*
        MultiMap<Integer,String> mm = new ArrayMultiMapSorted();
        mm.put(2, "Cisternino");
        mm.put(2, "Not Overrides");
        mm.put(0, "Fasano");
        mm.put(1, "Pezze");
        
        System.out.println(mm.get(1));
        System.out.println(mm.get(2));
        System.out.println(mm.remove(new EntrySet(2, "")));
        Iterator<Integer> iter = mm.keys().iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        
        Iterator<String> iter1 = mm.values().iterator();
        while(iter1.hasNext())
            System.out.println(iter1.next());
        
        Iterator<Entry<Integer,String>> iter2 = mm.getAll(2).iterator();
        while(iter2.hasNext())
            System.out.println(iter2.next());*/
    }
    
}
