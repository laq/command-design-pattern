/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.helpers;

import commands.Command;

import gui.Wizard;
import gui.CopyingPanel;

import java.util.Vector;

/** El Hilo que se encarga de realizar la instalación.
 *
 *  @author Sergio
 */

public class SetupThread extends Thread
{

    /** La secuencia de comandos que se debe ejecutar */
    Vector<Command> commands;

    /** El panel al cual reportar el progreso de la copia */
    CopyingPanel copying;

    /** El Wizard al cual reportar los errores y la finalización del Thread */
    Wizard wizard;

    /** Un booleano que determina si el asistente ha sido cancelado */
    boolean canceled;

    /** Constructora para la clase, recibe la secuencia de comandos que debe
     *  ejecutar, el CopyingPanel al que debe reportarle el progreso y la
     *  clase Wizard a la que debe reportarle la finalización o los errores.
     * 
     *  @param commands La secuencia de comandos a ser ejecutada.
     *  @param copying El CopyingPanel al que reportarle el progreso.
     *  @param wizard El Wizard al que reportarle los errores y la finalización
     *      de la ejecución del Thread.
     */

    public SetupThread(Vector<Command> commands, CopyingPanel copying, Wizard wizard)
    {
        this.commands = commands;
        this.copying = copying;
        this.wizard = wizard;
    }

    /** Este procedimiento se llama cuando el Thread se pone en ejecución. */

    @Override
    public void run()
    {
        // Ejecuta la secuencia de comandos.
        doCommands();
        wizard.threadDone();
    }

    /** Este procedimiento se llama cuando el usuario presiona el botón de cancelar
     *  durante el proceso de instalación.
     */

    public void cancel() { canceled = true; }

    /** Ejecuta los comandos de la secuencia */

    private void doCommands()
    {
        int i;
        int n;
        Command command;
        
        n = commands.size();
        copying.setTotalTasks(n);
        copying.setCurrentProgress(0);
        i = 0;
        
        while(i < n)
        {
            if(canceled)
                break;

            command = commands.get(i);
            copying.setStatus(command.toString());
            try
            {
                Thread.sleep(2000);
                command.execute();
            }
            catch (Exception ex)
            {
                wizard.reportError(ex);
                break;
            }
            i++;
            
            copying.setCurrentProgress(i);
        }

        if(i < n)
        {
            i = i - 1;
            while(i >= 0)
            {
                command = commands.get(i);
                copying.setStatus("Deshaciendo: " + command.toString());
                try
                {
                    Thread.sleep(2000);
                    command.undo();
                }
                catch(Exception ex)
                {
                    wizard.reportError(ex);
                }

                i--;
                copying.setCurrentProgress(i);
            }
        }
    }

}
