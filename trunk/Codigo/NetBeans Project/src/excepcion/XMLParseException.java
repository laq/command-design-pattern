package excepcion;

/** Una excepción para ser lanzada cuando ocurre un error de parseo al momento
 *  de analizar el archivo XML de la instalación.
 *
 *  Nota: Esta excepción se lanza cuando hay un error de parseo lógico, por
 *  ejemplo una etiqueta o un atriuto faltante. Los errores de parseo como tal
 *  se representan por una SAXException.
 *
 *  @author Sergio
 */

public class XMLParseException extends Exception
{
    private static final String defaultMessage = "Ocurrió un error de parseo " +
            "al momento de leer el archivo de datos de la instalación";
    
    /** Crea una XMLParseException con el mensaje predeterminado. */

    public XMLParseException() { super(defaultMessage); }

    /** Crea una XMLParseException con el mensaje especificado.}
     * 
     *  @param message El mensaje para la excepción.
     */
    
    public XMLParseException(String message) { super(message); }

    /** Crea una XMLParseException con el mensaje predeterminado y la causa
     *  especificada.
     *
     *  @param cause La causa de la Excepcion.
     */

    public XMLParseException(Throwable cause) { super(defaultMessage,cause); }

    /** Crea una XMLParseException con el mensaje y la causa especificados.
     *
     *  @param message El mensaje de la excepción.
     *  @param cause La causa de la excepción.
     */
    
    public XMLParseException(String message, Throwable cause) { super(message,cause); }
}
