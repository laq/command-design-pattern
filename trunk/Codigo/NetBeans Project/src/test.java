
import commands.CrearAccesoDirectoWindows;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         CrearAccesoDirectoWindows instance = new CrearAccesoDirectoWindows("pinpon",new File("C:\\hola"));
        try {
            instance.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
