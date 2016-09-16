/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase PromocionTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class PromocionTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public PromocionTableModel() {
        
            //Establecemos la sentencia SQL que vamos a ejecutar
            super("SELECT ID_PROMOCION , NOMBRE, DESCUENTO FROM PROMOCION");
            
    }
}
