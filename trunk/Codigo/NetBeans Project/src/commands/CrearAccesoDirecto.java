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
    private String nombreDelAcceso;
    private File lugarDondeApunta;

    /**
     * @return the nombreDelAcceso
     */
    public String getNombreDelAcceso() {
        return nombreDelAcceso;
    }

    /**
     * @param nombreDelAcceso the nombreDelAcceso to set
     */
    public void setNombreDelAcceso(String nombreDelAcceso) {
        this.nombreDelAcceso = nombreDelAcceso;
    }

    /**
     * @return the lugarDondeApunta
     */
    public File getLugarDondeApunta() {
        return lugarDondeApunta;
    }

    /**
     * @param lugarDondeApunta the lugarDondeApunta to set
     */
    public void setLugarDondeApunta(File lugarDondeApunta) {
        this.lugarDondeApunta = lugarDondeApunta;
    }

   
}
