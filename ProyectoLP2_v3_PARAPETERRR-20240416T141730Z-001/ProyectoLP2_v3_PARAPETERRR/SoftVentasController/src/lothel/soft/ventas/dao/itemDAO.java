/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.ventas.dao;

import java.util.ArrayList;
import lothel.soft.ventas.model.Item;

/**
 *
 * @author efeproceres
 */
public interface itemDAO {
    public int insertar(Item item);
    public int modificar(Item item,double precio);
    public int eliminar(int idItem);
    public ArrayList<Item> listarItems();
}
