/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.helpers;

import java.io.File;
import java.io.FilenameFilter;

/** Una clase FilenameFilter para filtrar los directorios padre y actual de las
 *  listas devueltas por el método list de la clase File.
 *
 *  @author Sergio
 */
public class NoParentOrSelfFileFilter implements FilenameFilter
{
    /** Verificar si el archivo especifcado debe ser incluido en la lista
     * 
     *  @param dir El directorio donde está el archivo
     *  @param name El nombre del archivo.
     *  @return Verdadero si debe ser incluido, falso si no.
     */
    
    public boolean accept(File dir, String name)
    {
        if((name.equals(".") || name.equals("..")))
            return false;

        return true;
    }
}
