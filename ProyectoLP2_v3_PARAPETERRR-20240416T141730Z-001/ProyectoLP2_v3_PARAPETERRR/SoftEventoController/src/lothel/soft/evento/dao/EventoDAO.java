/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lothel.soft.evento.dao;

import java.util.ArrayList;
import java.util.Date;
import lothel.soft.evento.model.Evento;

/**
 *
 * @author efeproceres
 */
public interface EventoDAO {
    int insertar(Evento evento);
    int modificar(Evento evento,Date fechaRealizacion);
    int eliminar(int idEvento);
    ArrayList<Evento> listarEventos();
}
