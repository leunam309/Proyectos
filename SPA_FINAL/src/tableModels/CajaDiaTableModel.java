/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase CajaDiaTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CajaDiaTableModel extends MyAbstractaTableModel{

    /**
     * metodo que pasa la consulta para que se realice
     */
    public CajaDiaTableModel() {
                    //Establecemos la sentencia SQL que vamos a ejecutar
        super(" SELECT SUM(DETALLE_RESERVA.PRECIO-PROMOCION.DESCUENTO) AS \"VENTAS DEL DIA\" FROM PROMOCION JOIN SERVICIO USING(ID_PROMOCION) JOIN DETALLE_RESERVA USING(ID_SERVICIO) WHERE FECHA_VENTA LIKE SYSDATE");
    }
    
 
}