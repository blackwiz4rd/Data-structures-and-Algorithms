
package PqTester;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

//heap = CompletebinaryTree compatto a sx con proprietà di heap
public class ArrayHeap<K,V> implements CompleteBinaryTree<Entry<K,V>>{
    private Position<Entry<K,V>> v[];
    private Position<Entry<K,V>> root;
    
    private int vSize;
    private final int INITSIZE = 100;
    
    private int parentInt;
    
    public ArrayHeap(){
        v = new Position[INITSIZE];
        root = v[0];

        vSize = 0;
        
        parentInt = 0;
    }
    
    
    private class BTNode<T> implements Position<Entry<K,V>>{
        private Entry<K,V> element;
        private BTNode<Entry<K,V>> left;
        private BTNode<Entry<K,V>> right;
        private BTNode<Entry<K,V>> parent;

        public BTNode(Entry<K,V> element){
            this.element = element;
            this.left = null;
            this.right = null;
            
            //System.out.println("Nodo aggiunto " + element);
        }
        
        public void setElement(Entry<K,V> element){
            this.element = element;
        }
        
        public void setParent(BTNode<Entry<K,V>> parent){
            this.parent = parent;
        }
        
        public void setLeft(BTNode<Entry<K,V>> left){
            this.left = left;
        }
        
        public void setRight(BTNode<Entry<K,V>> right){
            this.right = right;
        }
        
        @Override
        public Entry<K,V> element() {
            return element;
        }
        
        public BTNode<Entry<K,V>> getParent(){
            return parent;
        }
        
        public BTNode<Entry<K,V>> getLeft(){
            return left;
        }
        
        public BTNode<Entry<K,V>> getRight(){
            return right;
        }
        
        @Override
        public String toString(){
            return "" + element();
        }
    }
    
    
    private BTNode<Entry<K,V>> checkPosition(Position<Entry<K,V>> v){
        if(!isEmpty())
            return (BTNode<Entry<K,V>>)v;
        return null;    //invalid pos
    }
    
    //heap prop: key(parent(v)) < key(v)
    private boolean heapPropertyIsValid(BTNode<Entry<K,V>> z) throws EmptyTreeException{
        if(z.getParent() == null)
            return true;
       
        SimpleEntry<K,V> parentEntry = (SimpleEntry<K,V>) z.getParent().element();
        Entry<K,V> entry = (Entry<K,V>) z.element();
        System.out.println("-> comparing "  + z + " and " + z.getParent());
        return !(parentEntry.compareTo(entry) > 0);
    }
    
    //on the whole heap
    private boolean heapPropertyIsValid() throws EmptyTreeException{
        //forse da aggiustare ma va bene anche così, dovrei passare un nodo ma solo in questa funzione quindi lascio stare
        for(Position<Entry<K,V>> z: v){
            if(!heapPropertyIsValid((BTNode<Entry<K, V>>) z))
                return false;
        }
        
        return true;
    }
    
    private void switchNodes(BTNode<Entry<K,V>> a, BTNode<Entry<K,V>> b){
        System.out.println("-->switching " + a + " " + b);
        BTNode<Entry<K,V>> temp = new BTNode(a.element());
        
        a.setElement(b.element());
        
        b.setElement(temp.element());
    }
    
    //upheap and downheapbubbling
    private void upHeapBubbling() throws EmptyTreeException{
        BTNode<Entry<K,V>> z = (BTNode<Entry<K,V>>)v[vSize - 1];
        
        while(!heapPropertyIsValid(z)){
            switchNodes(z,z.getParent());
            
            z = z.getParent();
        }
    }
    
    private void printArray(){
        System.out.println("-----START-----");
        for(int i = 0; i < vSize; i++)
            System.out.println("   " + v[i]);
        System.out.println("-----END-----");
    }
    
    
    @Override
    public Position<Entry<K,V>> add(Entry<K,V> element) {
        BTNode<Entry<K,V>> node = new BTNode(element);
        
        if(!isEmpty()){
            
            BTNode<Entry<K,V>> parentNode = (BTNode<Entry<K,V>>) v[parentInt];
            node.setParent(parentNode);
            
            //se non è vuoto inserisco prima a sx se c'è gia inserisco a destra
            try {
                if(!hasLeft(parentNode))
                    parentNode.setLeft(node);
                else{
                    parentNode.setRight(node);
                    parentInt++;
                }
            } catch (InvalidPositionException ex) {

            }
            
            v[vSize++] = node;
        }
        else{
            //la radice è il primo nodo
            root = node;
            v[vSize++] = root;
        }
        
        try {
            System.out.println("upHeapBubbling");
            upHeapBubbling();
        } 
        catch (EmptyTreeException ex) {
            
        }
        
        printArray();
       
        return node;
    }

    //DOWNHEAPBUBBLING: parto dalla radice e scendo verso il più piccolo
    //DA RIVEDERE, CONFRONTA CON QUADERNO
    private void downHeapBubbling1() throws EmptyTreeException{
         
    }
    
    private void downHeapBubbling() throws EmptyTreeException, InvalidPositionException{
        BTNode<Entry<K,V>> z = (BTNode<Entry<K,V>>)root;
        
        if(!hasLeft(z) && !hasRight(z))
            return;
        
        BTNode<Entry<K,V>> w = new BTNode(null); //minChild tra i due figli
        if(!hasRight(z))
            w = z.getLeft();
        else{
            SimpleEntry<K,V> a = (SimpleEntry<K,V>) z.getLeft().element();
            
            if(a.compareTo(z.getRight().element()) < 0)
                w = z.getLeft();
            else
                w = z.getRight();  
        }
            
        while(!heapPropertyIsValid(w)){
           switchNodes(w,w.getParent());
        } 
    }
    
    //parentInt andrebbe modificato
    @Override
    public Entry<K,V> remove() throws EmptyTreeException {
        vSize--;
        Entry<K, V> removed = v[vSize].element(); //entry removed
        System.out.println("removing " + removed);
        switchNodes((BTNode<Entry<K,V>>)root,(BTNode<Entry<K,V>>)v[vSize]);
        
        BTNode<Entry<K,V>> temp = (BTNode<Entry<K,V>>) v[vSize];
//        if(temp.getParent().getLeft() == temp)
  //          parentInt--;
        
        if(vSize < 2)
            return removed;
        
        try {
            System.out.println("downHeapBubbling");
            downHeapBubbling();
        } catch (InvalidPositionException ex) {
            
        }
        
        printArray();
        
        return removed;
    }

    @Override
    public boolean hasLeft(Position<Entry<K,V>> v) throws InvalidPositionException {
        BTNode<Entry<K,V>> n = checkPosition(v);
        return (n.left != null);
    }

    @Override
    public boolean hasRight(Position<Entry<K,V>> v) throws InvalidPositionException {
        BTNode<Entry<K,V>> n = checkPosition(v);
        return (n.right != null);
    }

    @Override
    public Position<Entry<K,V>> left(Position<Entry<K,V>> v) throws BoundaryViolationException, InvalidPositionException {
        BTNode<Entry<K,V>> n = checkPosition(v);
        if(hasLeft(n))
            return n.left;
        return new BTNode<>(null);
    }

    @Override
    public Position<Entry<K,V>> right(Position<Entry<K,V>> v) throws BoundaryViolationException, InvalidPositionException {
        BTNode<Entry<K,V>> n = checkPosition(v);
        if(hasRight(n))
            return n.right;
        return new BTNode<>(null);
    }

    @Override
    //CHIAVE MINIMA!!! 1
    public Position<Entry<K,V>> root() throws EmptyTreeException {
        if(!isEmpty())
            return (Position<Entry<K,V>>) root;
        return new BTNode<>(null);
    }
    
    @Override
    public Position<Entry<K,V>> parent(Position<Entry<K,V>> v) throws BoundaryViolationException, InvalidPositionException {
        BTNode<Entry<K,V>> n = checkPosition(v);
        return n.getParent();
    }

    @Override
    public Iterable<Position<Entry<K,V>>> children(Position<Entry<K,V>> v) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numChildren(Position<Entry<K,V>> v) {
        BTNode<Entry<K,V>> n = checkPosition(v);
        int numChildren = 0;
        if(n.getLeft()!=null)
            numChildren++;
        if(n.getRight()!=null)
            numChildren++;
        
        return numChildren;
    }

    @Override
    public boolean isRoot(Position<Entry<K,V>> v) throws InvalidPositionException {
        return root == v;
    }

    @Override
    public boolean isInternal(Position<Entry<K,V>> v) throws InvalidPositionException {
        BTNode<Entry<K,V>> n = (BTNode<Entry<K,V>>) v;
        return n.getLeft() != null || n.getRight() != null;
    }

    @Override
    public boolean isExternal(Position<Entry<K,V>> v) throws InvalidPositionException {
        BTNode<Entry<K,V>> n = (BTNode<Entry<K,V>>) v;
        return n.getLeft() == null && n.getRight() == null;
    }

    @Override
    public Iterator<Entry<K,V>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Position<Entry<K,V>>> positions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entry<K,V> replace(Position<Entry<K,V>> v, Entry<K,V> element) throws InvalidPositionException {
        Entry<K,V> old = v.element();
        BTNode<Entry<K,V>> n = (BTNode<Entry<K,V>>) v;
        n.setElement(element);
        return old;
    }
    

    @Override
    public boolean isEmpty() {
        return vSize == 0;
    }

    @Override
    public int size() {
        return vSize;
    }
    
    
}
