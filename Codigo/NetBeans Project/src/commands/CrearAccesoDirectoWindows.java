/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author Administrador
 */
public class CrearAccesoDirectoWindows extends CrearAccesoDirecto {

    public CrearAccesoDirectoWindows(String nombre,File lugarDelAcceso){
        setNombreDelAcceso(nombre);
        setLugarDondeApunta(lugarDelAcceso);
    }

    public void execute() throws Exception {
        String home=System.getProperty("user.home");
        System.out.println(home+"\\Escritorio\\hola");
        Process p=Runtime.getRuntime().exec("dir.exe");
        System.out.println(p);
           BufferedReader reader = new BufferedReader(
                        new InputStreamReader (
                        p.getInputStream()));
           System.out.println(reader);
          String line;
        while ((line = reader.readLine()) != null) {
                System.out.println(line);
                }


    }

    public void undo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
