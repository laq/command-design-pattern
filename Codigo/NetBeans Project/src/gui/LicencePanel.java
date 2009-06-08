/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LicencePanel.java
 *
 * Created on 7/06/2009, 12:18:31 AM
 */

package gui;

/**
 *
 * @author Sergio
 */
public class LicencePanel extends javax.swing.JPanel {

    /** Creates new form LicencePanel */
    public LicencePanel() {
        initComponents();
    }

    /** Establece el texto de licencia que debe ser mostrado en el recuadro.
     *
     *  @param licence El texto de la licencia.
     */
    
    public void setLicence(String licence)
    {
        licenceText.setText(licence);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        licenceTip = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        licenceText = new javax.swing.JTextArea();

        licenceTip.setText("Por favor lea con atención el siguiente contrato de licencia");

        licenceText.setColumns(20);
        licenceText.setEditable(false);
        licenceText.setRows(5);
        jScrollPane1.setViewportView(licenceText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(licenceTip))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(licenceTip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea licenceText;
    private javax.swing.JLabel licenceTip;
    // End of variables declaration//GEN-END:variables

}
