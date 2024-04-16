/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lothel.soft.ventas.dao;

import java.util.ArrayList;
import lothel.soft.ventas.model.Pedido;

/**
 *
 * @author efeproceres
 */
public interface PedidoDAO {
   public int insertar(Pedido pedido);
   public int modificar(Pedido pedido);
   public int eliminar(int pedido);
   public ArrayList<Pedido> listarPedidos();
}
