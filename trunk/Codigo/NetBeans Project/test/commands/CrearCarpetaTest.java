/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class CrearCarpetaTest {

    public CrearCarpetaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class CrearCarpeta.
     */
    @Test
    public void testExecute() {
        try {
            System.out.println("execute");
            //prueba invalida
            System.out.println("    invalido");
            CrearCarpeta instance = new CrearCarpeta(new File(""));
            instance.execute();
        } catch (FileNotFoundException ex) {
            System.out.println("    Exc"+ex);
            //Logger.getLogger(CrearCarpetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //prueba  valida
        System.out.println("    valido");
        try {
            CrearCarpeta  instance = new CrearCarpeta(new File("XXX/"));
            instance.execute();
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
            Logger.getLogger(CrearCarpetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of undo method, of class CrearCarpeta.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("undo");
        CrearCarpeta instance = new CrearCarpeta(new File("XXX/"));;
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}