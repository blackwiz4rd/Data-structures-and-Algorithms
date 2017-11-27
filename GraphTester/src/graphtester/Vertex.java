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
 */
public interface Vertex<V> extends Position<V>{
    void setLabel(String status);
    String getLabel();
}