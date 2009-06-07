/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.File;
import java.io.FileNotFoundException;

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

    public void execute() {
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    public void undo() throws FileNotFoundException {
        Eliminadora.deleteFile(carpeta);
    }
}
