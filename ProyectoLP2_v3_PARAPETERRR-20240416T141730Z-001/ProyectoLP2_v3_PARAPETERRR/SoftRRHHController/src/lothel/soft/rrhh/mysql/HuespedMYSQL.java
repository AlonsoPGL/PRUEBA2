/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lothel.soft.rrhh.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lothel.soft.rrhh.dao.HuespedDAO;
import lothel.soft.rrhh.model.Huesped;

/**
 *
 * @author marcelo
 */
public class HuespedMYSQL implements HuespedDAO {

    private Connection con;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private Statement st;
    
    @Override // pq el error de override?????????''
    public int insertar(Huesped huesped) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel","admin","lothel321");
            cs = con.prepareCall("{call INSERTAR_HUESPED(?,?,?,?,?,?,?,?,?)");
            cs.setString("_dni", huesped.getDni());
            cs.setString("_nombre", huesped.getNombre());
            cs.setString("_apellidoPaterno", huesped.getApellidoPaterno());
            cs.setString("_apellidoMaterno", huesped.getApellidoMaterno());
            cs.setDate("_fechaRegistro", new java.sql.Date(huesped.getFechaRegistro().getTime()));
            cs.setString("_correo", huesped.getCorreo());
            cs.setString("_celular", huesped.getCelular());
            cs.setBoolean("_estado", huesped.getEstado());
            cs.setBoolean("_esVIP", huesped.getEsVIP());
            cs.executeUpdate();
            huesped.setIdPersona(cs.getInt("_id_persona"));
            resultado = huesped.getIdPersona();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int modificar(Huesped huesped) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel","admin","lothel321");
            cs = con.prepareCall("{call _MODIFICAR_ESTADO(?,?)}");
            cs.setInt("_idPersona", huesped.getIdPersona());
            cs.setBoolean("_estado", huesped.getEstado());
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
            cs = con.prepareCall("{call ELIMINAR_HUESPED(?)}");
            cs.setInt(("_idPersona"), idHabitacion);
            resultado = cs.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
    return resultado;
    }

    @Override
    public ArrayList<Huesped> listarHuespedes() {
        ArrayList<Huesped> huespedes = new ArrayList<Huesped>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel","admin","lothel321");
            cs = con.prepareCall("{call LISTAR_HUESPEDES()}");
            String sql = "SELECT * FROM HUESPED";
            rs = cs.executeQuery();
            
            while(rs.next()) {
                Huesped huesped = new Huesped();
                huesped.setIdPersona(rs.getInt("idPersona"));
                huesped.setNombre(rs.getString("dni"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellidoPaterno(rs.getString("apelllidoPaterno"));
                huesped.setApellidoPaterno(rs.getString("apelllidoMaterno"));
                huesped.setFechaRegistro(rs.getDate("fechaRegistro"));
                huesped.setCorreo(rs.getString("Correo"));
                huesped.setCelular(rs.getString("Celular"));
                huesped.setEstado(rs.getBoolean("activo"));
                huesped.setEsVIP(rs.getBoolean("esVIP"));
                huespedes.add(huesped);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        
        }
        return huespedes;
    }
    
}
