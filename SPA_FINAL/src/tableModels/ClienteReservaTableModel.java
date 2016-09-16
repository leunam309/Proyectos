/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase ClienteReservaTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class ClienteReservaTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public ClienteReservaTableModel() {        
            //Establecemos la sentencia SQL que vamos a ejecutar
            super("SELECT DNI, NOMBRE, TELEFONO FROM CLIENTE");
               
    }
}
