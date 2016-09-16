/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CambiarFecha {
    
    /**
     * metodo para cambiar un tipo Util java A Data sql
     * @param fechaUtil decha en java
     * @return la fecha en formato sql
     */
    public static Date cambiarUtilASQL(java.util.Date fechaUtil){
        java.sql.Date sqlDate= new java.sql.Date(fechaUtil.getTime());
        return sqlDate;
    }
    /**
     * metodo que cambia la fecha de calendar a String para los pdf
     * @param d fecha de calendar
     * @return fecha en String
     */
     public static String cambiarCalendarAStr(Calendar d){
        String res;
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        res=format.format(d.getTime());
        
        return res;
    }
    
    
}
