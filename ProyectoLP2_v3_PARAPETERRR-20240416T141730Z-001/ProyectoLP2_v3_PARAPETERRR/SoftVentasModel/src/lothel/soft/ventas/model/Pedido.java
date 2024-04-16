/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.ventas.model;

import java.util.ArrayList;
import java.util.Date;
import lother.soft.gestReserva.Model.ReservaHabitacion;

/**
 *
 * @author efeproceres
 */
public class Pedido {
    private int idPedido;
    private Date fechaSolicitud;
    private EstadoPedido estado;
    private double montoAcumulado;
    private ArrayList<Item>items;
    private DocumentoDePago documentoPago;
    private ReservaHabitacion reserva;

    public Pedido() {
    }

    public Pedido(Date fechaSolicitud, EstadoPedido estado, double montoAcumulado, ReservaHabitacion reserva,TipoDocumento tipo) {
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.montoAcumulado = montoAcumulado;
        this.reserva = reserva;
        documentoPago=new DocumentoDePago(tipo);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double getMontoAcumulado() {
        return montoAcumulado;
    }

    public void setMontoAcumulado(double montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public DocumentoDePago getDocumentoPago() {
        return documentoPago;
    }

    public void setDocumentoPago(DocumentoDePago documentoPago) {
        this.documentoPago = documentoPago;
    }

    public ReservaHabitacion getReserva() {
        return reserva;
    }

    public void setReserva(ReservaHabitacion reserva) {
        this.reserva = reserva;
    }
    
    
}
