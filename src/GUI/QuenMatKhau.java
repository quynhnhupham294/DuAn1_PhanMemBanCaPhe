package GUI;

import DAO.NhanVienDAO;
import DAOImpl.NhanVienDAOImpl;
import Entity.User;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.Random;
import utils.MessageBox;
import utils.SendMaXacNhan;

public class QuenMatKhau extends javax.swing.JFrame {

    NhanVienDAO dao = new NhanVienDAOImpl();
    int maXacNhan = 0;
    
    public QuenMatKhau() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtMaXacNhan = new javax.swing.JTextField();
        btnGuiMaXacNhan = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quên mật khẩu");

        jLabel2.setText("UserName:");

        jLabel3.setText("Email:");

        jLabel4.setText("Mật khẩu mới:");

        jLabel5.setText("Mã xác nhận:");

        btnGuiMaXacNhan.setText("Gửi mã xác nhận");
        btnGuiMaXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMaXacNhanActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserName)
                            .addComponent(txtEmail)
                            .addComponent(txtPassword)
                            .addComponent(txtMaXacNhan)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnGuiMaXacNhan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnThoat)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuiMaXacNhan)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        this.updatePassword();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnGuiMaXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMaXacNhanActionPerformed
//        if (tonTai()) {
            sendMaXacNhan();
//        }else{
//           MessageBox.alert(this, "Tài khoản hoặc email không tồn tại!");
//        }
    }//GEN-LAST:event_btnGuiMaXacNhanActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiMaXacNhan;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaXacNhan;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

    public void init(){
        this.setLocationRelativeTo(null);
    }
    
    // Gửi mã xác nhận qua email
    public void sendMaXacNhan() {
        Random random = new Random();
        maXacNhan = random.nextInt(90000) + 10000; // Sinh mã trong khoảng 10000 - 99999
        try {
            SendMaXacNhan.sendMail(txtEmail.getText(), String.valueOf(maXacNhan));
            MessageBox.alert(this, "Gửi mã thành công! Vui lòng kiểm tra email.");
        } catch (Exception ex) {
            MessageBox.alert(this, "Gửi mã thất bại!");
        }
    }

    // Kiểm tra sự tồn tại của email trong cơ sở dữ liệu
//    public boolean tonTai() {
//        String email = (String) Jdbc.Values("SELECT email FROM [User] WHERE idUser=?", txtUserName.getText());
//        if (email == null) {
//            MessageBox.alert(this, "Email không tồn tại trong hệ thống.");
//            return false;
//        }
//        return txtEmail.getText().equals(email);
//    }

    // Xác nhận mã xác nhận
    public boolean xacNhan() {
        if (maXacNhan == 0) {
            MessageBox.alert(this, "Vui lòng nhấn gửi mã xác nhận trước.");
            return false;
        }
        try {
            int inputMaXacNhan = Integer.parseInt(txtMaXacNhan.getText());
            if (maXacNhan == inputMaXacNhan) {
                return true;
            } else {
                MessageBox.alert(this, "Mã xác nhận không hợp lệ!");
                return false;
            }
        } catch (NumberFormatException e) {
            MessageBox.alert(this, "Vui lòng nhập mã xác nhận hợp lệ.");
            return false;
        }
    }
    
    // Cập nhật mật khẩu mới sau khi gửi và nhập mà XN thành công
    public void updatePassword() {
        if(xacNhan()) {
            User nv = dao.findById(txtUserName.getText().trim());

            // Kiểm tra người dùng
            if (nv == null) {
                MessageBox.alert(this, "Người dùng không tồn tại!");
                return;
            }

            // Nếu người dùng tồn tại, cập nhật mật khẩu
            nv.setPassword(txtPassword.getText());
            
            String taoMatKhauMoi = new String(txtPassword.getPassword());
            String hashedPasswordNew = BCrypt.withDefaults().hashToString(12, taoMatKhauMoi.toCharArray());
            
            nv.setPassword(hashedPasswordNew);
            try {
                dao.update(nv);
                MessageBox.alert(this, "Đổi mật khẩu thành công");
                this.dispose();
            } catch (Exception ex) {
                MessageBox.alert(this, "Đổi mật khẩu thất bại!");
                ex.printStackTrace(); 
            }
        }
    }

}
