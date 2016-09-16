/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase ReservaCajaTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class ReservaCajaTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public ReservaCajaTableModel() {
        
            //Establecemos la sentencia SQL que vamos a ejecutar
            super("SELECT ID_DETALLE, ID_RESERVA, FECHA_VENTA, CLIENTE.NOMBRE, DNI, TELEFONO, CANTIDAD, SERVICIO, \n" +
"       FECHA_RESERVA AS \"FECHA RESERVA\",\n" +
"       SUM(CANTIDAD*(DETALLE_RESERVA.PRECIO-PROMOCION.DESCUENTO)) AS \"PRECIO TOTAL\" \n" +
"FROM CLIENTE JOIN RESERVA USING(DNI) \n" +
"             JOIN DETALLE_RESERVA USING(ID_RESERVA) \n" +
"             JOIN SERVICIO USING(ID_SERVICIO) \n" +
"     JOIN PROMOCION USING(ID_PROMOCION)\n" +
"GROUP BY ID_DETALLE, ID_RESERVA, FECHA_VENTA, CLIENTE.NOMBRE, DNI, TELEFONO, CANTIDAD, SERVICIO, FECHA_RESERVA");
            
    }
}
