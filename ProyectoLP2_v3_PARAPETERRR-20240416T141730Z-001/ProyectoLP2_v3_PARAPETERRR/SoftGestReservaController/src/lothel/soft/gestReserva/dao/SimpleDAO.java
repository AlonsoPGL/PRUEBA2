/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lothel.soft.gestReserva.dao;

import java.util.ArrayList;
import lothel.soft.gestReserva.model.Simple;

/**
 *
 * @author marcelo
 */
public interface SimpleDAO {
    int insertar(Simple simple);
    int modificar(Simple simple);
    int eliminar(int idHabitacion);
    ArrayList<Simple> listarHabitacionesSimples();
}
