/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShortcutPanel.java
 *
 * Created on 7/06/2009, 12:32:07 AM
 */

package gui;

/**
 *
 * @author Sergio
 */
public class ShortcutPanel extends javax.swing.JPanel {

    /** Creates new form ShortcutPanel */
    public ShortcutPanel() {
        initComponents();
    }

    /** Establece un valor booleano que determina si se debe mostrar la casilla
     *  de acceso directo en el escritorio.
     *
     *  @param visible El valor booleano
     */

    public void setDesktopShortcutVisible(boolean visible) { desktopShortcut.setVisible(visible); }

    /** Establece un valor booleano que determina si se debe mostrar la casilla
     *  de acceso directo en el menú de programas.
     *
     *  @param visible El valor booleano.
     */

    public void setProgramsShortcutVisible(boolean visible) { programsShortcut.setVisible(visible); }

    /** Devuelve un valor booleano que determina si el usuario ha decidido que
     *  quiere crear un acceso directo en el escritoio.
     *
     *  @return Un valor booleano.
     */

    public boolean getCreateDesktopShortcut() { return desktopShortcut.isSelected(); }

    /** Devuelve un valor booleano que determina si el usuario ha decidido que
     *  quiere crear un acceso directo en el menú de programas.
     *
     *  @return Un valor booleano
     */

    public boolean getCreateProgramsShortcut() { return programsShortcut.isSelected(); }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shortcutTip = new javax.swing.JLabel();
        desktopShortcut = new javax.swing.JCheckBox();
        programsShortcut = new javax.swing.JCheckBox();

        shortcutTip.setText("¿Desea crear accesos directos para la apliación?");

        desktopShortcut.setText("Crear acceso directo en el escritorio");

        programsShortcut.setText("Crear acceso directo en el menú de programas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shortcutTip)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(programsShortcut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desktopShortcut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shortcutTip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desktopShortcut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programsShortcut)
                .addContainerGap(222, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox desktopShortcut;
    private javax.swing.JCheckBox programsShortcut;
    private javax.swing.JLabel shortcutTip;
    // End of variables declaration//GEN-END:variables

}
