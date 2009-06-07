/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

/**
 *
 * @author david
 */
public class CopiarCarpeta implements Command {

    private String nombre_carpeta_origen;
    private String nombre_carpeta_destino;
    private String direccion_origen;
    private String direccion_destino;

    /**
     *
     * @param origen
     * @param origen_dir
     * @param destino
     * @param destino_dir
     */
    public CopiarCarpeta(String origen, String origen_dir, String destino, String destino_dir) {
        nombre_carpeta_origen = origen;
        nombre_carpeta_destino = origen_dir;
        direccion_origen = destino;
        direccion_destino = destino_dir;
    }

    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return el nombre_carpeta_origen
     */
    public String getNombre_carpeta_origen() {
        return nombre_carpeta_origen;
    }

    /**
     * @param nombre_carpeta_origen el nombre_carpeta_origen a inicializar
     */
    public void setNombre_carpeta_origen(String nombre_carpeta_origen) {
        this.nombre_carpeta_origen = nombre_carpeta_origen;
    }

    /**
     * @return el nombre_carpeta_destino
     */
    public String getNombre_carpeta_destino() {
        return nombre_carpeta_destino;
    }

    /**
     * @param nombre_carpeta_destino el nombre_carpeta_destino a inicializar
     */
    public void setNombre_carpeta_destino(String nombre_carpeta_destino) {
        this.nombre_carpeta_destino = nombre_carpeta_destino;
    }

    /**
     * @return la direccion_origen
     */
    public String getDireccion_origen() {
        return direccion_origen;
    }

    /**
     * @param direccion_origen la direccion_origen a inicializar
     */
    public void setDireccion_origen(String direccion_origen) {
        this.direccion_origen = direccion_origen;
    }

    /**
     * @return la direccion_destino
     */
    public String getDireccion_destino() {
        return direccion_destino;
    }

    /**
     * @param direccion_destino la direccion_destino a inicializar
     */
    public void setDireccion_destino(String direccion_destino) {
        this.direccion_destino = direccion_destino;
    }

}
