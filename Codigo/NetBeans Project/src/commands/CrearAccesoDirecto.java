/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.File;

/**
 *
 * @author LAQ
 */
public abstract class CrearAccesoDirecto implements Command {
    private File executable;
    private File lugarDelAcceso;

    /**
     * @return the executable
     */
    public File getExecutable() {
        return executable;
    }

    /**
     * @param executable the executable to set
     */
    public void setExecutable(File executable) {
        this.executable = executable;
    }

    /**
     * @return the lugarDelAcceso
     */
    public File getLugarDelAcceso() {
        return lugarDelAcceso;
    }

    /**
     * @param lugarDelAcceso the lugarDelAcceso to set
     */
    public void setLugarDelAcceso(File lugarDelAcceso) {
        this.lugarDelAcceso = lugarDelAcceso;
    }
}
