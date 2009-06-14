/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.File;
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
public class CrearAccesoDirectoWindowsTest {

    public CrearAccesoDirectoWindowsTest() {
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
     * Test of execute method, of class CrearAccesoDirectoWindows.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        CrearAccesoDirectoWindows instance = new CrearAccesoDirectoWindows("pinpon",new File("C:\\hola"),true,true);

        instance.execute();
        
        //fail("The test case is a prototype.");
    }

    /**
     * Test of undo method, of class CrearAccesoDirectoWindows.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("undo");
        CrearAccesoDirectoWindows instance = null;
        //instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}