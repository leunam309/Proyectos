/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mrevuelta
 */
public class CambiarFechaTest {
    
    public CambiarFechaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("realizando prueba...");
    }
    
    @After
    public void tearDown() {
        System.out.println("prueba realizada!!");
    }

    /**
     * Test of cambiarUtilASQL method, of class CambiarFecha.
     */
    @Test
    public void testCambiarUtilASQL() {
        //fecha actual en milisengundos
        long time=Calendar.getInstance().getTime().getTime();
        
        //Util Date de la fecha actual
        java.util.Date fechaPrueba= new java.util.Date(time);
        
        //valor esperado SQL Date de fecha actual 
        java.sql.Date esperado=new java.sql.Date(time);
        
        //probamos el cambio a SQL Date
        java.sql.Date actual=CambiarFecha.cambiarUtilASQL(fechaPrueba);
        
        
        //probamos si el valor esperado coincide con el actual
        assertEquals(esperado, actual);
    }

    /**
     * Test of cambiarCalendarAStr method, of class CambiarFecha.
     */
    @Test
    public void testCambiarCalendarAStr() {
        
        //valor esperado String fecha actual
        String esperado = "21/05/2015";
        
        //valor de prueba
        Calendar fechaPrueba= new GregorianCalendar(2015,04,21);
        
        //valor actual
        String actual= CambiarFecha.cambiarCalendarAStr(fechaPrueba);
        
        //probamos si el valor esperado coincide con el actual
        assertEquals(esperado, actual);
        
        
        //valor esperado String fecha actual
        esperado = "21/05/2014";
        
        //valor de prueba
        fechaPrueba= new GregorianCalendar(2015,04,21);
        
        //valor actual
        actual= CambiarFecha.cambiarCalendarAStr(fechaPrueba);
        
        //probamos si el valor esperado coincide con el actual
        assertEquals(esperado, actual);
        
    }
    
}
