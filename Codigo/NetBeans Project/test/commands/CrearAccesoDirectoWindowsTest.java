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
     * @throws Exception
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
  //      CrearAccesoDirectoWindows instance = new CrearAccesoDirectoWindows("pinpon",new File("C:\\hola"),true,true);

    //    instance.execute();
        testBoth();
        
        //fail("The test case is a prototype.");
    }

    /**
     * Test of undo method, of class CrearAccesoDirectoWindows.
     * @throws Exception
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("undo");
//        CrearAccesoDirectoWindows instance = null;
        //instance.undo();
        // review the generated test code and remove the default call to fail.
    }

    public void testBoth(){
                 String notepad = "C:\\Archivos de programa\\Notepad++\\notepad++.exe";
        CrearAccesoDirectoWindows instance = new CrearAccesoDirectoWindows("SuperNotepad", new File(notepad),true,true);
        try {
            instance.execute();
            Thread.sleep(1000);
            instance.undo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}