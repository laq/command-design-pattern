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
    private Exception ex;

    /**
     *
     * @param origen
     * @param destino
     */
    public CopiarArchivo(File origen, File destino) {
        nombre_archivo_origen = origen;
        nombre_archivo_destino = destino;
        ex = null;
    }

    /**
     *  Ejecuta la copia de un archivo a otro
     *  @return true si se realizó con éxito<br />
     *          false si no se realizó con éxito
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
        }catch (FileNotFoundException ex) {
            this.ex = ex;
            return false;
        }catch (IOException ioex) {
            this.ex = ioex;
            return false;
        }
        return true;
    }

    /**
     * Borra el archivo creado si lo encuentra.
     * @return true si se realizó con éxito<br />
     *         false si no se realizó con éxito
     */
    public boolean undo() {
        try {
            // borra archivo destino
            Eliminadora.deleteFile(nombre_archivo_destino);
        } catch (FileNotFoundException ex) {
            this.ex = ex;
            return false;
        }
        return true;
    }

    /**
     * Retirna la excepción encontrada
     * @return Reported Exception
     */
    public Exception getLastException() {
        return ex;
    }

}
