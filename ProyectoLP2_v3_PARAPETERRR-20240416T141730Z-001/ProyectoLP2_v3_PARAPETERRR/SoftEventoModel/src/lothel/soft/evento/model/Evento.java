/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.evento.model;

import java.util.ArrayList;
import java.util.Date;
import lothel.soft.rrhh.model.Administrador;

/**
 *
 * @author efeproceres
 */
public class Evento {
    private int idEvento;
    private String nombre;
    private String descripcion;
    private int cantidadAsistentes;
    private Date fechaRealizacion;
    private String estado;
    private EstadoEvento tipo;
    private Administrador administrador;
    private ArrayList<ReservaEspacio> reservaEspacios;

    public Evento(String nombre, String descripcion, int cantidadAsistentes, Date fechaRealizacion, String estado, EstadoEvento tipo,Administrador administrador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadAsistentes = cantidadAsistentes;
        this.fechaRealizacion = fechaRealizacion;
        this.estado = estado;
        this.tipo = tipo;
        this.administrador=administrador;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    
    public Evento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoEvento getTipo() {
        return tipo;
    }

    public void setTipo(EstadoEvento tipo) {
        this.tipo = tipo;
    }

    public ArrayList<ReservaEspacio> getReservaEspacios() {
        return reservaEspacios;
    }

    public void setReservaEspacios(ArrayList<ReservaEspacio> reservaEspacios) {
        this.reservaEspacios = reservaEspacios;
    }
    
    
}
