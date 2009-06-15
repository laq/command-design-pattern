package core;

import java.util.LinkedList;
import java.util.List;

/** Esta clase modela la información de instalación.
 *
 *  @author Sergio
 */

public class SetupData
{
    /** El nombre de la apliación */
    private String applicationName;

    /** El texto del contrato de licencia de usuario final */
    private String licence;

    /** El nombre de la carpeta de destino */
    private String destinationFolder;

    /** Si se debe dar al usuario la opción de crear un acceso directo en el escritorio */
    private boolean desktopShortcut;

    /** El archivo de destino del acceso directo del escritorio */
    private String desktopShortcutDestination;

    /** Si se debe dar al usuario la opción de crear un acceso directo en el menú de programas */
    private boolean programsShortcut;

    /** El archivo de destino del acceso directo del menú de programas */
    private String programsShortcutDestination;
    
    /** La lista de archivos para copiar */
    List<String> filesToCopy;

    /** Crea una estructura SetupData e inicializa el atributo filesToCopy a una
     *  lista vacía.
     */
    
    public SetupData()
    {
        filesToCopy = new LinkedList();
    }

    /** Devuelve el nombre de la apliación
     *  @return El nombre de la apliación.
     */

    public String getApplicationName() { return applicationName; }

    /** Establece el nombre de la apliación
     *  @param applicationName El nombre de la apliación
     */

    public void setApplicationName(String applicationName)
    {
        this.applicationName = applicationName;
    }

    /** Devuelve el texto del contrato de licencia.
     *  @return El texto del contrado de licencia
     */

    public String getLicence() { return licence; }

    /** Establece el texto del contrato de licencia.
     *  @param licence El texto del contrato de licencia.
     */

    public void setLicence(String licence)
    {
        this.licence = licence;
    }

    /** El nombre de la carpeta de destino.
     *  @return El nombre de la carpeta de destino.
     */

    public String getDestinationFolder() { return destinationFolder; }

    /** Establece el nombre de la carpeta de destino.
     *  @param destinationFolder El nombre de la carpeta de destino.
     */

    public void setDestinationFolder(String destinationFolder)
    {
        this.destinationFolder = destinationFolder;
    }

    /** Devuelve un boleano que indica si se debe ofrecer al usuario la opción
     *  de crear un acceso directo en el escritorio.
     * 
     *  @return Un valo boleano.
     */
    
    public boolean getDesktopShortcut() { return desktopShortcut; }

    /** Establece un valor boleano que determina si se debe ofrecer o no al
     *  usuario la posilbidad de crear un acceso directo para la apliación en
     *  el escritorio.
     *
     *  @param shortcut El valor boleano.
     */

    public void setDesktopShortcut(boolean shortcut) { this.desktopShortcut = shortcut; }

    /** Devuelve una referencia a la lista de archivos que deben ser copiads.
     * 
     *  @return Una referencia a la lista de archivos por copiar.
     */

    public List<String> getFilesToCopy() { return filesToCopy; }

    /** Devuelve un booleano que indica si se debe ofrecer al usuario la opción
     *  de crear un acceso directo en el menú de programas.
     *
     *  @return Un valor booleano.
     */

    public boolean getProgramsShortcut() { return programsShortcut; }

    /** Establece un valor boleano que determina si se debe ofrecer o no al
     *  usuario la posiblidad de crear un acceso directo para la apliación en
     *  el menú de programas.
     *
     *  @param programsShortcut El valor booleano.
     */
    
    public void setProgramsShortcut(boolean programsShortcut) { this.programsShortcut = programsShortcut; }

    /** Devuelve un valor booleano que determina si se le debe ofrecer al usuario
     *  la opción de crear un acceso directo al programa que está siendo instalado
     *  sea en el escritorio o en el menú de programas
     *
     *  @return El valor booleano
     */
    
    public boolean getShortcut() { return desktopShortcut || programsShortcut; }

    /** El archivo al cual debe apuntar el acceso directo del escritorio.
     *
     *  @return El nombre del archivo.
     */

    public String getDesktopShortcutDestination() { return desktopShortcutDestination; }

    /** Establece el nombre del archivo al cual debe apuntar el acceso directo del
     *  escritorio.
     *
     *  @param desktopShortcutDestination El nombre del archivo.
     */
    
    public void setDesktopShortcutDestination(String desktopShortcutDestination) {
        this.desktopShortcutDestination = desktopShortcutDestination;
    }

    /** El archivo al cual debe apuntar el acceso directo del menú de programas.
     *
     * @return El nombre del archivo
     */

    public String getProgramsShortcutDestination() { return programsShortcutDestination; }

    /** Establece el nombre del archivo al cual debe apuntar el acceso directo
     *  del grupo de programas.
     *
     *  @param programsShortcutDestination El nombre del archivo
     */
    
    public void setProgramsShortcutDestination(String programsShortcutDestination) {
        this.programsShortcutDestination = programsShortcutDestination;
    }
}
