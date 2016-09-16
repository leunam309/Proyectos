/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;


import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.table.AbstractTableModel;
/**
 *Clase MyAbstractaTableModel que extiende de la clase AbstractTableModel
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public abstract class MyAbstractaTableModel extends AbstractTableModel{
    
     CachedRowSet rs;
    int nColumnas, nFilas;
    ResultSetMetaData meta;
   
    /**
     * metodo que recoge de la base de datos los distintos elementos pedidos
     * @param sql elemento se le pasa y que se va a ejecutar
     */
    public MyAbstractaTableModel(String sql) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaDiaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            
            //Obtenemos la factoría necesaria para obtener el RowSet
            RowSetFactory rsf = RowSetProvider.newFactory();
            //Obtenemos el RowSet a partir de la factoría
            rs = rsf.createCachedRowSet();       
                   
            //ESTABLECEMOS UNA SERIE DE PROPIEDADES DEL ROWSET
            
            //Primero, establecemos la url de conexión
            rs.setUrl("jdbc:oracle:thin:SPA/1@localhost:1521:XE");        
            //Indicamos que el rowset es de solo lectura
            rs.setConcurrency(CachedRowSet.CONCUR_READ_ONLY);
            rs.setReadOnly(true);
            //Establecemos la sentencia SQL que vamos a ejecutar
            rs.setCommand(sql);
            //Lanzamos la ejecución de la sentencia
            rs.execute();

            //Obtenemos los metadatos, de los cuales vamos a obtener
            //el número de columnas, los tipos de datos de las columnas
            //y los títulos de las mismas.
            meta = rs.getMetaData();
            nColumnas = meta.getColumnCount();

            //Para calcular el número de filas, recorremos todas las filas
            //del rowset, incrementando un contador.
            nFilas = 0;        
            rs.beforeFirst();        
            while(rs.next())
                nFilas++;
            rs.beforeFirst();

        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        
    }    
    
    
  
    public int getRowCount() {
        //Calculado en el constructor
        return nFilas;
    }


    public int getColumnCount()  {
        //Obtenido en el constructor a partir de los metadatos.
        return nColumnas;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = null;
        try {
            //Le sumamos 1 porque JTable comienza a contar en 0 y 
            //RowSet en 1
            
            //Nos desplazamos hasta la fila rowIndex+1
            rs.absolute(rowIndex + 1);
            //Obtenemos el valor (como Object) de la "celda" columnIndex+1
            o = rs.getObject(columnIndex + 1);
            //Si el valor es nulo, devolvemos NULL, en otro caso,
            //devolvemos el valor.
            if (o == null)
                return null;            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return o;
    }

    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       //Como nuestros JTable son de solo lectura, este método siempre
       //devuelve false.
        return false;
    }

    
    public String getColumnName(int column) {
        //Obtenemos el nombre de las columnas a partir de la
        //información de los metadatos.
        String name = null;
        try {
            name = meta.getColumnName(column+1);
        } catch(SQLException e) {
            e.printStackTrace(System.err);
        }
        return name;
    }

    
    public Class<?> getColumnClass(int columnIndex) {        
        Class c = null;
        
        try {
            switch(meta.getColumnType(columnIndex+1)) {
                case java.sql.Types.VARCHAR: c = String.class;
                                             break;
                case java.sql.Types.NUMERIC: c = Integer.class;
                                             break;
                case java.sql.Types.DATE: c = java.util.Date.class;
                                             break;
                default: c = String.class;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    
    protected void finalize() throws Throwable {
        //super.finalize(); //To change body of generated methods, choose Tools | Templates.
        rs.close();    
    }
}

