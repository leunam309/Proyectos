/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase CajaTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CajaTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public CajaTableModel() {        
            //Establecemos la sentencia SQL que vamos a ejecutar
            super(" SELECT SUM(DETALLE_RESERVA.PRECIO-PROMOCION.DESCUENTO) AS \"TOTAL VENTAS\" FROM PROMOCION JOIN SERVICIO USING(ID_PROMOCION) JOIN DETALLE_RESERVA USING(ID_SERVICIO)");
            
    }
}
