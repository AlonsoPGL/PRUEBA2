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
public class Producto extends Item{
    private int idProducto;
    private int cantPedido;
    private boolean disponibilidad;
    private int stock;
    private EmpresaProveedora empresa;
    
    public Producto(int cantPedido, boolean disponibilidad, int stock, String descripcion, String nombre, double precio, double calificacion, Image imagen) {
        super(descripcion, nombre, precio, calificacion, imagen);
        this.cantPedido = cantPedido;
        this.disponibilidad = disponibilidad;
        this.stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public EmpresaProveedora getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaProveedora empresa) {
        this.empresa = empresa;
    }
    
    public int getCantPedido() {
        return cantPedido;
    }

    public void setCantPedido(int cantPedido) {
        this.cantPedido = cantPedido;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
