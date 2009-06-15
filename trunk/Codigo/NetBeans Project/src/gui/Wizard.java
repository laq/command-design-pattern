/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WizardWelcome.java
 *
 * Created on 6/06/2009, 09:41:35 PM
 */

package gui;

import commands.Command;
import commands.CopiarArchivo;
import commands.CrearCarpeta;
import commands.CrearAccesoDirecto;
import commands.CrearAccesoDirectoLinux;
import commands.CrearAccesoDirectoWindows;

import core.SetupData;

import gui.helpers.NoParentOrSelfFileFilter;
import gui.helpers.SetupThread;

import java.io.File;

import java.util.Vector;
import java.util.Iterator;

import javax.swing.JOptionPane;

/** Ventana principal del asistente de instalación.
 *
 *  @author Sergio
 */
public class Wizard extends javax.swing.JFrame {

    private enum WizardState{
        Welcome, Licence, Location, Shortcut, Copying, Finished;
    }

    private enum HostSystem{
        Windows, Linux, Other;
    }

    private WizardState currentState;
    private HostSystem hostSystem;

    private WelcomePanel welcome;
    private LicencePanel licence;
    private LocationPanel location;
    private ShortcutPanel shortcut;
    private CopyingPanel copying;
    private FinishedPanel finished;

    private SetupData setupData;
    private SetupThread setupThread;
    
    private boolean errorOcurred = false;
    private boolean canceled = false;
    
    /** Creates new form WizardWelcome */
    public Wizard() {
        
        String osName;

        initComponents();

        this.setLocationRelativeTo(null);
        
        welcome = new WelcomePanel();
        licence = new LicencePanel();
        location = new LocationPanel();
        shortcut = new ShortcutPanel();
        copying = new CopyingPanel();
        finished = new FinishedPanel();

        backPanel.add(welcome);
        back.setVisible((false));

        currentState = WizardState.Welcome;

        osName = System.getProperty("os.name");
        osName = osName.toLowerCase();

        if(osName.startsWith("windows"))
            hostSystem = HostSystem.Windows;

        else if(osName.startsWith("linux"))
            hostSystem = HostSystem.Linux;

        else hostSystem = HostSystem.Other;
    }

    public void setSetupData(SetupData setupData)
    {
        String homeFolder;
        String destinationFolder;
        String osPathSeparator;
                
        this.setupData = setupData;
        this.setTitle("Programa de instalación de " + setupData.getApplicationName());
        this.topTitle.setText("Programa de instalación de " + setupData.getApplicationName());
        this.topTip.setText("Bienvenido al programa de instalación de " + setupData.getApplicationName() +
            ". Este programa le guiará durante el proceso de instalación.");
        this.welcome.setApplicationName(setupData.getApplicationName());

        if(setupData.getLicence() != null)
        {
            this.licence.setLicence(setupData.getLicence());
        }

        if(hostSystem == HostSystem.Windows)
            destinationFolder = "C:\\Archivos de Programa\\" + setupData.getDestinationFolder();

        else if(hostSystem == HostSystem.Linux)
            destinationFolder = "/usr/local/share/" + setupData.getDestinationFolder();

        else
        {
            homeFolder = System.getProperty("user.home");
            osPathSeparator = System.getProperty("file.separator");
            destinationFolder = homeFolder + osPathSeparator + setupData.getDestinationFolder();
        }

        this.location.setDestinationFolder(destinationFolder);

        if(setupData.getShortcut())
        {
            this.shortcut.setDesktopShortcutVisible(setupData.getDesktopShortcut());
            this.shortcut.setProgramsShortcutVisible(setupData.getProgramsShortcut());
        }
    }

    /** Prepara la ejecución de la instalación.
     *
     *  @return Un Vector con la secuencia de comandos para la instlaación
     */

    private Vector prepareInstallation()
    {
        Iterator<String> filesToCopyIterator;
        Vector<Command> commands;
        File folderToCreate;
        String fileToCopy;
        File destination;

        CrearAccesoDirecto accesoDirecto;
        CopiarArchivo copiarArchivo;
        CrearCarpeta crearCarpeta;

        String shortcutName;
        boolean desktopShortcut;
        boolean programsShortcut;
        
        File shortcutDestination;
        File sourceFile;
        File destFile;
        
        copying.setStatus("Preparando secuencia de comandos para la instalación...");
        destination = new File(location.getDestinationFolder());
        commands = new Vector<Command>();

        if(!destination.exists())
        {
            folderToCreate = destination;
            while(!folderToCreate.exists())
            {
                crearCarpeta = new CrearCarpeta(folderToCreate);
                commands.add(0, crearCarpeta);

                folderToCreate = folderToCreate.getParentFile();
            }
        }

        filesToCopyIterator = setupData.getFilesToCopy().iterator();
        while(filesToCopyIterator.hasNext())
        {
            fileToCopy = filesToCopyIterator.next();
            sourceFile = new File(fileToCopy);
            
            destFile = new File(destination, fileToCopy);
            copiarArchivo = new CopiarArchivo(sourceFile, destFile);
            commands.add(copiarArchivo);
        }

        if(setupData.getShortcut())
        {
            shortcutDestination = new File(destination, setupData.getDesktopShortcutDestination());
            shortcutName = setupData.getApplicationName();
            desktopShortcut = shortcut.getCreateDesktopShortcut();
            programsShortcut = shortcut.getCreateProgramsShortcut();

            if(desktopShortcut || programsShortcut)
            {
                if(hostSystem == HostSystem.Windows)
                {
                    accesoDirecto = new CrearAccesoDirectoWindows(setupData.getApplicationName(), shortcutDestination, desktopShortcut, programsShortcut);
                    commands.add(accesoDirecto);
                }
                else if(hostSystem == HostSystem.Linux)
                {
                    accesoDirecto = new CrearAccesoDirectoLinux(setupData.getApplicationName(), shortcutDestination, desktopShortcut, programsShortcut);
                    commands.add(accesoDirecto);
                }
            }
        }

        return commands;
    }

    /** Inicia el proceso de instalación. */

    private void startSetup()
    {
        Vector<Command> commands;
        
        commands = prepareInstallation();
        setupThread = new SetupThread(commands, copying, this);
        setupThread.start();
    }

    /** Este procedimiento lo utiliza el Thread de ejecución de la instalación
     *  para reportar los errores.
     *
     *  @param ex La excepción que fue lanzada.
     */

    public void reportError(Exception ex)
    {
        JOptionPane.showMessageDialog(this, "Se ha producido un error durante la instalación\n\t" + ex.getMessage(), "Error en la instalación", JOptionPane.ERROR_MESSAGE);
        errorOcurred = true;
    }

    /** Este procedimiento es llamado por el Thread cuando finaliza */
    
    public void threadDone()
    {
        // El Thread ha finalizado, eso es equivalente a que el usuario hubiera
        // hecho clic en el botón finalizar durante el proceso de copia.
        nextActionPerformed(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopPanel = new javax.swing.JPanel();
        topTitle = new javax.swing.JLabel();
        topTip = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        backPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa de instalación de ");

        TopPanel.setBackground(java.awt.SystemColor.window);

        topTitle.setFont(new java.awt.Font("Tahoma", 1, 11));
        topTitle.setText("Programa de instalación de ");

        topTip.setText("Bienvenido al programa de instalación de , este programa le guiará durante el proceso de instalación.");

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topTip, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addComponent(topTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topTip)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        back.setText("Atrás");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        next.setText("Siguiente");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        backPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(back)
                    .addComponent(next))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed

        File destination;
        int selectedOption;
        String[] directoryContents;
        NoParentOrSelfFileFilter fileFilter;
        
        switch(currentState)
        {
            case Welcome:
                backPanel.removeAll();

                if(setupData.getLicence() != null)
                {
                    backPanel.add(licence);
                    next.setText("Acepto");
                    currentState = WizardState.Licence;
                }
                else
                {
                    backPanel.add(location);
                    currentState = WizardState.Location;
                }
                backPanel.updateUI();
                back.setVisible(true);
                break;
                
            case Licence:
                backPanel.removeAll();
                backPanel.add(location);
                next.setText("Siguiente");
                backPanel.updateUI();

                currentState = WizardState.Location;
                break;

            case Location:

               if(location.getDestinationFolder().trim().length() == 0)
               {
                   JOptionPane.showMessageDialog(this, "Por favor seleccione una ubicación para la instalación", "¡Hay un problema!", JOptionPane.WARNING_MESSAGE);
                   return;
               }

               destination = new File(location.getDestinationFolder());
               if(destination.exists() == false)
               {
                   selectedOption = JOptionPane.showConfirmDialog(this, "El directorio de destino no existe. ¿Desea crearlo?", "Directorio de Destino Inexistente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                   if(selectedOption == JOptionPane.NO_OPTION)
                       return;
               }
               else
               {
                   if(destination.isDirectory())
                   {
                       fileFilter = new NoParentOrSelfFileFilter();
                       directoryContents = destination.list(fileFilter);
                       if(directoryContents.length > 0)
                       {
                           selectedOption = JOptionPane.showConfirmDialog(this, "El directorio de destino no está vacio. ¿Desea crearlo?", "Directorio de Destino no Vacio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                           if(selectedOption == JOptionPane.NO_OPTION)
                               return;
                       }
                   }
               }

                backPanel.removeAll();

                if(setupData.getShortcut())
                {
                    backPanel.add(shortcut);
                    currentState = WizardState.Shortcut;
                    backPanel.updateUI();
                }
                else
                {
                    backPanel.add(copying);
                    currentState = WizardState.Copying;
                    back.setVisible(false);
                    next.setVisible(false);

                    backPanel.updateUI();
                    startSetup();
                }
                break;

            case Shortcut:
                backPanel.removeAll();
                backPanel.add(copying);
                backPanel.updateUI();

                currentState = WizardState.Copying;
                back.setVisible(false);
                next.setVisible(false);
                backPanel.updateUI();
                startSetup();
                break;

            case Copying:
                backPanel.removeAll();
                backPanel.add(finished);
                backPanel.updateUI();

                if(errorOcurred)
                {
                    finished.setText("No se ha podido completar la instalación " +
                        "debido a un Error. Por favor contacte al proveedor del Software.");
                }

                if(canceled)
                {
                    finished.setText("Ha cancelado la instalación. El programa no ha sido instalado en su computadora.");
                }

                back.setVisible(false);
                next.setVisible(true);
                next.setText("Finalizar");
                cancel.setVisible(false);
                currentState = WizardState.Finished;
                break;

            case Finished:
                this.dispose();
        }

    }//GEN-LAST:event_nextActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        switch(currentState)
        {
            case Licence:
                backPanel.removeAll();
                backPanel.add(welcome);
                next.setText("Siguiente");
                backPanel.updateUI();

                back.setVisible(false);
                currentState = WizardState.Welcome;
                break;

            case Location:
                backPanel.removeAll();

                if(setupData.getLicence() != null)
                {
                    backPanel.add(licence);
                    next.setText("Acepto");
                    currentState = WizardState.Licence;
                }
                else
                {
                    backPanel.add(welcome);
                    currentState = WizardState.Welcome;
                }
                
                backPanel.updateUI();
                break;

            case Shortcut:
                backPanel.removeAll();
                backPanel.add(location);
                backPanel.updateUI();

                currentState = WizardState.Location;
                break;
        }

    }//GEN-LAST:event_backActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        int option;
        option = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea cancelar la instalación?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(option == JOptionPane.YES_OPTION)
        {
            canceled = true;
            if(setupThread != null)
                setupThread.cancel();

            else
            {
                currentState = WizardState.Copying;
                nextActionPerformed(null);
            }
        }
    }//GEN-LAST:event_cancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TopPanel;
    private javax.swing.JButton back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JButton cancel;
    private javax.swing.JButton next;
    private javax.swing.JLabel topTip;
    private javax.swing.JLabel topTitle;
    // End of variables declaration//GEN-END:variables

}
