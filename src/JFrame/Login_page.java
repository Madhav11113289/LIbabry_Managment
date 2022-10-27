/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Color;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Madhav
 */
public class Login_page extends javax.swing.JFrame {

    /**
     * Creates new form Signup_page
     */
    public Login_page() {
        initComponents();
        
    }
    //method  to insert vales into users table
   
    //validation
   
    public boolean validLogin(){
        String name= txt_username.getText();
        char []c = txt_password.getPassword();
        String pwd = new String(c);
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            return false;
        }
        
        if(pwd.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Password");
        return false;
        }
        return true;
    }
    // verify creditional
    public void login(){
        String name= txt_username.getText();
        char []c = txt_password.getPassword();
        String pwd = new String(c);
        
        try {
             Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT * from user WHERE name =? and password = ?");
             
             pst.setString(1, name);
             pst.setString(2, pwd);
             
             ResultSet rs= pst.executeQuery();
             
             if(rs.next()){
             JOptionPane.showMessageDialog(this, "Login Successful");
             HomePage home = new HomePage();
             home.setVisible(true);
             this.dispose();
             }
             else{
             JOptionPane.showMessageDialog(this, "Incorrect Username and Password");
                 
             }
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        txt_password = new rojerusan.RSPasswordTextPlaceHolder();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(224, 231, 255));
        jLabel1.setText("LIBRARY MANAGER");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 360, 70));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Library");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 160, 80));

        jLabel3.setFont(new java.awt.Font("Sitka Small", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome To");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 340, 70));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 155, 155));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.PNG"))); // NOI18N
        jLabel4.setText("Public");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/white login.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 990, 820));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.PNG"))); // NOI18N
        jLabel8.setText("Public Library");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 830));

        jPanel2.setBackground(new java.awt.Color(122, 129, 219));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Login To Your Account");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 350, 50));

        jLabel9.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 130, 50));

        jLabel10.setBackground(new java.awt.Color(122, 129, 219));
        jLabel10.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(122, 129, 219));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user .png"))); // NOI18N
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 50, 60));

        txt_username.setBackground(new java.awt.Color(122, 129, 219));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setForeground(new java.awt.Color(51, 51, 51));
        txt_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_username.setPlaceholder("Enter Username");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 330, -1));

        jLabel11.setBackground(new java.awt.Color(122, 129, 219));
        jLabel11.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(122, 129, 219));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lock.PNG"))); // NOI18N
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 50, 60));

        jLabel12.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Password");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 50));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 198, 150));
        rSMaterialButtonCircle3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(255, 51, 51)));
        rSMaterialButtonCircle3.setText("LOGIN");
        rSMaterialButtonCircle3.setToolTipText("Login");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseExited(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 280, 70));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 122, 122));
        rSMaterialButtonCircle4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 153, 153)));
        rSMaterialButtonCircle4.setText("SIGNUP");
        rSMaterialButtonCircle4.setToolTipText("Signup");
        rSMaterialButtonCircle4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle4MouseExited(evt);
            }
        });
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 650, 280, 70));

        txt_password.setBackground(new java.awt.Color(122, 129, 219));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setForeground(new java.awt.Color(51, 51, 51));
        txt_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_password.setPhColor(new java.awt.Color(0, 0, 0));
        txt_password.setPlaceholder("Enter Password");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 330, -1));

        jLabel17.setFont(new java.awt.Font("Sitka Small", 0, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 153));
        jLabel17.setText("_");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 50, 30));

        jLabel18.setFont(new java.awt.Font("Sitka Small", 0, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Login Page");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 140, 340, 70));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logintop.PNG"))); // NOI18N
        jLabel19.setText("jLabel19");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 220, 150));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close.PNG"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 830));

        setSize(new java.awt.Dimension(1519, 827));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
      
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        
    }//GEN-LAST:event_txt_usernameFocusLost

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(validLogin()){
            login();
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void rSMaterialButtonCircle3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseEntered
        rSMaterialButtonCircle3.setBackground(new Color(0,124,94));
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseEntered

    private void rSMaterialButtonCircle3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseExited
       rSMaterialButtonCircle3.setBackground(new Color(0,198,150));
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseExited

    private void rSMaterialButtonCircle4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4MouseEntered
        rSMaterialButtonCircle4.setBackground(new Color(253,36,36));
    }//GEN-LAST:event_rSMaterialButtonCircle4MouseEntered

    private void rSMaterialButtonCircle4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4MouseExited
        rSMaterialButtonCircle4.setBackground(new Color(255,122,122));
    }//GEN-LAST:event_rSMaterialButtonCircle4MouseExited

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
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSPasswordTextPlaceHolder txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
