/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.evento.model;

import java.util.Date;

/**
 *
 * @author efeproceres
 */
public class ReservaEspacio {
    private int idReservaEspacio;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;
    private Espacio espacio;
    private Evento evento;

    public ReservaEspacio(Date fechaInicio, Date fechaFin, boolean estado, Espacio espacio, Evento evento) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.espacio = espacio;
        this.evento = evento;
    }

    public int getIdReservaEspacio() {
        return idReservaEspacio;
    }

    public void setIdReservaEspacio(int idReservaEspacio) {
        this.idReservaEspacio = idReservaEspacio;
    }

    public ReservaEspacio() {
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
}
