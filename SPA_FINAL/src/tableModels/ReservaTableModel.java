/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase ReservaTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class ReservaTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public ReservaTableModel() {
        
            //Establecemos la sentencia SQL que vamos a ejecutar
            super("SELECT ID_DETALLE, ID_RESERVA, FECHA_VENTA, NOMBRE, DNI, TELEFONO, CANTIDAD, SERVICIO, FECHA_RESERVA AS \"FECHA RESERVA\" FROM CLIENTE JOIN RESERVA USING(DNI) JOIN DETALLE_RESERVA USING(ID_RESERVA) JOIN SERVICIO USING(ID_SERVICIO) ORDER BY FECHA_VENTA DESC");
            
    }
}
