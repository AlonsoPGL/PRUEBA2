/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lothel.soft.gestReserva.model;

/**
 *
 * @author marcelo
 */
public class Matrimonial extends Habitacion{
    private boolean tieneJacuzzi;

    public Matrimonial(boolean tieneJacuzzi, int piso, int numeroDeCamas, double precio, boolean reservado) {
        super(piso, numeroDeCamas, precio, reservado);
        this.tieneJacuzzi = tieneJacuzzi;
    }

    public boolean getTieneJacuzzi() {
        return tieneJacuzzi;
    }

    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }
    
}
