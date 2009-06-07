/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import gui.Wizard;

/** Clase principal del programa. Punto de entrada a la apliación.
 *
 *  @author Sergio
 */
public class Main {

    /** Método de entrada.
     *
     *  @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args)
    {
        Wizard wiz;
        wiz = new Wizard();
        wiz.setVisible(true);        
    }
}
