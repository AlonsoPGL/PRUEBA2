/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lothel.soft.gestReserva.model;

/**
 *
 * @author marcelo
 */
public class Familiar extends Habitacion {
    private boolean cocheraPropia;

    public Familiar(boolean cocheraPropia, int piso, int numeroDeCamas, double precio, boolean reservado) {
        super(piso, numeroDeCamas, precio, reservado);
        this.cocheraPropia = cocheraPropia;
    }

    public boolean getCocheraPropia() {
        return cocheraPropia;
    }

    public void setCocheraPropia(boolean cocheraPropia) {
        this.cocheraPropia = cocheraPropia;
    }

}
