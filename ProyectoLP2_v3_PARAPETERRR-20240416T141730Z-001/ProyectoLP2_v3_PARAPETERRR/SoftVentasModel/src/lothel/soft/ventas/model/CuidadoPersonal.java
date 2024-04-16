/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.ventas.model;

import java.awt.Image;

/**
 *
 * @author efeproceres
 */
public class CuidadoPersonal extends Producto{
    private CategoriaCuidadoPersonal categoria;

    public CuidadoPersonal(CategoriaCuidadoPersonal categoria, int cantPedido, boolean disponibilidad, int stock, String descripcion, String nombre, double precio, double calificacion, Image imagen) {
        super(cantPedido, disponibilidad, stock, descripcion, nombre, precio, calificacion, imagen);
        this.categoria = categoria;
    }

    public CategoriaCuidadoPersonal getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCuidadoPersonal categoria) {
        this.categoria = categoria;
    }
    
    
}
