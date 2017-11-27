/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * cambiano i compression code
 */
package hashingtester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

/**
 *
 * @author luca
 * @param <K>
 * @param <V>
 */
public class ArrayBucketsTable1<K,V> implements MultiMap<K,V> {
    ArrayList[] e;
    int N, n;

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

    
    public ArrayBucketsTable1(int N){   //se N - 1 non noto a priori applico un ridimensionamento e ..
        e = new ArrayList[N];
        this.N = N;
        
        for(int i = 0; i < N; i++)
            e[i] = new ArrayList();
    }
    
    private int hashCode(K key) {
        if(key instanceof Byte || key instanceof Short || key instanceof Character || key instanceof Integer){
            return (Integer)key;
        }
        
        if(key instanceof Float){
            return Float.floatToIntBits((Float)key);
        }
        
        if(key instanceof Double){
            long i = (Long)key;
            return (int)((i>>32)+(int)i);
        }
        
        if(key instanceof String){
            char[] keyCh = ((String)key).toCharArray();
            Arrays.sort(keyCh);
            int i = 0;
            int pol = 0;
            int base = 5;
            for(char coeff: keyCh){
               pol += coeff*Math.pow(base, i);
               i++;
            }
            //System.out.println(pol);
            return pol;
        }
        
        if(key instanceof Object){
            return key.hashCode();  //returns memory position
        }
        
        return -1;
    }
    
    private int compressionCode(int h) {
        return h;
    }
    
    public void rehashing(){
        if(n/N > 0.75 || n >= N){
            Iterator<Entry<K,V>> iter = entries().iterator();
            N = N * 2;
            e = new ArrayList[N];
            
            for(int i = 0; i < N; i++)
            e[i] = new ArrayList();
        
            while(iter.hasNext()){
                Entry<K,V> entry =  iter.next();
                put(entry.getKey(),entry.getValue());
            }
        }
    }
    
    public int keyInt(K key){
        int keyInt = -1;
        int keyToValidate = hashCode(key);//codifica + compressione
        keyToValidate = compressionCode(keyToValidate);
        
        //check boundaries: verifica che non costa nulla in termini di tempo
        if(keyToValidate >= 0 && keyToValidate < N)
            keyInt = keyToValidate;
        
        //System.out.println("codifica + compressione = " + keyInt);
        return keyInt;
    }

    @Override
    public Entry<K, V> put(K key, V val) {
        //rehashing();
        int keyInt=keyInt(key);
        if(keyInt == -1)
            return null;
        
        Entry<K,V> old = get(key);
        e[keyInt].add(new EntryNode(key, val));
        n++;
        return old;
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> entry) {
        //rehashing();
        n--;//...
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entry<K, V> get(K key) {
        Entry<K,V> entry = null;
        int keyInt=keyInt(key);
        if(keyInt == -1)
            return null;
        
        try{
            entry = (Entry<K, V>) e[keyInt].get(0);
        }
        catch(IndexOutOfBoundsException exc){
            
        }
        return entry;
    }

    @Override
    public Iterable<Entry<K, V>> getAll(K key) {
        int keyInt=keyInt(key);
        if(keyInt == -1)
            return null;
        
        
        ArrayList<Entry<K,V>> entry = new ArrayList();
        Iterator<EntryNode<K,V>> iter = e[keyInt].iterator();
        while(iter.hasNext())
            entry.add(iter.next());
        
        return entry;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        ArrayList<Entry<K,V>> entry = new ArrayList();
        for(int i = 0; i < N; i++){
            Iterator<EntryNode<K,V>> iter = e[i].iterator();
            while(iter.hasNext())
                entry.add(iter.next());
        }
        
        return entry;
    }

    @Override
    public Iterable<K> keys() {
        ArrayList<K> keys = new ArrayList();
        for(int i = 0; i < N; i++){
            Iterator<EntryNode<K,V>> iter = e[i].iterator();
            while(iter.hasNext())
                keys.add(iter.next().getKey());
        }
        
        return keys;
    }

    @Override
    public Iterable<V> values() {
        ArrayList<V> values = new ArrayList();
        for(int i = 0; i < N; i++){
            Iterator<EntryNode<K,V>> iter = e[i].iterator();
            while(iter.hasNext())
                values.add(iter.next().getValue());
        }
        
        return values;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }
    
    
    
}
