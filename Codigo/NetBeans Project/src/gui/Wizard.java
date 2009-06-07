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

import javax.swing.JFileChooser;

/**
 *
 * @author Sergio
 */
public class Wizard extends javax.swing.JFrame {

    private enum WizardState{
        Welcome, Licence, Location, Shortcut, Copying, Finished;
    }

    WizardState currentState;

    WelcomePanel welcome;
    LicencePanel licence;
    LocationPanel location;
    ShortcutPanel shortcut;
    CopyingPanel copying;
    FinishedPanel finished;
    
    /** Creates new form WizardWelcome */
    public Wizard() {
        initComponents();

        welcome = new WelcomePanel();
        licence = new LicencePanel();
        location = new LocationPanel();
        shortcut = new ShortcutPanel();
        copying = new CopyingPanel();
        finished = new FinishedPanel();

        backPanel.add(welcome);
        back.setVisible((false));

        currentState = WizardState.Welcome;
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

        switch(currentState)
        {
            case Welcome:
                backPanel.removeAll();
                backPanel.add(licence);
                backPanel.updateUI();
                
                back.setVisible(true);
                currentState = WizardState.Licence;
                break;
                
            case Licence:
                backPanel.removeAll();
                backPanel.add(location);
                backPanel.updateUI();

                currentState = WizardState.Location;
                break;

            case Location:
                backPanel.removeAll();
                backPanel.add(shortcut);
                backPanel.updateUI();

                currentState = WizardState.Shortcut;
                break;

            case Shortcut:
                backPanel.removeAll();
                backPanel.add(copying);
                backPanel.updateUI();

                back.setVisible(false);
                next.setVisible(false);
                currentState = WizardState.Copying;
                break;

            case Copying:
                backPanel.removeAll();
                backPanel.add(finished);
                backPanel.updateUI();
                
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
                backPanel.updateUI();

                back.setVisible(false);
                currentState = WizardState.Welcome;
                break;

            case Location:
                backPanel.removeAll();
                backPanel.add(licence);
                backPanel.updateUI();

                currentState = WizardState.Licence;
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

        this.nextActionPerformed(null);
        
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
