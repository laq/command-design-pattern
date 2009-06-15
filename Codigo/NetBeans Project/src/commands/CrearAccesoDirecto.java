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
    private boolean escritorio;
    private boolean menuProgramas;

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

    /**
     * @return the escritorio
     */
    public boolean isEscritorio() {
        return escritorio;
    }

    /**
     * @param escritorio the escritorio to set
     */
    public void setEscritorio(boolean escritorio) {
        this.escritorio = escritorio;
    }

    /**
     * @return the menuProgramas
     */
    public boolean isMenuProgramas() {
        return menuProgramas;
    }

    /**
     * @param menuProgramas the menuProgramas to set
     */
    public void setMenuProgramas(boolean menuProgramas) {
        this.menuProgramas = menuProgramas;
    }

    @Override
    public String toString() {
        String creando = "";
        if (isEscritorio()) {
            creando += " acceso directo al escritorio\n";
        }
        if (isMenuProgramas()) {
            creando += " acceso directo al escritorio\n";
        }
        return "Creando: \n "+creando;
    }
}
