/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FinishedPanel.java
 *
 * Created on 7/06/2009, 12:26:03 AM
 */

package gui;

/**
 *
 * @author Sergio
 */
public class FinishedPanel extends javax.swing.JPanel {

    /** Creates new form FinishedPanel */
    public FinishedPanel() {
        initComponents();
    }

    /** Establece el texto para ser mostrado en la etiqueta.
     * 
     *  @param text El texto para la etiqueta.
     */

    public void setText(String text)
    {
        this.finishedTip.setText(text);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        finishedTip = new javax.swing.JLabel();

        finishedTip.setText("El programa se ha instalado con éxito. Haga clic en Finalizar para terminar el asistente.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finishedTip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finishedTip)
                .addContainerGap(275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel finishedTip;
    // End of variables declaration//GEN-END:variables

}
