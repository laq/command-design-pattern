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

    public CrearAccesoDirectoWindows(File ejecutable,File lugarDelAcceso){
        setExecutable(ejecutable);
        setLugarDelAcceso(lugarDelAcceso);
    }

    public void execute() throws Exception {
        Process p=Runtime.getRuntime().exec("mkdir 1");
           BufferedReader reader = new BufferedReader(
                        new InputStreamReader (
                        p.getInputStream()));
          String line;
        while ((line = reader.readLine()) != null) {
                System.out.println(line);
                }


    }

    public void undo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
