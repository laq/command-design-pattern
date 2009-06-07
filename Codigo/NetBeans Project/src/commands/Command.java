package commands;

/** La interfaz que deben implementar todos los comandos del proyecto.
 *
 *  @author Sergio
 */

public interface Command
{
    /** El método que se llama para que el comando sea ejecutado
     *
     *  @throws Exception Si la ejecución del comando falla.
     */

    public void execute() throws Exception;

    /** El método que se llama para que el comando sea deshecho
     * 
     *  @throws Exception Si al intentar deshacer el comando se produce un error.
     */

    public void undo() throws Exception;
}
