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
    private File nombreDelAcceso;
    private File lugarDondeApunta;

    /**
     * @return the nombreDelAcceso
     */
    public File getExecutable() {
        return nombreDelAcceso;
    }

    /**
     * @param nombreDelAcceso the nombreDelAcceso to set
     */
    public void setExecutable(File executable) {
        this.nombreDelAcceso = executable;
    }

    /**
     * @return the lugarDondeApunta
     */
    public File getLugarDelAcceso() {
        return lugarDondeApunta;
    }

    /**
     * @param lugarDondeApunta the lugarDondeApunta to set
     */
    public void setLugarDelAcceso(File lugarDelAcceso) {
        this.lugarDondeApunta = lugarDelAcceso;
    }
}
