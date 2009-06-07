/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author david
 */
public class CrearAccesoDirectoLinux extends CrearAccesoDirecto  {

    /**
     *
     * @param ejecutable
     */
    public CrearAccesoDirectoLinux (File ejecutable) {
         this.setExecutable(ejecutable);
    }

    public void execute() throws IOException{
        // verifica existencia de carpeta /usr/bin
        File usr_bin = new File ("/usr/bin");
        File bin = new File ("/bin");

        this.setExecutable(usr_bin);

        Process pat;

        if(usr_bin.exists()){
            pat = Runtime.getRuntime().exec("echo $PATH");
        } else {
            pat = Runtime.getRuntime().exec("echo $PATH");
        }

        BufferedReader Resultset = new BufferedReader(
                        new InputStreamReader (
                        pat.getInputStream()));

        String line;
        while ((line = Resultset.readLine()) != null) {
                System.out.println(line);
                }
    }

    public void undo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
