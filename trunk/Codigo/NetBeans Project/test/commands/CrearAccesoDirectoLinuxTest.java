/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class CrearAccesoDirectoLinuxTest {

    public CrearAccesoDirectoLinuxTest() {
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
     * Test of execute method, of class CrearAccesoDirectoLinux.
     */
    /*@Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        File f = new File("/usr/bin/rapidsvn");
        CrearAccesoDirectoLinux instance = new CrearAccesoDirectoLinux("MySVN", f, true, true);
        try{
        instance.execute();
        }catch(IOException ioe){System.out.println("Error por permisos");}
        // TODO review the generated test code and remove the default call to fail.
    }*/

    /**
     * Test of undo method, of class CrearAccesoDirectoLinux.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("undo");
        File f = new File("/usr/bin/rapidsvn");
        CrearAccesoDirectoLinux instance = new CrearAccesoDirectoLinux("MySVN", f, true, true);
        instance.undo();
    }

}