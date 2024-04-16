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
public class ServicioDeLavanderia extends Servicio{
    private String anotaciones;

    public ServicioDeLavanderia(String anotaciones, String estado, String incidencia, String descripcion, String nombre, double precio, double calificacion, Image imagen) {
        super(estado, incidencia, descripcion, nombre, precio, calificacion, imagen);
        this.anotaciones = anotaciones;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }
    
}
