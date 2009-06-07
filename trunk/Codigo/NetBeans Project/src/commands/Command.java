package commands;

/** La interfaz que deben implementar todos los comandos del proyecto.
 *
 *  @author Sergio
 */

public interface Command
{
    /** El método que se llama para que el comando sea ejecutado
     *
     *  @return Un valor booleano. Verdadero si la ejecución fue exitosa,
     *  falso si falló.
     */

    public boolean execute();

    /** El método que se llama para que el comando sea deshecho
     *
     *  @return Un valor booleano. Verdadero si la ejecución fue exitosa,
     *  falso si falló.
     */

    public boolean undo();

    /** Devuelve la última excepción ocurrida durante la ejecución del comando.
     *  Si no se produjo ninguna excepción devuelve null.
     *
     *  @return La última excepción ocurrida.
     */

    public Exception getLastException();
}
