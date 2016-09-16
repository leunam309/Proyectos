/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *Clase EmpleadoTableModel que extiende de la clase abstracta MyAbstractaTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class EmpleadoTableModel extends MyAbstractaTableModel{
    
    /**
     * metodo que pasa la consulta para que se realice
     */
    public EmpleadoTableModel() {
        
            //Establecemos la sentencia SQL que vamos a ejecutar
            super("SELECT DNI, NOMBRE, APELLIDOS, EMAIL, TIPO_CUENTA AS \"CUENTA\", SALARIO_ACTUAL AS \"SUELDO\", USUARIO, CONTRASENIA FROM EMPLEADO WHERE ESTADO = 1");
            
    }
}
