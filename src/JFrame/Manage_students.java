/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Madhav
 */
public class Manage_students extends javax.swing.JFrame {

    /**
     * Creates new form Manage_books
     */
    public Manage_students() {
        initComponents();
        studentTable();
    }
    // Set variables 

      String studentName, course,branch;
        int studentId;
        DefaultTableModel model;
        
    // To set details on the table
    public void studentTable(){
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM student_details");
            
            while(rs.next()){
            String bookId = rs.getString("student_id");
            String bookname = rs.getString("student_name");
            String course = rs.getString("course");
            String branch = rs.getString("branch");
            
            
            Object [] obj ={bookId,bookname,course,branch};
            model= (DefaultTableModel)tbl_studentDetails.getModel();
            model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    //to add book from book table
    public boolean addstudent(){
        boolean isAdded = false;
        studentId = Integer.parseInt(txt_student_ID.getText());
        studentName = txt_student_name.getText();
        course = combo_course_name.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
       
        
        try {
            Connection con = DBConnection.getConnection();
            String sql =" INSERT into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowcount = pst.executeUpdate();
            if(rowcount>0){
                isAdded =true;
            }
            else {
                isAdded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    // to update book details
    //??ISSUE
    public boolean updatestudent(){
         boolean isupdated = false;
        studentId = Integer.parseInt(txt_student_ID.getText());
        studentName = txt_student_name.getText();
         branch = combo_branch.getSelectedItem().toString();
         course = combo_course_name.getSelectedItem().toString();
    
            try {
                Connection con =DBConnection.getConnection();
                String sql = "update student_details set student_name=?,course =?, branch=? WHERE student_id=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, studentName);
                pst.setString(2, course);
                pst.setString(3, branch);
                pst.setInt(4, studentId);
                
                int rowcount = pst.executeUpdate();
                if(rowcount>0) isupdated = true;
                else isupdated = false;
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return isupdated;
    }
    //method tho delete book details
    public boolean deletestudent(){
        boolean isDeleted = false;
        studentId = Integer.parseInt(txt_student_ID.getText());
        try {
            Connection con= DBConnection.getConnection();
            String sql ="DELETE  from student_details where student_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0) isDeleted = true;
            else isDeleted = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    //method to clear tabel
    public void clearTable(){
    DefaultTableModel model =  (DefaultTableModel)tbl_studentDetails.getModel();
    model.setRowCount(0);
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
        txt_student_ID = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_student_name = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle6 = new rojerusan.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        combo_branch = new javax.swing.JComboBox<>();
        combo_course_name = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_student_ID.setBackground(new java.awt.Color(153, 153, 153));
        txt_student_ID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
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
        jPanel1.add(txt_student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 370, -1));

        jLabel10.setBackground(new java.awt.Color(122, 129, 219));
        jLabel10.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(122, 129, 219));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Student ID 60X60.png"))); // NOI18N
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 60, 70));

        jLabel9.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Student ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 220, 50));

        txt_student_name.setBackground(new java.awt.Color(153, 153, 153));
        txt_student_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_student_name.setForeground(new java.awt.Color(51, 51, 51));
        txt_student_name.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_student_name.setPlaceholder("Enter Student Name");
        txt_student_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_nameFocusLost(evt);
            }
        });
        txt_student_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_student_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 370, -1));

        jLabel11.setBackground(new java.awt.Color(122, 129, 219));
        jLabel11.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(122, 129, 219));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/studentName 30X60.png"))); // NOI18N
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 40, 70));

        jLabel12.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Student Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 250, 50));

        jLabel13.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter Course Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 250, 50));

        jLabel14.setBackground(new java.awt.Color(122, 129, 219));
        jLabel14.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(122, 129, 219));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/authorname.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 60, 70));

        jLabel15.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Branch");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 130, 50));

        jLabel16.setBackground(new java.awt.Color(122, 129, 219));
        jLabel16.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(122, 129, 219));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/quantity.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/delete.PNG"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 660, -1, 80));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/add1.PNG"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, -1, 80));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/update1.PNG"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, -1, 100));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 61, 61));
        rSMaterialButtonCircle5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 153, 153)));
        rSMaterialButtonCircle5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/add.png"))); // NOI18N
        rSMaterialButtonCircle5.setText("        ADD");
        rSMaterialButtonCircle5.setToolTipText("");
        rSMaterialButtonCircle5.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 150, 70));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 61, 61));
        rSMaterialButtonCircle4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 153, 153)));
        rSMaterialButtonCircle4.setText("     DELETE");
        rSMaterialButtonCircle4.setToolTipText("");
        rSMaterialButtonCircle4.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, 160, 70));

        rSMaterialButtonCircle6.setBackground(new java.awt.Color(255, 61, 61));
        rSMaterialButtonCircle6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 153, 153)));
        rSMaterialButtonCircle6.setText("      UPDATE");
        rSMaterialButtonCircle6.setToolTipText("");
        rSMaterialButtonCircle6.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        rSMaterialButtonCircle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle6ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 690, 170, 70));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/leftarrow.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 70));

        jPanel2.setBackground(new java.awt.Color(255, 61, 61));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 102, 0));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/homepage/students.png"))); // NOI18N
        jLabel17.setText("jLabel15");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 70, 80));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(226, 226, 226));
        jLabel8.setText("                 Manage Students");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 250, 80));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 340, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 130));

        combo_branch.setBackground(new java.awt.Color(153, 153, 153));
        combo_branch.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 17)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "Mechanical", "Electronics", "Civil" }));
        combo_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_branchActionPerformed(evt);
            }
        });
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 370, 30));

        combo_course_name.setBackground(new java.awt.Color(153, 153, 153));
        combo_course_name.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 17)); // NOI18N
        combo_course_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.TECH", "M.TECH", "PHD", "BCA", "MCA" }));
        combo_course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_course_nameActionPerformed(evt);
            }
        });
        jPanel1.add(combo_course_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 370, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(132, 132, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 102, 102));
        tbl_studentDetails.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 1020, 430));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 122, 122));
        jLabel3.setText("Manage Students");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 320, 80));

        jPanel5.setBackground(new java.awt.Color(255, 122, 122));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 310, 10));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close.PNG"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 50, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/manageUser.PNG"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, -20, 250, 330));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1140, 830));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_student_IDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_IDFocusLost

    }//GEN-LAST:event_txt_student_IDFocusLost

    private void txt_student_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_student_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_IDActionPerformed

    private void txt_student_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_nameFocusLost

    private void txt_student_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_student_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_nameActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
  if(deletestudent()){
            JOptionPane.showMessageDialog(this, "Student detail deleted Succesfuly");
            clearTable();
            studentTable();
        }
        else
                JOptionPane.showMessageDialog(this, "Student detail deleted Failed");
        
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        if(addstudent()){
            JOptionPane.showMessageDialog(this, "Student Added Succesfuly");
            clearTable();
            studentTable();
        }
        else
                JOptionPane.showMessageDialog(this, "Student Added Failed");
        
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle6ActionPerformed
       if(updatestudent()){
            JOptionPane.showMessageDialog(this, "Student Updated Succesfuly");
            clearTable();
            studentTable();
        }
        else
                JOptionPane.showMessageDialog(this, "Student Updated Failed");
        
    }//GEN-LAST:event_rSMaterialButtonCircle6ActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
       int rowNo = tbl_studentDetails.getSelectedRow();
       TableModel model = tbl_studentDetails.getModel();
       txt_student_ID.setText(model.getValueAt(rowNo, 0).toString());
       txt_student_name.setText(model.getValueAt(rowNo, 1).toString());
       combo_course_name.setSelectedItem(model.getValueAt(rowNo, 2).toString());
       combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
       
      
       
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       HomePage page = new HomePage();
       page.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void combo_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_branchActionPerformed

    private void combo_course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_course_nameActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Manage_students managestudent = new Manage_students();
        managestudent.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
       
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
       
    }//GEN-LAST:event_jLabel8MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseEntered

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
            java.util.logging.Logger.getLogger(Manage_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_students().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_course_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle6;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_student_ID;
    private app.bolivia.swing.JCTextField txt_student_name;
    // End of variables declaration//GEN-END:variables
}
