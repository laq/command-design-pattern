/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.File;

/**
 *
 * @author Administrador
 */
public class CrearCarpeta implements Command {

    private File carpeta;
    private Exception lastException;

    /**
     * Constructor de la clase que recive la direccion de la carpeta File
     * @param carpeta File con la carpeta a crear
     */
    public CrearCarpeta(File carpeta) {
        this.carpeta = carpeta;
    }

    public boolean execute() {
        if (!carpeta.exists()) {
           try{
                carpeta.mkdir();
                return true;
            }catch(Exception e){
                lastException=e;
                return false;
            }
        } else {
                 return true;//Toca revizarlo
        }
    }

    public boolean undo() {
        if (carpeta.exists()) {
            carpeta.delete();
            return true;
        } else {
            return false;
        }
    }

    public Exception getLastException() {
        return lastException;
    }
}
