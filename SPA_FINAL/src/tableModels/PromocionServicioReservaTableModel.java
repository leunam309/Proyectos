/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase PromocionServicioReservaTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class PromocionServicioReservaTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public PromocionServicioReservaTableModel() {
       
            //Establecemos la sentencia SQL que vamos a ejecutar
            super("SELECT ID_SERVICIO, PRECIO, SERVICIO,PRECIO-DESCUENTO AS \"PRECIO\" FROM PROMOCION JOIN SERVICIO USING(ID_PROMOCION)");
               
    }
}
