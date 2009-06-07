package commands;

/** La interfaz que deben implementar todos los comandos del proyecto.
 *
 *  @author Sergio
 */

public interface Command
{
    /**
     * El método que se llama para que el comando sea ejecutado
     */
    public void execute();

    /**
     * El método que se llama para que el comando sea deshecho
     */
    public void undo();
}
