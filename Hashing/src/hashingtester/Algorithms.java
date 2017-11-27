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
 * @param <K>
 * @param <V>
 */
public class Algorithms<K,V> {
    class EntryNode<K,V> implements Entry<K,V>{
        private K key;
        private V value;
        
//        System.out.println("key = " + key + ", value = " + value);
        
        public EntryNode(K key, V value){
            this.key = key;
            this.value = value;
            
            System.out.println(key + " " + value);
            
        }
        
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V old = value;
            value = newValue;
            return old;
        }
        
    }

    
    public Iterable<Entry<Integer, V>> getList(){
        ArrayList<Entry<Integer,V>> list = new ArrayList();
        
        for(int i = 9; i >= 0; i--)
            list.add(new EntryNode(i, "test" + i));
        
        return list;
    }   //generating chosen list
    
    public Iterable<Entry<Integer, V>> bucketSort(Iterable<Entry<Integer,V>> entries){   ////tetha(NmaxS + n)
        Iterator<Entry<Integer,V>> iter = entries.iterator();
        int NmaxS = iter.next().getKey();
        while(iter.hasNext()){  //tetha(n)
            int temp = iter.next().getKey();
            if(temp > NmaxS)
                NmaxS = temp;
        }
        System.out.println("NmaxS" + NmaxS);
        
        ArrayBucketsTable1<Integer,V> abuckets = new ArrayBucketsTable1(NmaxS + 1);
        
        iter = entries.iterator();
        while(iter.hasNext()){  //tetha(NmaxS), NON FA CONFRONTI!!! INTERESSANTE
            Entry<Integer,V> entry = iter.next();   //andrebbe anche rimossa dalla lista passata ma non importa
            abuckets.put(entry.getKey(), (V) entry.getValue());   //all entries put in the array of buckets
        }
        
        return abuckets.entries();  //tetha(NmaxS)
    }
    
}
