/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lothel.soft.evento.dao;

import java.util.ArrayList;
import lothel.soft.evento.model.ReservaEspacio;

/**
 *
 * @author efeproceres
 */
public interface ReservaEspacioDAO {
    int insertar(ReservaEspacio reservaEspacio,int idEspacio,int idEvento);
    int modificar(int idReservaEspacio,int idEspacio);
    int eliminar(int idReserva);
    ArrayList<ReservaEspacio> listarReservas();
}
