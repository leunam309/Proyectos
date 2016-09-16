/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase PromocionServicioTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class PromocionServicioTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public PromocionServicioTableModel() {
        
            //Establecemos la sentencia SQL que vamos a ejecutar
            super("SELECT ID_PROMOCION, NOMBRE AS \"PROMOCIONES\" FROM PROMOCION");
            
    }
}
