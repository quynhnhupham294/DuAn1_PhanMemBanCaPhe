/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.html.parser.Entity;
import utils.Jdbc;
import java.sql.DriverManager;
import java.sql.SQLException;

import Entity.Discount;
import java.lang.reflect.Method;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MessageBox;
import java.sql.Connection;
/**
 *
 * @author thing
 */
public class ChuongTrinhGiamGia extends javax.swing.JFrame {

    /**
     * Creates new form ChuongTrinhGiamGia
     */
    
    public ChuongTrinhGiamGia() {
        initComponents();
    }
    
   

//List<Discount> discounts = new ArrayList<>();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        discountTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtidDiscount = new javax.swing.JTextField();
        txtnameDiscount = new javax.swing.JTextField();
        txtdateStart = new javax.swing.JTextField();
        txtcondition = new javax.swing.JTextField();
        txtnote = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txtdiscountPercentage = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdescription = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdateEnd = new javax.swing.JTextField();
        txtdelete = new javax.swing.JTextField();
        txtupdate = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChuongTrinhGiamGia");

        discountTable.setAutoCreateRowSorter(true);
        discountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Tên chương trình", "Điều kiện", "Phần trăm giảm", "Trạng thái", "Ghi chú"
            }
        ));
        discountTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                discountTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(discountTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Danh sách chương trình giảm giá");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Quản lý chương trình giảm giá");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã giảm giá:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày bắt đầu:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên chương trình giảm giá:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Điều kiện:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ghi chú:");

        btnLuu.setBackground(new java.awt.Color(0, 204, 0));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox1.setText("Xác nhận");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Ngày kết thúc:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("Nhập mã giảm giá muốn xóa:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Phần trăm giảm:");

        txtdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeleteActionPerformed(evt);
            }
        });

        txtupdate.setBackground(new java.awt.Color(255, 255, 102));
        txtupdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtupdate.setText("Sửa");
        txtupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtupdateActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Trạng thái:");

        btnDelete1.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setText("XÓA");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtdateEnd)
                                        .addComponent(txtidDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(txtdateStart, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtdiscountPercentage, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtnote, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(txtnameDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(txtcondition, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(txtdescription))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLuu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtupdate))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete1)))))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtidDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtdateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtnameDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcondition)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdiscountPercentage)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnote, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(btnLuu)
                            .addComponent(txtupdate))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Phương thức lưu thông tin giảm giá
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
            if (jCheckBox1.isSelected()) {
                saveDiscount();  
            } else {
            // Hiển thị thông báo nếu checkbox chưa được tích chọn
            JOptionPane.showMessageDialog(this, "Vui lòng xác nhận lại thông tin trước khi lưu.");
    }
        
            
    }//GEN-LAST:event_btnLuuActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:;
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void discountTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_discountTableAncestorAdded
        // TODO add your handling code here:
        updateStatus();
        fillDiscountTable();
    }//GEN-LAST:event_discountTableAncestorAdded

    private void txtdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeleteActionPerformed
        
    }//GEN-LAST:event_txtdeleteActionPerformed

    private void txtupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtupdateActionPerformed

        
    updateDiscount();  // Gọi phương thức cập nhật
    }//GEN-LAST:event_txtupdateActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
         // TODO add your handling code here:
        String idDiscount = txtdelete.getText(); // Lấy idDiscount từ TextField
        
        if (idDiscount.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID của chương trình giảm giá!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
              deleteDiscount();  // Gọi phương thức xóa
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

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
            java.util.logging.Logger.getLogger(ChuongTrinhGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuongTrinhGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuongTrinhGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuongTrinhGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ChuongTrinhGiamGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnLuu;
    private javax.swing.JTable discountTable;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcondition;
    private javax.swing.JTextField txtdateEnd;
    private javax.swing.JTextField txtdateStart;
    private javax.swing.JTextField txtdelete;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtdiscountPercentage;
    private javax.swing.JTextField txtidDiscount;
    private javax.swing.JTextField txtnameDiscount;
    private javax.swing.JTextField txtnote;
    private javax.swing.JButton txtupdate;
    // End of variables declaration//GEN-END:variables


// YÊU CẦU;
//    1. Lấy dữ liệu từ database fill lên bảng
//    2. Lưu dữ liệu mới nhập vào Database

 
        
    public void initialize(){
         updateDiscount();  // Gọi phương thức cập nhật
        deleteDiscount();  // Gọi phương thức xóa
        this.setLocationRelativeTo(null);
        updateStatus();
        saveDiscount();
        fillDiscountTable();
        
    }
    // Khởi tạo discountList
    private List<Discount> discountList = new ArrayList<>();
    
    
// 1. Phương thức khi nhấn nút Lưu 
    private void saveDiscount(){
        // Lấy thông tin từ admin
        String idDiscount = txtidDiscount.getText();
        String dateStart = txtdateStart.getText();
        String dateEnd = txtdateEnd.getText();
        String nameDiscount = txtnameDiscount.getText();  
        String condition = txtcondition.getText();
        String discountPercentage =txtdiscountPercentage.getText();
        String description = txtdescription.getText();
         String note = txtnote.getText();
        //Tạo đối tượng Discount
        Discount discount = new Discount(idDiscount, dateStart, dateEnd, nameDiscount, condition, discountPercentage, description, note);
        
        //Thêm vào ds tạm
         discountList.add(discount);
         //a. Lấy danh sách từ CSDL
        fillDiscountTable();
        // b. Lưu dữ liệu mới vào database
        saveDiscountToDatabase(discount);
        
        // Cập nhật cho bảng discountTable
        updateStatus();   
     }
    
    
        
    // Cập nhật cho bảng discountTable
    private void updateStatus() {
    DefaultTableModel model = (DefaultTableModel) discountTable.getModel();
//    model.setRowCount(0); // Xóa các dòng cũ
    for (int i = 0; i < discountList.size(); i++){
        Discount discount = discountList.get(i);
        model.addRow(new Object[]{
            //i + 1, -> Đếm số lượng
            
            discount.getIdDiscount(),
            discount.getDateStart(),
            discount.getDateEnd(),
            discount.getNameDiscount(),
            discount.getCondition(),
            discount.getdiscountPercentage(),
            discount.getDescription(),
            discount.getNote()
        });
    }   
}

    //  a1. Lấy dữ liệu
    private List<Discount> getDiscount() {
    List<Discount> discountList = new ArrayList<>();
    String sql = "SELECT idDiscount,dateStart, dateEnd, nameDiscount, condition, discountPercentage,description, note  FROM Discount"; 

    try (ResultSet rs = Jdbc.executeQuery(sql)) {
        while (rs.next()) {
            Discount discount = new Discount(
                
                rs.getString("idDiscount"),
                rs.getString("dateStart"),
                rs.getString("dateEnd"),
                rs.getString("nameDiscount"), 
                rs.getString("condition"),
                rs.getString("discountPercentage"), 
                rs.getString("description"),
                rs.getString("note")
            );
            discountList.add(discount);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu từ database: " + e.getMessage());
    }
    return discountList;
    }
    // a2. Sau khi lấy dl -> đưa lên bảng
    public void fillDiscountTable() {
        // Lấy danh sách discount trong CSDL từ getDiscountList ở trên
        List<Discount> discounts = getDiscount();

        // Tạo DefaultTableModel với các tên cột tương ứng -> Hiển thị lên bảng
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Mã giảm giá");
        model.addColumn("Ngày bắt đầu ");
        model.addColumn("Ngày kết thúc");
        model.addColumn("Tên chương trình");
        model.addColumn("Điều kiện");
        model.addColumn("Phần trăm giảm");
        model.addColumn("Trạng thái");
        model.addColumn("Ghi chú");

        // Thêm dữ liệu vào bảng
        for (Discount discount : discounts) {
            model.addRow(new Object[]{
                
                discount.getIdDiscount(),
                discount.getDateStart(),
                discount.getDateEnd(),
                discount.getNameDiscount(),
                discount.getCondition(),
                discount.getdiscountPercentage(),
                discount.getDescription(),
                discount.getNote()
            });
        }

        // Gán model cho bảng discountTable
        discountTable.setModel(model);
}
    

// b. Lưu dữ liệu người dùng mới nhập vào thẳng database
private void saveDiscountToDatabase(Discount discount) {
    // Sử dụng JDBC để thêm Discount vào CSDL
    try {
        String sql = "INSERT INTO Discount (idDiscount,dateStart, dateEnd, nameDiscount, condition, discountPercentage, description, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        // Khai báo gián tiếp khi lớp Connection là private
        utils.Jdbc Connection = new utils.Jdbc();
        Connection connection = Connection.getConnection();
         
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, discount.getIdDiscount());
        ps.setString(2, discount.getDateStart()); 
        ps.setString(3, discount.getDateEnd());
        
        ps.setString(4, discount.getNameDiscount());
        ps.setString(5, discount.getCondition());
        ps.setString(6, discount.getdiscountPercentage());
        ps.setString(7, discount.getDescription());
        ps.setString(8, discount.getNote());
        
        
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// 2. Phương thức khi nhấn nút xóa
private void deleteDiscount() {
    String idDiscountToDelete = txtdelete.getText().trim();

    // Kiểm tra nếu idDiscountToDelete không rỗng
    if (idDiscountToDelete.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập mã giảm giá để xóa.");
        return;
    }

    // Thực hiện xóa bản ghi trong CSDL
    deleteDiscountFromDatabase(idDiscountToDelete);

    // Cập nhật lại bảng sau khi xóa
    fillDiscountTable();
}

// 3. Xóa Discount từ database
private void deleteDiscountFromDatabase(String idDiscount) {
    String sql = "DELETE FROM Discount WHERE idDiscount = ?";

    try {
        // Kết nối với database và thực thi câu lệnh xóa
        utils.Jdbc connectionUtil = new utils.Jdbc();
        Connection connection = connectionUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        
        // Set giá trị idDiscount vào câu lệnh SQL
        ps.setString(1, idDiscount);

        // Thực thi câu lệnh xóa
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Xóa thành công mã giảm giá: " + idDiscount);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã giảm giá: " + idDiscount);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu: " + e.getMessage());
    }
}
// 2. Phương thức khi nhấn nút Sửa
private void updateDiscount() {
    String idDiscountToUpdate = txtidDiscount.getText().trim();  // Lấy ID mã giảm giá người dùng nhập vào

    // Kiểm tra xem người dùng đã nhập ID chưa
    if (idDiscountToUpdate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập mã giảm giá cần sửa.");
        return;
    }

    // Kiểm tra xem mã giảm giá có tồn tại trong CSDL không
    if (!checkIfDiscountExists(idDiscountToUpdate)) {
        JOptionPane.showMessageDialog(this, "Mã giảm giá không tồn tại.");
        return;
    }

    // Lấy các giá trị mới từ các trường nhập liệu
    String dateStart = txtdateStart.getText();
    String dateEnd = txtdateEnd.getText();
    String nameDiscount = txtnameDiscount.getText();
    String condition = txtcondition.getText();
    String discountPercentage = txtdiscountPercentage.getText();
    String description = txtdescription.getText();
    String note = txtnote.getText();

    // Cập nhật dữ liệu vào cơ sở dữ liệu
    updateDiscountInDatabase(idDiscountToUpdate, dateStart, dateEnd, nameDiscount, condition, discountPercentage, description, note);

    // Cập nhật lại bảng sau khi sửa
    fillDiscountTable();
}

// 3. Kiểm tra xem mã giảm giá có tồn tại trong CSDL không
private boolean checkIfDiscountExists(String idDiscount) {
    String sql = "SELECT COUNT(*) FROM Discount WHERE idDiscount = ?";
    try (Connection connection = new utils.Jdbc().getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, idDiscount);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;  // Trả về true nếu có bản ghi tìm thấy
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;  // Không tìm thấy mã giảm giá
}

// 4. Cập nhật Discount vào database
private void updateDiscountInDatabase(String idDiscount, String dateStart, String dateEnd, String nameDiscount,
                                       String condition, String discountPercentage, String description, String note) {
    String sql = "UPDATE Discount SET dateStart = ?, dateEnd = ?, nameDiscount = ?, condition = ?, discountPercentage = ?, description = ?, note = ? WHERE idDiscount = ?";

    try (Connection connection = new utils.Jdbc().getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        // Set giá trị cho các tham số trong câu lệnh SQL
        ps.setString(1, dateStart);
        ps.setString(2, dateEnd);
        ps.setString(3, nameDiscount);
        ps.setString(4, condition);
        ps.setString(5, discountPercentage);
        ps.setString(6, description);
        ps.setString(7, note);
        ps.setString(8, idDiscount);  // Điều kiện để sửa là idDiscount

        // Thực thi câu lệnh UPDATE
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin giảm giá thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công. Kiểm tra lại mã giảm giá.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật dữ liệu: " + e.getMessage());
    }
}


}