/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treetester;

import java.util.Iterator;

/**
 *
 * @author lucaattanasio
 */
public class TreeTester<T> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NonEmptyTreeException, InvalidPositionException, BoundaryViolationException, EmptyTreeException, InvalidArgumentException {
        // TODO code application logic here
        //LinkedBinaryTree<Integer> t = new LinkedBinaryTree<Integer>();
        //t.addLeft(t.addRight(t.addRoot(2), 3), 4);
        
        //LinkedTree<Integer> t = new LinkedTree<>();
        
        LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();  //root
        
        t.addRoot(0);
        
        t.addLeft(t.root(), 1);
        t.addRight(t.root(), 2);
        
        t.addLeft(t.left(t.root()), 3);
        Position<Integer> v = t.addRight(t.left(t.root()), 4);
        
        t.addLeft(t.right(t.root()), 5);
        Position<Integer> last = t.addRight(t.right(t.root()), 6);
        
        Position<Integer> node = t.addLeft(t.left(t.left(t.root())), 15);
        t.replace(node, 7);
        Position<Integer> w = t.addRight(t.left(t.left(t.root())), 8);
        
        // istriangular?
        //t.addLeft(t.right(t.left(t.root())), 9);
        //t.addRight(t.right(t.left(t.root())), 10);
        
        //t.addLeft(t.left(t.right(t.root())), 11);
        //t.addRight(t.left(t.right(t.root())), 12);
        
        //t.addLeft(t.right(t.right(t.root())), 13);
        //t.addRight(t.right(t.right(t.root())), 14);

        /*
        WORKS, DONT DELETE!
        System.out.println("height " +a.height(t));
        System.out.println(t.children(t.left(t.root())));
        System.out.println(t.numChildren(t.left(t.root())));
        
        System.out.println(t.depth(t.left(t.root())));
        
        System.out.println("LCA " + a.LCA(t,v,w));
        System.out.println("distance " + a.distance(t,v,w));
        System.out.println("sum all depths " + a.getSumOfAllDepths(t));
        //System.out.println(t.isRoot(root));
        a.setAvg(t);
        /*Iterator<Integer> iter = t.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
       System.out.println("areIsomorph " + a.areIsomorph(new LinkedBinaryTree<>(), new LinkedBinaryTree<>()));
       System.out.println("isTriangular " + a.isTriangular(t));
       System.out.println("isTriangular " + a.isTriangular2(t));*/
       
       System.out.println("preOrderTrasversal BT ");
       Algorithms.preOrderTrasversal(t);
       System.out.println(v + " next " + Exercices.preorderNext(t, v));
       System.out.println(v + " hasNext " + Exercices.hasPreorderNext(t, v));
       System.out.println(last + " hasNext " + Exercices.hasPreorderNext(t, last));
       System.out.println("findDelta " + Exercices.findDelta(t));
       System.out.println("diameter " + Exercices.diameter(t));
       Iterator<Integer> iterPos = Exercices.getListOfEntriesWithKeyLessThan(t,4);
       while(iterPos.hasNext())
            System.out.println("getListOfEntriesWithKeyLessThan 4: " + iterPos.next());
       
    }
    
}
