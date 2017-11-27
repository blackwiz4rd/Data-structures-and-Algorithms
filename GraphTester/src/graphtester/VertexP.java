/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtester;

/**
 *
 * @author luca
 * @param <V>
 * @param <E>
 */
public interface VertexP<V,E> extends Vertex<V>{
    void setParent(Edge<E> e);
    Edge<E> getParent();
}
