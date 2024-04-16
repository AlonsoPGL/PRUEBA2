/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lothel.soft.rrhh.model;

import java.util.Date;

/**
 *
 * @author marcelo
 */
public class PersonalDeLavanderia extends PersonalDeServicio{
    private boolean autorizacionDeRiesgoBiologico;
    
    public PersonalDeLavanderia(boolean autorizacionDeRiesgoBiologico, TipoTurno turno, boolean estadoPS, Date fechaContratacion, boolean activo, String dni, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaRegistro, String correo, String celular, boolean estado, Cuenta cuenta) {
        super(turno, estadoPS, fechaContratacion, activo, dni, nombre, apellidoPaterno, apellidoMaterno, fechaRegistro, correo, celular, estado, cuenta);
        this.autorizacionDeRiesgoBiologico = autorizacionDeRiesgoBiologico;
    }

    public boolean getAutorizacionDeRiesgoBiologico() {
        return autorizacionDeRiesgoBiologico;
    }

    public void setAutorizacionDeRiesgoBiologico(boolean autorizacionDeRiesgoBiologico) {
        this.autorizacionDeRiesgoBiologico = autorizacionDeRiesgoBiologico;
    }
    
    
    
    
}
