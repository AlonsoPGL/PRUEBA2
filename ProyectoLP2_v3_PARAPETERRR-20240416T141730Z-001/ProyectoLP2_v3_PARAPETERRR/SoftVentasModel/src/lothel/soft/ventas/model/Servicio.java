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
public class Servicio extends Item {
    private String estado;
    private String incidencia;
    public Servicio(String estado, String incidencia, String descripcion, String nombre, double precio, double calificacion, Image imagen) {
        super(descripcion, nombre, precio, calificacion, imagen);
        this.estado = estado;
        this.incidencia = incidencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }
    
}
