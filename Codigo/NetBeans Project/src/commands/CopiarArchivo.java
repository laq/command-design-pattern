/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.File;

/**
 *
 * @author david
 */
public class CopiarArchivo implements Command {

    private String nombre_archivo_origen;
    private String nombre_archivo_destino;

    /**
     *
     * @param origen
     * @param origen_dir
     * @param destino
     * @param destino_dir
     */
    public CopiarArchivo(String origen, String destino) {
        nombre_archivo_origen = origen;
        nombre_archivo_destino = destino;
    }

    /**
     *
     */
    public void execute() {

        // crea los archivos
        File srcDir = new File(nombre_archivo_origen);
        File dstDir = new File(nombre_archivo_destino);

        
    }

    public void undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
