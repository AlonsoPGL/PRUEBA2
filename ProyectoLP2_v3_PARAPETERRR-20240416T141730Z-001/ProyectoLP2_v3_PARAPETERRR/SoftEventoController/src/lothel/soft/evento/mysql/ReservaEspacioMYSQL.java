/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.evento.mysql;


import lothel.soft.evento.dao.ReservaEspacioDAO;
import lothel.soft.evento.model.ReservaEspacio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.ArrayList;
import lothel.soft.evento.model.Espacio;
import lothel.soft.evento.model.EstadoEvento;
import lothel.soft.evento.model.Evento;
import lothel.soft.manager.DBManager;

/**
 *
 * @author efeproceres
 */
public class ReservaEspacioMYSQL implements ReservaEspacioDAO{
    private Connection con;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private Statement st;
    
    @Override
    public int insertar(ReservaEspacio reserva,int idEspacio,int idEvento) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();  
            cs = con.prepareCall("{call INSERTAR_ReservaEspacio(?,?,?,?,?)}");
            cs.setDate("_fechaInicio", new java.sql.Date(reserva.getFechaInicio().getTime()));
            cs.setDate("_fechaFin", new java.sql.Date(reserva.getFechaFin().getTime()));
            cs.setBoolean("_estado", false);//false ocupado
            cs.setInt("_idEspacio", idEspacio);//foreign key espacio
            cs.setInt("_idEvento", idEvento);//foreign key evento
            resultado=cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int modificar(int idReservaEspacio,int idEspacio) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            //cambiar de espacio para la reserva
            cs = con.prepareCall("{call MODIFICAR_RESERVAESPACIO(?,?)}");
            cs.setInt("_idEspacio", idEspacio);
            cs.setInt("_idReservaEspacio", idReservaEspacio);
            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idReserva) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call ELIMINAR_RESERVAESPACIO(?)}");
            cs.setInt("_idEspacio", idReserva);
            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<ReservaEspacio> listarReservas() {
        ArrayList<ReservaEspacio> reservas =  new ArrayList<ReservaEspacio>();
        try{
            con = DBManager.getInstance().getConnection();
            
            String sql = "SELECT * FROM espacio";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            //cs = con.prepareCall("{call SelectReservaEspacio(?)}");
            //cs.setBoolean("_estado",true);
            //cs.setBoolean("_idEspacio", false);//false ocupado
            
            //rs = cs.executeUpdate();
            
            while(rs.next()){
                ReservaEspacio reserva = new ReservaEspacio();
                Evento evento = new Evento();
                Espacio espacio = new Espacio();
                
                reserva.setIdReservaEspacio(rs.getInt("idEspacio"));
                reserva.setFechaInicio(rs.getDate("fechaInicio"));
                reserva.setFechaFin(rs.getDate("fechaFin"));
                reserva.setEstado(rs.getBoolean("estado"));
                evento.setNombre(rs.getString("nombre"));
                //evento.setTipo((EstadoEvento.ENCURSO) rs.getString("tipo"));
                //evento.setTipo(EstadoEvento.FINALIZADA);
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setCantidadAsistentes(rs.getInt("cantidadAsistentes"));
                evento.setFechaRealizacion(rs.getDate("fechaRealizacion"));
                reserva.setEvento(evento);
                espacio.setNumeroPiso(rs.getInt("numeroPiso"));
                espacio.setSeccion(rs.getString("seccion"));
                espacio.setAforo(rs.getInt("aforo"));
                reserva.setEspacio(espacio);
                reservas.add(reserva);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return reservas;
    }

    

}
