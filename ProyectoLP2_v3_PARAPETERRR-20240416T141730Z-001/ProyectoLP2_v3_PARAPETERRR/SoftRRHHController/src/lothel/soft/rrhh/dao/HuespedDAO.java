/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lothel.soft.rrhh.dao;

import java.util.ArrayList;
import lothel.soft.rrhh.model.Huesped;

public interface HuespedDAO {
    int insertar(Huesped huesped);
    int modificar(Huesped huesped);
    int eliminar(int idHabitacion);
    ArrayList<Huesped> listarHuespedes();
    
}
