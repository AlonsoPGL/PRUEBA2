/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lothel.soft.ventas.dao;

import java.util.ArrayList;
import lothel.soft.ventas.model.DocumentoDePago;

/**
 *
 * @author efeproceres
 */
public interface documentoPagoDAO {
   public int insertar(DocumentoDePago documentoPago);
   public int modificar(DocumentoDePago documentoPago);
   public int eliminar(int idDocumentoPago);
   public ArrayList<DocumentoDePago> listarDocumentos();
}
