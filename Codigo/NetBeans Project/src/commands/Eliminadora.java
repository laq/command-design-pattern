/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author david
 */
public class Eliminadora {

    public static void deleteFile(File file) throws FileNotFoundException{
        if( file.exists() ) {
            file.delete();
        } else {
            throw new FileNotFoundException();
        }
    }

}
