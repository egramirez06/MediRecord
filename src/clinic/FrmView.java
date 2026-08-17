/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinic;

/**
 *
 * @author norki
 */

    public interface FrmView<T> {
    void clear();
    void showData(T data);
    void showError(String error);
    void showMessage(String message);
}

