/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.ventas.mysql;

import java.util.ArrayList;
import lothel.soft.ventas.dao.PedidoDAO;
import lothel.soft.ventas.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.Date;
import lothel.soft.gestReserva.model.ReservaHabitacion;
import lothel.soft.manager.DBManager;
import lothel.soft.ventas.model.EstadoPedido;
/**
 *
 * @author efeproceres
 */
public class PedidoMYSQL implements PedidoDAO{
    private Connection con;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private Statement st;
    
    @Override
    public int insertar(Pedido pedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call InsertarPedido(?,?)}");
            //cs.setString("_estado",EstadoPedido.Pendiente);
            cs.setDouble("_montoAcumulado",pedido.getMontoAcumulado());
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
    public int modificar(Pedido pedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call ModificarEvento(?,?)}");
            //cambiar el estado del pedido
            cs.setInt("_idPedido", pedido.getIdPedido());
            //cs.setDate("_idEstado", pedido.getEstado());

            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        
        return resultado;
    }

    @Override
    public int eliminar(int pedido) {
    int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call EliminarEvento(?)}");
            cs.setInt("_idPedido", pedido);
            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> pedidos =  new ArrayList<Pedido>();
        
        try{
            con = DBManager.getInstance().getConnection();
            
            String sql = "SELECT * FROM evento";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                ReservaHabitacion reserva= new ReservaHabitacion();
                
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setFechaSolicitud(rs.getDate("fechaSolicitud"));
                //pedido.setEstado(rs.getString("estadoPedido"));
                pedido.setMontoAcumulado(rs.getInt("montoAcumulado"));
                //falta datos de la reservahabitacion falta los get y sets
                pedido.setReserva(reserva);
                pedidos.add(pedido);
            }   
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return pedidos;
    }

}
