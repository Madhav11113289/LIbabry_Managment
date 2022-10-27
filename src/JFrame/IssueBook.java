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
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    // fetch book details
    
    public void getBookDetails(){
        int bookID = Integer.parseInt( txt_book_ID.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * from book_details WHERE book_id=?");
            pst.setInt(1, bookID);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                lbl_bookid.setText(rst.getString("book_id"));
                lbl_bookname.setText(rst.getString("book_name"));
                lbl_bookname.setToolTipText(rst.getString("book_name"));
                lbl_author.setText(rst.getString("author"));
                lbl_author.setToolTipText(rst.getString("author"));
                lbl_quantity1.setText(rst.getString("quantity"));
            }
            else{
                lbl_displayBookerror1.setText("Invalid Book ID!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //fetch student details
    public void getstudentDetails(){
        int studentID =Integer.parseInt(txt_student_ID.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM student_details WHERE student_id=?");
            pst.setInt(1, studentID);
            
            ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                lbl_studentid.setText(rst.getString("student_id"));
                lbl_studentname.setText(rst.getString("student_name"));
               // lbl_studentname.setToolTipText(lbl_studentname.getText());
                lbl_course.setText(rst.getString("course"));
                lbl_branch.setText(rst.getString("branch"));
                
            }
            else{
                lbl_displaystudenterror.setText("Invalid student ID!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //insert issue book details to database
    
    public boolean IssueBook(){
        boolean isIssued = false;
        
        int bookId = Integer.parseInt(txt_book_ID.getText());
        int studentId = Integer.parseInt(txt_student_ID.getText());
        String bookName = lbl_bookname.getText();
        String studentName = lbl_studentname.getText();
        
        Date uIssuDate = date_IssueDate.getDatoFecha();
        Date uDueDate = date_DueDate.getDatoFecha();
        
        Long l1 = uIssuDate.getTime();
        Long l2 = uDueDate.getTime();
        java.sql.Date sIssueDate= new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book(book_id,book_name,student_id,student_name,"
                    +"issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");
            
            int rowCount= pst.executeUpdate();
            if(rowCount>0){
                isIssued= true;
            }
            else isIssued = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }
    //updating book count 
    
    public void updateBookCount(){
         int bookId = Integer.parseInt(txt_book_ID.getText());
         try {
            Connection con = DBConnection.getConnection();
            String sql ="update book_details set quantity = quantity-1 WHERE  book_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book count updated");
                int inlCount =Integer.parseInt(lbl_quantity1.getText());
                lbl_quantity1.setText(Integer.toString(inlCount-1));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_quantity1 = new javax.swing.JLabel();
        lbl_displayBookerror1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_student_ID = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_course = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_displaystudenterror = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_book_ID = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        rSMaterialButtonCircle8 = new rojerusan.RSMaterialButtonCircle();
        date_DueDate = new rojeru_san.componentes.RSDateChooser();
        date_IssueDate = new rojeru_san.componentes.RSDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Book Name:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 150, 50));

        jLabel13.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Author:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 100, 50));

        jLabel15.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quantity:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 120, 50));

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 90));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 320, 80));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 340, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Book ID:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 110, 50));

        lbl_bookid.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 240, 50));

        lbl_bookname.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 240, 50));

        lbl_author.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 240, 50));

        lbl_quantity1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jPanel1.add(lbl_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 240, 50));

        lbl_displayBookerror1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbl_displayBookerror1.setForeground(new java.awt.Color(255, 255, 204));
        jPanel1.add(lbl_displayBookerror1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 350, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/managebook/ManagebookIcon (1).png"))); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 830));

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
        jPanel3.add(txt_student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 410, 240, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 42)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 122, 122));
        jLabel4.setText("Issue Books");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 280, 80));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ISSUEBOOK.PNG"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 260, 260));

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

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 450, 10));

        jPanel2.setBackground(new java.awt.Color(0, 77, 155));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Student ID:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 140, 50));

        jLabel20.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Student Name:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, 50));

        jLabel21.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Course:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 100, 50));

        jLabel23.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Branch:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 100, 50));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Details");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 320, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 410, 10));

        lbl_course.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 230, 50));

        lbl_branch.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 230, 50));

        lbl_studentid.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbl_studentid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 230, 50));

        lbl_studentname.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 230, 50));

        lbl_displaystudenterror.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbl_displaystudenterror.setForeground(new java.awt.Color(255, 255, 204));
        jPanel2.add(lbl_displaystudenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 350, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/manageUser.PNG"))); // NOI18N
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 250, 240));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 460, 830));

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
        jPanel3.add(txt_book_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 320, 240, -1));

        jLabel19.setBackground(new java.awt.Color(255, 102, 51));
        jLabel19.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 102, 51));
        jLabel19.setText("Due Date:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 570, -1, 50));

        jLabel22.setBackground(new java.awt.Color(255, 102, 51));
        jLabel22.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 102, 51));
        jLabel22.setText("Book ID:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 320, 110, 50));

        jLabel24.setBackground(new java.awt.Color(255, 102, 51));
        jLabel24.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 102, 51));
        jLabel24.setText("Student ID:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 410, 140, 50));

        jLabel25.setBackground(new java.awt.Color(255, 102, 51));
        jLabel25.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 102, 51));
        jLabel25.setText("Issue Date:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 490, 140, 50));

        rSMaterialButtonCircle8.setBackground(new java.awt.Color(255, 61, 61));
        rSMaterialButtonCircle8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 153, 153)));
        rSMaterialButtonCircle8.setText("     Issue Book");
        rSMaterialButtonCircle8.setToolTipText("Issue Book");
        rSMaterialButtonCircle8.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        rSMaterialButtonCircle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle8ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 710, 330, 70));

        date_DueDate.setBackground(new java.awt.Color(255, 102, 51));
        date_DueDate.setColorBackground(new java.awt.Color(255, 102, 51));
        date_DueDate.setColorForeground(new java.awt.Color(255, 102, 51));
        date_DueDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        date_DueDate.setPlaceholder("Due Date");
        jPanel3.add(date_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 570, 280, -1));

        date_IssueDate.setBackground(new java.awt.Color(255, 102, 51));
        date_IssueDate.setColorBackground(new java.awt.Color(255, 102, 51));
        date_IssueDate.setColorForeground(new java.awt.Color(255, 102, 51));
        date_IssueDate.setPlaceholder("Issue Date");
        jPanel3.add(date_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 490, 280, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_student_IDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_IDFocusLost
        if(!txt_student_ID.getText().equals(""))
            getstudentDetails();
    }//GEN-LAST:event_txt_student_IDFocusLost

    private void txt_student_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_student_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_IDActionPerformed

    private void rSMaterialButtonCircle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle8ActionPerformed
        if(lbl_quantity1.getText().equals("0")){
        JOptionPane.showMessageDialog(this, "Book Not Avaliable");
    }
        else{
        if(isAlreadyIssued()){
             if(IssueBook()){
                     JOptionPane.showMessageDialog(this, "Book Issued Successfully");
                        updateBookCount();
                    }
                else 
                    JOptionPane.showMessageDialog(this,"Book Issue Failed");
    }//GEN-LAST:event_rSMaterialButtonCircle8ActionPerformed
        else{
        JOptionPane.showMessageDialog(this, "Book has Already been Issued to this Student");
        }
                }
    }
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_book_IDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_book_IDFocusLost
        if(!txt_book_ID.getText().equals(""))
        getBookDetails();
    }//GEN-LAST:event_txt_book_IDFocusLost

    private void txt_book_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_book_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_book_IDActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_DueDate;
    private rojeru_san.componentes.RSDateChooser date_IssueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_displayBookerror1;
    private javax.swing.JLabel lbl_displaystudenterror;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lbl_studentname;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle8;
    private app.bolivia.swing.JCTextField txt_book_ID;
    private app.bolivia.swing.JCTextField txt_student_ID;
    // End of variables declaration//GEN-END:variables
}
