    /*
    *   1st interface created
 */
package tree;

import java.util.Iterator;

/**
 *
 * @author lucaattanasio
 */
public interface Tree<T> extends Container, Iterable<T>{
    Position<T> root() throws EmptyTreeException;
    Position<T> parent(Position<T> v) throws BoundaryViolationException, InvalidPositionException;
    
    Iterable<Position <T>> children(Position<T> v) throws InvalidPositionException; //restituisce pos dei figli dei nodi per poi navigare l'albero
    int numChildren(Position<T> v);

    boolean isRoot(Position<T> v) throws InvalidPositionException;
    boolean isInternal(Position<T> v) throws InvalidPositionException;
    boolean isExternal(Position<T> v) throws InvalidPositionException;
    
    @Override
    Iterator<T> iterator(); //dati   -  snapshot
    Iterable<Position<T>> positions();  //posizioni     - snapshot
    
    T replace(Position<T> v, T element) throws InvalidPositionException;
}

