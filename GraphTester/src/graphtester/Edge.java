/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtester;

/**
 *
 * @author luca
 * @param <T>
 */
public interface Edge<T> extends Position<T> {
    void setLabel(String status);
    String getLabel();
}
