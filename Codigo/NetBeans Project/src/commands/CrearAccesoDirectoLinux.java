/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author david
 */
public class CrearAccesoDirectoLinux extends CrearAccesoDirecto  {

    /**
     *
     * @param nombre
     * @param lugar_del_acceso
     * @param escritorio
     * @param menuProgramas
     */
    public CrearAccesoDirectoLinux (String nombre, File lugar_del_acceso, boolean escritorio, boolean menuProgramas) {
        setNombreDelAcceso(nombre);
        setLugarDondeApunta(lugar_del_acceso);
        setEscritorio(escritorio);
        setMenuProgramas(menuProgramas);
    }

    public void execute() throws IOException{
        String fileSep= System.getProperty("file.separator");
        String home = System.getProperty("user.home");
        String desktop = DesktopFilter.findDesktop(home,fileSep);

        String str =
                "[Desktop Entry]\n"+
                "Name=" + getNombreDelAcceso() + "\n"+
                "Type=Application\n"+
                "Exec=" + this.getLugarDondeApunta().getAbsolutePath();

        if(isEscritorio()){
            File link = new File(desktop+fileSep+this.getNombreDelAcceso()+".desktop");
            FileOutputStream fop=new FileOutputStream(link);
            fop.write(str.getBytes());
            fop.flush();
            fop.close();
        }

        if(isMenuProgramas()){
            File link = new File(home + fileSep + ".local/share/applications/" + this.getNombreDelAcceso() + ".desktop");
            FileOutputStream fop=new FileOutputStream(link);
            fop.write(str.getBytes());
            fop.flush();
            fop.close();
        }
    }

    public void undo() throws Exception {
        String fileSep= System.getProperty("file.separator");
        String home = System.getProperty("user.home");
        String desktop = DesktopFilter.findDesktop(home,fileSep);

         if(isEscritorio()){
            File link = new File(desktop+fileSep+this.getNombreDelAcceso()+".desktop");
            link.delete();
        }

        if(isMenuProgramas()){
            File link = new File(desktop + fileSep + "./local/share/applications/" + this.getNombreDelAcceso() + ".desktop");
            link.delete();
        }
    }

}
