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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     *
     */
    public boolean execute() {
        // crea los archivos
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(nombre_archivo_origen);
            out = new FileOutputStream(nombre_archivo_destino);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ioex) {
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
