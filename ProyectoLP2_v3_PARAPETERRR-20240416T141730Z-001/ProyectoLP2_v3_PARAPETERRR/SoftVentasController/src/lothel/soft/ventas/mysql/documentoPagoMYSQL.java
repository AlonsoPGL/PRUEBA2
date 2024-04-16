/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.ventas.mysql;

import java.util.ArrayList;
import lothel.soft.manager.DBManager;
import lothel.soft.ventas.dao.documentoPagoDAO;
import lothel.soft.ventas.model.DocumentoDePago;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import lothel.soft.ventas.model.Pedido;
/**
 *
 * @author efeproceres
 */
public class documentoPagoMYSQL implements documentoPagoDAO{
    private Connection con;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private Statement st;
    
    @Override
    public int insertar(DocumentoDePago documentoPago) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            //cs.registerOutParameter("_id_empleado",java.sql.Types.INTEGER);
            cs = con.prepareCall("{call INSERTAR_DOCUMENTO_PAGO(?,?)}");
            
            cs.setInt("_idPedido", documentoPago.getPedido().getIdPedido());
            //cs.setString("_tipoDocumento", documentoPago.getTipo());
            
            
            
            //cs.setDate("_fecha_nacimiento", new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            
            resultado=cs.executeUpdate();
            
            //empleado.setIdPersona(cs.getInt("_id_empleado"));
            
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
    public int modificar(DocumentoDePago documentoPago) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call MODIFICAR_DocumentoPago(?,?)}");
            cs.setInt("_idDocumentoPago", documentoPago.getIdDocumentoPago());
            //cs.setString("_tipoDocumento", documentoPago.getTipo().));
            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idDocumentoPago) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();

            cs = con.prepareCall("{call Eliminar_DocumentoPago(?)}");
            cs.setInt("_idDocumentoPago", idDocumentoPago);
            resultado = cs.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;    
    }

    @Override
    public ArrayList<DocumentoDePago> listarDocumentos() {
        ArrayList<DocumentoDePago> documentos =  new ArrayList<DocumentoDePago>();
        
        try{
            con = DBManager.getInstance().getConnection();
            
            String sql = "SELECT * FROM espacio";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                DocumentoDePago documento = new DocumentoDePago();
                Pedido pedido = new Pedido();
                documento.setIdDocumentoPago(rs.getInt("idDocumento"));
                documento.setFechaEmision(rs.getDate("fechaEmision"));
                //documento.setTipo(rs.getString("tipoDocumento"));
                pedido.setFechaSolicitud(rs.getDate("fechaSolicitud"));
                pedido.setMontoAcumulado(rs.getDouble("montoAcumulado"));
                pedido.setIdPedido(rs.getInt("idPedido"));
                documento.setPedido(pedido);
                documentos.add(documento);
            }   
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return documentos;
    }

}
