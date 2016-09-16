/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.cruds;

import crudSpa.models.Empleado;
import java.util.List;
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
public class CrudEmpleadoTest {
    
    public CrudEmpleadoTest() {
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
     * Test of create method, of class CrudEmpleado.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        int tlf=956478347;
        double sal=100;
        Empleado em = new Empleado("4352556z","andres","fernandez",tlf,"andr@gmail.com","USUARIO",sal,"and","123");
        boolean expResult = true;
        boolean result = CrudEmpleado.create(em);
        assertTrue(expResult);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of logueo method, of class CrudEmpleado.
     */
    @Test
    public void testLogueo() {
        System.out.println("logueo");
        String usuario = "admin";
        String contrasenia = "admin";
        boolean expResult = true;
        boolean result = CrudEmpleado.logueo(usuario, contrasenia);
        assertTrue(expResult);
        
        usuario = "admin";
        contrasenia = "1234";
         expResult = true;
        result = CrudEmpleado.logueo(usuario, contrasenia);
        assertTrue(expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of logueoUsuario method, of class CrudEmpleado.
     */
    @Test
    public void testLogueoUsuario() {
        System.out.println("logueoUsuario");
        String usuario = "admin";
        String contrasenia = "admin";
        boolean expResult = true;
        boolean result = CrudEmpleado.logueoUsuario(usuario, contrasenia);
        assertTrue(expResult);
        
        usuario = "admi";
        contrasenia = "adm";
        expResult = true;
         result = CrudEmpleado.logueoUsuario(usuario, contrasenia);
        assertTrue(expResult);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CrudEmpleado.
     */
    @Test
    public void testUpdate() {
        int tlf=956478347;
        double sal=150;
       System.out.println("update");
        Empleado em = new Empleado("4352556z","andres","fernandez ramirez",tlf,"andr@gmail.com","USUARIO",sal,"and","123");
        boolean expResult = true;
        boolean result = CrudEmpleado.update(em);
        assertTrue(expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of activarEmpleado method, of class CrudEmpleado.
     */
    @Test
    public void testActivarEmpleado() {
        /*System.out.println("activarEmpleado");
        Empleado em = null;
        boolean expResult = false;
        boolean result = CrudEmpleado.activarEmpleado(em);
        assertEquals(expResult, result);*/
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of desactivarEmpleado method, of class CrudEmpleado.
     */
    @Test
    public void testDesactivarEmpleado() {
        /*System.out.println("desactivarEmpleado");
        Empleado em = null;
        boolean expResult = false;
        boolean result = CrudEmpleado.desactivarEmpleado(em);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of delete method, of class CrudEmpleado.
     */
    @Test
    public void testDelete_Empleado() {
        System.out.println("delete");
        int tlf=956478347;
        double sal=150;
        Empleado em =  new Empleado("4352556z","andres","fernandez",tlf,"andr@gmail.com","USUARIO",sal,"and","123");
        boolean expResult = true;
        boolean result = CrudEmpleado.delete(em);
        assertTrue(expResult);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CrudEmpleado.
     */
    @Test
    public void testDelete_String() {
        System.out.println("delete");
        String dni = "11111111A";
        boolean expResult = true;
        boolean result = CrudEmpleado.delete(dni);
        assertTrue(expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class CrudEmpleado.
     */
    @Test
    public void testFindAll() {
        /*System.out.println("findAll");
        CrudEmpleado instance = new CrudEmpleado();
        List<Empleado> expResult = null;
        List<Empleado> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findByDni method, of class CrudEmpleado.
     */
    @Test
    public void testFindByDni_Empleado() {
        System.out.println("findByDni");
        int tlf=956478347;
        double sal=150;
        Empleado em =  new Empleado("4352556z","andres","fernandez",tlf,"andr@gmail.com","USUARIO",sal,"and","123");
        Empleado expResult = em;
        Empleado result = CrudEmpleado.findByDni(em);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of findByDni method, of class CrudEmpleado.
     */
    @Test
    public void testFindByDni_String() {
        System.out.println("findByDni");
        String dni = "4352556z";
        Empleado expResult = null;
        Empleado result = CrudEmpleado.findByDni(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
