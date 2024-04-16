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
public class Bebida extends Producto{
    private CategoriaBebida categoria;
    private boolean estaHelada;

    public Bebida(CategoriaBebida categoria, boolean estaHelada, int cantPedido, boolean disponibilidad, int stock, String descripcion, String nombre, double precio, double calificacion, Image imagen) {
        super(cantPedido, disponibilidad, stock, descripcion, nombre, precio, calificacion, imagen);
        this.categoria = categoria;
        this.estaHelada = estaHelada;
    }

    public CategoriaBebida getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBebida categoria) {
        this.categoria = categoria;
    }

    public boolean isEstaHelada() {
        return estaHelada;
    }

    public void setEstaHelada(boolean estaHelada) {
        this.estaHelada = estaHelada;
    }
    
}
