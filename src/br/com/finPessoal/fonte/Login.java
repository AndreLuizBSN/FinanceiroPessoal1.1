/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.finPessoal.fonte;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        
        initComponents();
        
        //colocar a janela no meio da tela
        this.setLocationRelativeTo(null);
        
        GetConfig gc = new GetConfig();
        this.setIconImage(gc.getIco());
        
        //visual Windows
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        pfPass = new javax.swing.JPasswordField();
        btLimpar = new javax.swing.JButton();
        btLogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login do Sistema");
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(0, 153, 102));
        setMaximumSize(new java.awt.Dimension(290, 170));
        setMinimumSize(new java.awt.Dimension(290, 170));
        setPreferredSize(new java.awt.Dimension(290, 170));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Financeiro Pessoal");

        jLabel2.setText("Login");

        jLabel3.setText("Senha");

        pfPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPassActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btLogar.setText("Logar");
        btLogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btLimpar)
                        .addGap(107, 107, 107)
                        .addComponent(btLogar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLimpar)
                    .addComponent(btLogar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pfPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfPassActionPerformed

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        
        ConBanco cb = new ConBanco();
        cb.IniciarBd();
        ConexaoClass cc = cb.IniciarBd();
        if(cc.erro != 0){
            JOptionPane.showMessageDialog(this, cc.erroStr);
        }else{
            String login = tfLogin.getText().trim();
            String senha = String.valueOf(pfPass.getPassword()).trim();
            
            LoginValida lv = new LoginValida(cc.con, cc.stm, login, senha);
            if(lv.idUsuario == 0){
                JOptionPane.showMessageDialog(this, lv.erroValida);
            }else{
                new FormPrincipal(String.valueOf(lv.idUsuario)).setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btLogarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        tfLogin.setText("");
        pfPass.setText("");
        tfLogin.requestFocus();
    }//GEN-LAST:event_btLimparActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pfPass;
    private javax.swing.JTextField tfLogin;
    // End of variables declaration//GEN-END:variables
}
