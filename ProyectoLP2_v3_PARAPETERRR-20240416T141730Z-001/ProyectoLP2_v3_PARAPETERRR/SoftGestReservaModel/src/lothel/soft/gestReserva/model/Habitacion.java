/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lothel.soft.gestReserva.model;

import java.util.ArrayList;

/**
 *
 * @author marcelo
 */
public class Habitacion {
    
    private int idHabitacion;
    private int piso;
    private int numeroDeCamas;
    private double precio;
    private boolean reservado;
    
    private ArrayList<ReservaHabitacion> reservas;

    public Habitacion(int piso, int numeroDeCamas, double precio, boolean reservado) {
        this.piso = piso;
        this.numeroDeCamas = numeroDeCamas;
        this.precio = precio;
        this.reservado = reservado;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumeroDeCamas() {
        return numeroDeCamas;
    }

    public void setNumeroDeCamas(int numeroDeCamas) {
        this.numeroDeCamas = numeroDeCamas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public ArrayList<ReservaHabitacion> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<ReservaHabitacion> reservas) {
        this.reservas = reservas;
    }
    
    
    
}
