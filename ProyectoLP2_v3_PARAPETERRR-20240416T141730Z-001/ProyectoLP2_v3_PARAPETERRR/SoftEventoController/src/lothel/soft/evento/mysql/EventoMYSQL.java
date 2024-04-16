/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.evento.mysql;

import java.util.ArrayList;
import lothel.soft.evento.dao.EventoDAO;
import lothel.soft.evento.model.Evento;
import lothel.soft.manager.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author efeproceres
 */
public class EventoMYSQL implements EventoDAO{
    private Connection con;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private Statement st;
    
    @Override
    public int insertar(Evento evento) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call INSERTAR_Evento(?,?,?,?,?)}");
            cs.setString("_nombre", evento.getNombre());
            cs.setString("_descripcion", evento.getDescripcion());
            cs.setInt("_cantidadAsistente",evento.getCantidadAsistentes());
            cs.setDate("_fechaRealizacion", new java.sql.Date(evento.getFechaRealizacion().getTime()));
            //cs.setINt("_idAdministrador",evento.getIDAMDIN())
            //cs.setString("_estado",evento.getTipo());
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
    public int modificar(Evento evento,Date fechaRealizacion) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call ModificarEvento(?,?)}");
            //cambiar la fecha del evento
            cs.setInt("_idEspacio", evento.getIdEvento());
            cs.setDate("_idfechaRealizacion", (java.sql.Date) fechaRealizacion);

            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        
        return resultado;
    }

    @Override
    public int eliminar(int idEvento) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call EliminarEvento(?)}");
            cs.setInt("_idEvento", idEvento);
            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Evento> listarEventos() {
        ArrayList<Evento> eventos =  new ArrayList<Evento>();
        
        try{
            con = DBManager.getInstance().getConnection();
            
            String sql = "SELECT * FROM evento";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Evento evento = new Evento();
                evento.setIdEvento(rs.getInt("idEvento"));
                evento.setNombre(rs.getString("nombre"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setCantidadAsistentes(rs.getInt("cantidadAsistentes"));
                evento.setFechaRealizacion(rs.getDate("fechaRealizacion"));
                //evento.setEstado(rs.getString("estado"));
                eventos.add(evento);
            }   
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return eventos;
    }

}   
