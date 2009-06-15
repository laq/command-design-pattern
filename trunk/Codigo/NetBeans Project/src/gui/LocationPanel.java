/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LocationPanel.java
 *
 * Created on 7/06/2009, 12:23:51 AM
 */

package gui;

import java.io.File;

import javax.swing.JFileChooser;

/**
 *
 * @author Sergio
 */
public class LocationPanel extends javax.swing.JPanel {

    /** Creates new form LocationPanel */
    public LocationPanel() {
        initComponents();
    }

    /** Establece el texto que debe mostrarse en la casilla de carpeta de destino
     * 
     *  @param folder La ruta de la carpeta de destino.
     */

    public void setDestinationFolder(String folder) { this.locationText.setText(folder); }

    /** Devuelve la ruta de acceso seleccionada por el usuario.
     *
     *  @return La ruta de acceso seleccionada.
     */

    public String getDestinationFolder() { return this.locationText.getText(); }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        locationTip = new javax.swing.JLabel();
        locationText = new javax.swing.JTextField();
        locationBrowse = new javax.swing.JButton();

        locationTip.setText("Por favor seleccione la ubicación donde desea instalar el programa");

        locationBrowse.setText("Examinar");
        locationBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(locationTip)
                    .addComponent(locationText, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationBrowse)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(locationTip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationBrowse))
                .addContainerGap(241, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void locationBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationBrowseActionPerformed

        int dialogOption;
        
        JFileChooser chooser;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(locationText.getText()));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dialogOption = chooser.showOpenDialog(this);

        if(dialogOption == JFileChooser.APPROVE_OPTION)
            locationText.setText(chooser.getSelectedFile().getAbsolutePath());
}//GEN-LAST:event_locationBrowseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton locationBrowse;
    private javax.swing.JTextField locationText;
    private javax.swing.JLabel locationTip;
    // End of variables declaration//GEN-END:variables

}
