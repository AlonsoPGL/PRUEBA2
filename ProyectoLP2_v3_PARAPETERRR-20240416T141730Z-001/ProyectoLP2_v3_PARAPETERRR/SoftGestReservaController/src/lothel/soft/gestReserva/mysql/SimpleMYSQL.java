/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lothel.soft.gestReserva.mysql;

import java.util.ArrayList;
import lothel.soft.gestReserva.model.Simple;
import lothel.soft.gestReserva.dao.SimpleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.DriverManager;

/**
 *
 * @author marcelo
 */
public class SimpleMYSQL implements SimpleDAO{
    
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public int insertar(Simple simple) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel","admin","lothel321");
            cs = con.prepareCall("{call INSERTAR_SIMPLE(?,?,?,?,?,?)}");
            cs. registerOutParameter("_id_simple", java.sql.Types.INTEGER);
            cs.setInt("_piso", simple.getPiso());
            cs.setInt("_numero_de_camas", simple.getNumeroDeCamas());
            cs.setDouble("_precio", simple.getPrecio());
            cs.setBoolean("_reservado", simple.getReservado());
            cs.setBoolean("_tieneVistaInterior", simple.getTieneVistaInterior());
            cs.setBoolean("_servicioStreaming", simple.getServicioStreaming());
            cs.executeUpdate();
            simple.setIdHabitacion(cs.getInt("_id_simple"));
            resultado = simple.getIdHabitacion();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            try{con.close();}catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int modificar(Simple simple) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel","admin","lothel321");
            cs = con.prepareCall("{call MODIFICAR_RESERVADO(?,?)");
            cs.setInt("_idHabitacion", simple.getIdHabitacion());
            cs.setBoolean("_reservado", simple.getReservado());
            resultado = cs.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idHabitacion) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel","admin","lothel321");
            cs = con.prepareCall("{call ELIMINAR_SIMPLE(?)}");
            cs.setInt("_id_simple", idHabitacion);
            resultado = cs.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Simple> listarHabitacionesSimples() {
        ArrayList<Simple> habSimples = new ArrayList<Simple>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel","admin","lothel321");
            cs = con.prepareCall("{call LISTAR_HABITACIONES_SIMPLES()");
            String sql = "SELECT * FROM SIMPLE";
            rs = cs.executeQuery();
            
            while(rs.next()) {
                Simple simple = new Simple(rs.getBoolean("tieneVistaInterior"),
                        rs.getBoolean("servicioStreaming"), rs.getInt("piso"), 
                        rs.getInt("NumeroDeCamas"), rs.getDouble("Precio"), rs.getBoolean("Reservado"));
                habSimples.add(simple);   
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return habSimples;
    }
    
}
