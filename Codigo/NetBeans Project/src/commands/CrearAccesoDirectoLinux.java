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
    public CrearAccesoDirectoLinux (File ejecutable, String nombre_aplicacion) {
         this.setLugarDondeApunta(ejecutable);
         this.setNombreDelAcceso(nombre_aplicacion);
    }

    public void execute() throws IOException{
        String a = System.getProperty("user.home");
        System.out.println(a);
        Process pat;
        pat = Runtime.getRuntime().exec("env | egrep LANG");
        BufferedReader Resultset = new BufferedReader(
                        new InputStreamReader (
                        pat.getInputStream()));

        String line;
        while ((line = Resultset.readLine()) != null) {
                System.out.println(line);
                }
        // verifica existencia de carpeta Escritorio
        /*File usr_bin = new File ("/usr/bin");
        File bin = new File ("/bin");

        File nueva = new File ("/usr/bin/nueva");

        Process pat;

        if(usr_bin.exists()){
            nueva.createNewFile();
        } else {
            pat = Runtime.getRuntime().exec("echo $PATH");
        }*/

        /*BufferedReader Resultset = new BufferedReader(
                        new InputStreamReader (
                        pat.getInputStream()));

        String line;
        while ((line = Resultset.readLine()) != null) {
                System.out.println(line);
                }*/
    }

    public void undo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
