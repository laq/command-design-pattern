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

    public CrearAccesoDirectoWindows(String nombre, File lugarDelAcceso,boolean escritorio,boolean menuProgramas) {
        setNombreDelAcceso(nombre);
        setLugarDondeApunta(lugarDelAcceso);
        setEscritorio(escritorio);
        setMenuProgramas(menuProgramas);
    }
    public void verProperties(){
        Properties p=System.getProperties();
        p.list(System.out);
    }

    public void execute() throws Exception {
        //verProperties();
        InputStream i=Thread.currentThread().getContextClassLoader().getResourceAsStream("util/nircmd.exe");
        String tempdir = System.getProperty("java.io.tmpdir");
        String fileSep= System.getProperty("file.separator");
         System.out.println(tempdir);
         File tmp=new File(tempdir+fileSep+"nircmd.exe");
         System.out.println(tmp);
         OutputStream os=new FileOutputStream(tmp);

         //Copia el archivo del jar a la ruta temporal en tmp
         int num=0;
         byte []b =new byte[30];
         //System.out.println(i.available());
         num=i.read(b);
         //System.out.println(num);
         while(num>0){
             os.write(b);
             num=i.read(b);
         }
         os.close();
         //System.out.println(or.getAbsolutePath());
        String home = System.getProperty("user.home");
        //String desktop=DesktopFilter.findDesktop(home,fileSep);
        String desktop="~$folder.desktop$";//tomado de la ayuda de nircmd

        //nirmcd.exe shortcut "x:\el_nombre_de_programa" "path_donde_se_copiara_el_acceso_directo" "Nombre_nuevo_de_acceso_directo"
        //Se crea la orden con el .exe la orden y la direccion del programa
        String orden="\""+tmp.getAbsolutePath()+"\" shortcut \""+getLugarDondeApunta().getAbsolutePath()+"\"";
        //se adiciona el lugar del acceso y el nombre del mismo
        orden+=" \""+desktop+"\" \""+getNombreDelAcceso()+"\"";
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



  
//    public void copiar(){
//        try {
//            FileInputStream fis = new FileInputStream();
//            FileOutputStream fos = new FileOutputStream(nombre_archivo_destino);
//            FileChannel canalFuente = fis.getChannel();
//            FileChannel canalDestino = fos.getChannel();
//            canalFuente.transferTo(0, canalFuente.size(), canalDestino);
//            fis.close();
//            fos.close();
//        } catch (IOException ex) {
//            Logger.getLogger(CrearAccesoDirectoWindows.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
    public void undo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
   }
}
