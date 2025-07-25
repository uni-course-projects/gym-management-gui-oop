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
public class forgotPasswordPage extends javax.swing.JFrame {

    /**
     * Creates new form frame1
     */

    public forgotPasswordPage() {
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
        usernameForgot = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cardNumberForgot = new javax.swing.JTextField();
        monthCombo = new javax.swing.JComboBox<>();
        yearCombo = new javax.swing.JComboBox<>();
        CVC = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel1.setText("FORGOT PASSWORD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(227, 180, 440, 42);

        jButton3.setBackground(new java.awt.Color(255, 153, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("FIND PASSWORD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(320, 400, 270, 36);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Card Number");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(220, 320, 90, 30);

        usernameForgot.setBackground(new java.awt.Color(204, 204, 204));
        usernameForgot.setToolTipText("");
        usernameForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameForgotActionPerformed(evt);
            }
        });
        usernameForgot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameForgotKeyPressed(evt);
            }
        });
        getContentPane().add(usernameForgot);
        usernameForgot.setBounds(320, 280, 270, 26);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 280, 70, 30);

        cardNumberForgot.setBackground(new java.awt.Color(204, 204, 204));
        cardNumberForgot.setToolTipText("");
        cardNumberForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberForgotActionPerformed(evt);
            }
        });
        cardNumberForgot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cardNumberForgotKeyPressed(evt);
            }
        });
        getContentPane().add(cardNumberForgot);
        cardNumberForgot.setBounds(320, 320, 270, 26);

        monthCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "April", "May", "June", "July", "Sep", "Oct", "Nov", "Dec" }));
        getContentPane().add(monthCombo);
        monthCombo.setBounds(320, 360, 76, 26);

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060" }));
        getContentPane().add(yearCombo);
        yearCombo.setBounds(400, 360, 76, 26);

        CVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVCActionPerformed(evt);
            }
        });
        getContentPane().add(CVC);
        CVC.setBounds(520, 360, 68, 26);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CVC");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 366, 30, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Expiration Date");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(217, 356, 90, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/ayangku_3.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String username = usernameForgot.getText();
        String card_info = cardNumberForgot.getText();
        String expirationdate = monthCombo.getSelectedItem().toString() +  yearCombo.getSelectedItem().toString();
         char[] cvc = CVC.getPassword();
         
         
         if (card_info.isEmpty() || cvc.length == 0) {
            
            JOptionPane.showMessageDialog(null, "You have failed to fill the required information", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
         
         else 
         {
        String forgetPass  = card_info + expirationdate + String.copyValueOf(cvc);
        AccountSystem forget = new AccountSystem();
        forget.findPassword(username, forgetPass);
         }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void usernameForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameForgotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameForgotActionPerformed

    private void usernameForgotKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameForgotKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameForgotKeyPressed

    private void cardNumberForgotKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardNumberForgotKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {

            cardNumberForgot.setEditable(false);
            JOptionPane.showMessageDialog(null, "Only number inputs are required!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            cardNumberForgot.setEditable(true);

        }
    }//GEN-LAST:event_cardNumberForgotKeyPressed

    private void cardNumberForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberForgotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNumberForgotActionPerformed

    private void CVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CVCActionPerformed

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
    private javax.swing.JPasswordField CVC;
    private javax.swing.JTextField cardNumberForgot;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel mainLogo;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JTextField usernameForgot;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}
