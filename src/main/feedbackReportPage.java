/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author ok
 */
public class feedbackReportPage extends javax.swing.JFrame {

    /**
     * Creates new form frame1
     */

    public feedbackReportPage() {
        initComponents();
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        usernameUpdateStatus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        reportUpdateStatus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        mainLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/lovely.png"))); // NOI18N
        getContentPane().add(mainLogo);
        mainLogo.setBounds(300, 60, 270, 110);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHANGE REPORT STATUS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(197, 180, 500, 42);

        jButton3.setBackground(new java.awt.Color(255, 153, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("UPDATE REPORT STATUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(320, 400, 270, 36);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Report Status");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(220, 320, 90, 30);

        usernameUpdateStatus.setBackground(new java.awt.Color(204, 204, 204));
        usernameUpdateStatus.setToolTipText("");
        usernameUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameUpdateStatusActionPerformed(evt);
            }
        });
        usernameUpdateStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameUpdateStatusKeyPressed(evt);
            }
        });
        getContentPane().add(usernameUpdateStatus);
        usernameUpdateStatus.setBounds(320, 280, 270, 26);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 280, 70, 30);

        reportUpdateStatus.setBackground(new java.awt.Color(204, 204, 204));
        reportUpdateStatus.setToolTipText("");
        reportUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportUpdateStatusActionPerformed(evt);
            }
        });
        reportUpdateStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reportUpdateStatusKeyPressed(evt);
            }
        });
        getContentPane().add(reportUpdateStatus);
        reportUpdateStatus.setBounds(320, 320, 270, 26);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/ayangku_3.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FeedbackForm AddReport = new FeedbackForm();
        String report = reportUpdateStatus.getText();
        String name = usernameUpdateStatus.getText();
        
        AddReport.addReportStatus(name, report);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void usernameUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameUpdateStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameUpdateStatusActionPerformed

    private void usernameUpdateStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameUpdateStatusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameUpdateStatusKeyPressed

    private void reportUpdateStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reportUpdateStatusKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_reportUpdateStatusKeyPressed

    private void reportUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportUpdateStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportUpdateStatusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(forgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotPasswordPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel mainLogo;
    private javax.swing.JTextField reportUpdateStatus;
    private javax.swing.JTextField usernameUpdateStatus;
    // End of variables declaration//GEN-END:variables
}
