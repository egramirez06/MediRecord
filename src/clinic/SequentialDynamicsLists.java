/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinic;

/**
 *
 * @author maria
 * @param <T>
 * @param <K>
 */
public interface SequentialDynamicsLists<T,K> extends DynamicLists<T, K> {
    public T get();
    public boolean remove();
}
