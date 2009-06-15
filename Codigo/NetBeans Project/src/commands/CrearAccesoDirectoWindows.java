/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author LAQ
 */
public class CrearAccesoDirectoWindows extends CrearAccesoDirecto {

    private File tmp;

    public CrearAccesoDirectoWindows(String nombre, File lugarDelAcceso, boolean escritorio, boolean menuProgramas) {
        setNombreDelAcceso(nombre);
        setLugarDondeApunta(lugarDelAcceso);
        setEscritorio(escritorio);
        setMenuProgramas(menuProgramas);
    }

    public void verProperties() {
        Properties p = System.getProperties();
        p.list(System.out);
    }
    private void copyNircmd() throws Exception{
        //verProperties();
        //Codigo para copiar el archivo del jar a temporal
        InputStream i = Thread.currentThread().getContextClassLoader().getResourceAsStream("util/nircmd.exe");
        String tempdir = System.getProperty("java.io.tmpdir");
        String fileSep = System.getProperty("file.separator");
        System.out.println(tempdir);
        tmp = new File(tempdir + fileSep + "nircmd.exe");
        System.out.println(tmp);
        OutputStream os = new FileOutputStream(tmp);

        int num = 0;
        byte[] b = new byte[30];
        num = i.read(b);
        while (num > 0) {
            os.write(b);
            num = i.read(b);
        }
        os.close();
    }

    public void execute() throws Exception {
        copyNircmd();
        //String home = System.getProperty("user.home");


        //nirmcd.exe shortcut "x:\el_nombre_de_programa" "path_donde_se_copiara_el_acceso_directo" "Nombre_nuevo_de_acceso_directo"
        //Se crea la orden con el .exe la orden y la direccion del programa
        String orden = "\"" + tmp.getAbsolutePath() + "\" shortcut \"" + getLugarDondeApunta().getAbsolutePath() + "\"";
        //se adiciona el lugar del acceso y el nombre del mismo
        //Luego se ejecuta
        if (isEscritorio()) {
            String destino = "~$folder.desktop$";//tomado de la ayuda de nircmd
            String ordenEsc = orden + " \"" + destino + "\" \"" + getNombreDelAcceso() + "\"";
            exec(ordenEsc);
        }
        if (isMenuProgramas()) {
            String destino = "~$folder.programs$";//tomado de la ayuda de nircmd
            String ordenMen = orden + " \"" + destino + "\" \"" + getNombreDelAcceso() + "\"";
            exec(ordenMen);
        }
    }

    private void exec(String orden) throws Exception {
        //Crea el comando
        System.out.println(orden);
        Process p = Runtime.getRuntime().exec(orden);
        //responde el comando por consola
        BufferedReader input = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        String line = null;

        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void undo() throws Exception {
         String fileSep = System.getProperty("file.separator");
        if(tmp==null){
            copyNircmd();
        }
         //String home = System.getProperty("user.home");

        //nirmcd.exe execmd del "~$folder.desktop$\calc.lnk"
        //Se crea la orden con el .exe la orden y la direccion del programa
        String orden = "\"" + tmp.getAbsolutePath() + "\" execmd del";
        //se adiciona el lugar del acceso y el nombre del mismo
        //Luego se ejecuta
        if (isEscritorio()) {
            String destino = "~$folder.desktop$";//tomado de la ayuda de nircmd
            String ordenEsc = orden + " \"" + destino + fileSep+getNombreDelAcceso() + ".lnk\"";
            exec(ordenEsc);
        }
        if (isMenuProgramas()) {
            String destino = "~$folder.programs$";//tomado de la ayuda de nircmd
            String ordenMen =  orden + " \"" + destino + fileSep+getNombreDelAcceso() + ".lnk\"";
            exec(ordenMen);
        }
        
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
