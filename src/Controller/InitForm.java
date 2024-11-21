/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

/**
 *
 * @author Shreck
 */
public interface InitForm<Entity> {
    void fillToTable();
    void setForm(Entity o);
    void getForm(int index);
}
