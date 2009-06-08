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
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author LAQ
 */
public class CrearAccesoDirectoWindows extends CrearAccesoDirecto {

    public CrearAccesoDirectoWindows(String nombre, File lugarDelAcceso) {
        setNombreDelAcceso(nombre);
        setLugarDondeApunta(lugarDelAcceso);
    }
    public void verProperties(){
        Properties p=System.getProperties();
        p.list(System.out);
    }

    public void execute() throws Exception {
        //verProperties();
        InputStream i=Thread.currentThread().getContextClassLoader().getResourceAsStream("util/nircmd.exe");
        System.out.println(i);
        URL url = Thread.currentThread().getContextClassLoader().getResource("util/nircmd.exe");
        System.out.println(url);
        String tempdir = System.getProperty("java.io.tmpdir");
         System.out.println(tempdir);
         File tmp=new File(tempdir+"\\tmo.exe");
         System.out.println(tmp);
         OutputStream os=new FileOutputStream(tmp);

         //FileWriter fw=new FileWriter(tmp);
         int num=0;
         byte []b =new byte[30];
         System.out.println(i.available());
         num=i.read(b);
         System.out.println(num);
         while(num>0){
             os.write(b);
             num=i.read(b);
         }
         os.close();
         //System.out.println(or.getAbsolutePath());
        String home = System.getProperty("user.home");
        System.out.println(home + "\\Escritorio\\hola");
        Process p = Runtime.getRuntime().exec(tmp.getAbsolutePath()+" help");
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
