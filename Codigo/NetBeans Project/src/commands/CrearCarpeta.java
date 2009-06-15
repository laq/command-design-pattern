/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author LAQ
 */
public class CrearCarpeta implements Command {

    private File carpeta;

    /**
     * Constructor de la clase que recive la direccion de la carpeta File
     * @param carpeta File con la carpeta a crear
     */
    public CrearCarpeta(File carpeta) {
        this.carpeta = carpeta;
    }

    public void execute() throws FileNotFoundException{
        if (!carpeta.exists()) {
            if(!carpeta.mkdir()){
                throw new FileNotFoundException("Ruta o Carpeta Invalida, La carpeta: "+carpeta.getAbsolutePath()+" no pudo ser Creada");
            }
        }
    }

    public void undo() throws FileNotFoundException {
        Eliminadora.deleteFile(carpeta);
    }
    @Override
    public String toString(){
        return "Creando: " + carpeta.toString();
    }
}
