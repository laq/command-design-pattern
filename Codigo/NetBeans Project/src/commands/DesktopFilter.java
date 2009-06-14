/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrador
 */
public class DesktopFilter implements FilenameFilter {

    public boolean accept(File dir, String name) {
        Pattern p = Pattern.compile("Escritorio|Desktop");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static String findDesktop(String home, String fileSep) {
        File casa = new File(home);
        File[] lista = casa.listFiles(new DesktopFilter());
        if (lista.length == 1) {
            System.out.println("Desktop:" + lista[0].getAbsolutePath());
            return lista[0].getAbsolutePath();
        } else {
            return "NO DESKTOP";
        }

    }
}
