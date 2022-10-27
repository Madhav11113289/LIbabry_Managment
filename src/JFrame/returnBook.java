package JFrame;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import JFrame.HomePage;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Madhav
 */
public class returnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public returnBook() {
        initComponents();
    }
   //to featch issuebook details and displat to panel
    
    public void getIssueBookDetails(){
            int bookID = Integer.parseInt(txt_book_ID.getText());
            int studentID = Integer.parseInt(txt_student_ID.getText());
            
            try {
            
                Connection con = DBConnection.getConnection();
                String sql =" SELECT * FROM issue_book where book_id=? and student_id =? and status =?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, bookID);
                pst.setInt(2, studentID);
                pst.setString(3, "pending");
                
                ResultSet rst= pst.executeQuery();
                if(rst.next()){
                lbl_issueid.setText(rst.getString("id"));
                lbl_bookname.setText(rst.getString("book_name"));
                lbl_studentname.setText(rst.getString("student_name"));
                lbl_issuedate.setText(rst.getString("issue_date"));
                lbl_duedate.setText(rst.getString("due_date"));
                }
                else{
                 lbl_Bookerror.setText("NO RECORD FOUND!");
                lbl_issueid.setText("");
                lbl_bookname.setText("");
                lbl_studentname.setText("");
                lbl_issuedate.setText("");
                lbl_duedate.setText("");
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    //to get student name
    
    public void getstudentID(){
        int StudentID = Integer.parseInt(txt_student_ID.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM student_details WHERE student_id=? ");
            pst.setInt(1, StudentID);
            
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
             lbl_studentname.setText(rst.getString("student_name"));
            }
                
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    
    //Return Book
    public boolean returnBook(){
        boolean isReturn =false;
          int bookID = Integer.parseInt(txt_book_ID.getText());
          int studentID = Integer.parseInt(txt_student_ID.getText());
          try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE issue_book set status =? WHERE student_id=? and book_id =? and status =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "returned");
            pst.setInt(2, studentID);
            pst.setInt(3, bookID);
            pst.setString(4, "pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
            isReturn = true;
            }
            else{
            isReturn = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturn;
    }
    
    
   
    
   
    //updating book count 
    
    public void updateBookCount(){
         int bookId = Integer.parseInt(txt_book_ID.getText());
         try {
            Connection con = DBConnection.getConnection();
            String sql ="update book_details set quantity = quantity+1 WHERE  book_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book count updated");
            }
            else{
              JOptionPane.showMessageDialog(this, "Can't Update Book Count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //check wether book already allocated to student 
    
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued =false;
        int bookId = Integer.parseInt(txt_book_ID.getText());
        int studentId = Integer.parseInt(txt_student_ID.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql="SELECT * FROM issue_book WHERE book_id=? and student_id =? and status =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
            isAlreadyIssued = false;
            }
            else{
            isAlreadyIssued =true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_student_ID = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_book_ID = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        rSMaterialButtonCircle8 = new rojerusan.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbl_issueid = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_duedate = new javax.swing.JLabel();
        lbl_Bookerror = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_issuedate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSMaterialButtonCircle9 = new rojerusan.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close.PNG"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 50, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_student_ID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 51)));
        txt_student_ID.setForeground(new java.awt.Color(51, 51, 51));
        txt_student_ID.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_student_ID.setPlaceholder("Enter Student ID");
        txt_student_ID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_IDFocusLost(evt);
            }
        });
        txt_student_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_student_IDActionPerformed(evt);
            }
        });
        jPanel3.add(txt_student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 340, 240, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 42)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 122, 122));
        jLabel4.setText("Return Books");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 160, 280, 80));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ISSUEBOOK.PNG"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 260, 260));

        jPanel5.setBackground(new java.awt.Color(255, 122, 122));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, 460, 10));

        txt_book_ID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 51)));
        txt_book_ID.setForeground(new java.awt.Color(51, 51, 51));
        txt_book_ID.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_book_ID.setPlaceholder("Enter Book ID");
        txt_book_ID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_book_IDFocusLost(evt);
            }
        });
        txt_book_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_book_IDActionPerformed(evt);
            }
        });
        jPanel3.add(txt_book_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 430, 240, -1));

        jLabel22.setBackground(new java.awt.Color(255, 102, 51));
        jLabel22.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 102, 51));
        jLabel22.setText("Book ID:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 430, 110, 50));

        jLabel24.setBackground(new java.awt.Color(255, 102, 51));
        jLabel24.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 102, 51));
        jLabel24.setText("Student ID:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, 140, 50));

        rSMaterialButtonCircle8.setBackground(new java.awt.Color(255, 61, 61));
        rSMaterialButtonCircle8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 153, 153)));
        rSMaterialButtonCircle8.setText("FIND");
        rSMaterialButtonCircle8.setToolTipText("Issue Book");
        rSMaterialButtonCircle8.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        rSMaterialButtonCircle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle8ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 540, 330, 70));

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student Name:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 190, 50));

        jLabel13.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Issue Date:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 160, 50));

        jLabel15.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Due Date:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 120, 50));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 320, 80));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 360, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Issue ID:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 110, 50));

        lbl_issueid.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_issueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 300, 50));

        lbl_bookname.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 300, 50));

        lbl_studentname.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 300, 50));

        lbl_duedate.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 300, 50));

        lbl_Bookerror.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbl_Bookerror.setForeground(new java.awt.Color(255, 255, 204));
        jPanel1.add(lbl_Bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 710, 350, 50));

        jLabel14.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Name:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 150, 50));

        lbl_issuedate.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 300, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/ManagebookIcon (1).png"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 250, 220));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 540, 830));

        rSMaterialButtonCircle9.setBackground(new java.awt.Color(255, 61, 61));
        rSMaterialButtonCircle9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 153, 153)));
        rSMaterialButtonCircle9.setText("    RETURN ");
        rSMaterialButtonCircle9.setToolTipText("Issue Book");
        rSMaterialButtonCircle9.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        rSMaterialButtonCircle9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle9ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 640, 330, 70));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/leftarrow.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 90));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issuebookback.PNG"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 490, 290));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issuebookback.PNG"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 460, 490, 290));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked
       
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonCircle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle8ActionPerformed
       if(txt_book_ID.getText().equals("")) JOptionPane.showMessageDialog(this, "Please Enter Book ID");
       if(txt_student_ID.getText().equals("")) JOptionPane.showMessageDialog(this, "Please Enter Student ID");
       
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle8ActionPerformed

    private void txt_book_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_book_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_book_IDActionPerformed

    private void txt_book_IDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_book_IDFocusLost
             getIssueBookDetails();
    }//GEN-LAST:event_txt_book_IDFocusLost

    private void txt_student_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_student_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_IDActionPerformed

    private void txt_student_IDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_IDFocusLost
            getstudentID();
            lbl_Bookerror.setText("");
    }//GEN-LAST:event_txt_student_IDFocusLost

    private void rSMaterialButtonCircle9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle9ActionPerformed
        if(returnBook()){
        JOptionPane.showMessageDialog(this, "Book Returned Succesfully");
        updateBookCount();
        }
        else{
        JOptionPane.showMessageDialog(this, "Book Return Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle9ActionPerformed

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
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_Bookerror;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_duedate;
    private javax.swing.JLabel lbl_issuedate;
    private javax.swing.JLabel lbl_issueid;
    private javax.swing.JLabel lbl_studentname;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle8;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle9;
    private app.bolivia.swing.JCTextField txt_book_ID;
    private app.bolivia.swing.JCTextField txt_student_ID;
    // End of variables declaration//GEN-END:variables
}
