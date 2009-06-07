/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
     * @param destino
     */
    public CopiarArchivo(File origen, File destino) {
        nombre_archivo_origen = origen;
        nombre_archivo_destino = destino;
    }

    /**
     *  Ejecuta la copia de un archivo a otro
     */
    public void execute() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(nombre_archivo_origen);
        FileOutputStream fos = new FileOutputStream(nombre_archivo_destino);
        FileChannel canalFuente = fis.getChannel();
        FileChannel canalDestino = fos.getChannel();
        canalFuente.transferTo(0, canalFuente.size(), canalDestino);
        fis.close();
        fos.close();
    }

    /**
     * Borra el archivo creado si lo encuentra.
     */
    public void undo() throws FileNotFoundException {
        // borra archivo destino
        Eliminadora.deleteFile(nombre_archivo_destino);
    }

}
