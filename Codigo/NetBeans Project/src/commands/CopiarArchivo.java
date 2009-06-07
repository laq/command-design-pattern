/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author david
 */
public class CopiarArchivo implements Command {

    private File nombre_archivo_origen;
    private File nombre_archivo_destino;

    /**
     *
     * @param origen
     * @param origen_dir
     * @param destino
     * @param destino_dir
     */
    public CopiarArchivo(File origen, File destino) {
        nombre_archivo_origen = origen;
        nombre_archivo_destino = destino;
    }

    /**
     *  Ejecuta la copia de un archivo a otro
     */
    public boolean execute() {
        try{
            FileInputStream fis = new FileInputStream(nombre_archivo_origen);
            FileOutputStream fos = new FileOutputStream(nombre_archivo_destino);
            FileChannel canalFuente = fis.getChannel();
            FileChannel canalDestino = fos.getChannel();
            canalFuente.transferTo(0, canalFuente.size(), canalDestino);
            fis.close();
            fos.close();
        }catch (IOException ex) {
            return false;
        }
        return true;
    }

    public boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Exception getLastException() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
