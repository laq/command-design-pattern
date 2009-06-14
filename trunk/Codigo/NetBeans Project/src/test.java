
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
 * @author LAQ
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    public static void testEscritorio() {
        String notepad = "C:\\Archivos de programa\\Notepad++\\notepad++.exe";
        CrearAccesoDirectoWindows instance = new CrearAccesoDirectoWindows("SuperNotepad", new File(notepad),true,true);
        try {
            instance.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
