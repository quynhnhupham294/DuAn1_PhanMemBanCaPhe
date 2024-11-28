package GUI;

import Entity.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.Auth;

public class LoginWithAdmin extends javax.swing.JFrame {

    public LoginWithAdmin() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnQLNV = new javax.swing.JButton();
        btnQLTK = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnNhanVien = new javax.swing.JPanel();
        pnQuanLyTaiKhoan = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        btnQLNV.setText("Quản lý nhân viên");
        btnQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNVActionPerformed(evt);
            }
        });

        btnQLTK.setText("Quản lý tài khoản");
        btnQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLTKActionPerformed(evt);
            }
        });

        jButton1.setText("Quản lý chương trình giảm giá");

        jButton2.setText("Quản lý sản phẩm");

        jButton3.setText("Quản lý doanh thu");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THE COFFEE");

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        lblUserName.setText("UserName:");

        lblRole.setText("Role:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQLNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQLTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserName)
                .addGap(18, 18, 18)
                .addComponent(lblRole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQLTK)
                .addGap(32, 32, 32)
                .addComponent(btnQLNV)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(36, 36, 36)
                .addComponent(jButton3)
                .addGap(27, 27, 27)
                .addComponent(btnThoat)
                .addGap(34, 34, 34))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnNhanVien.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jPanel2.add(pnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnQuanLyTaiKhoan.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnQuanLyTaiKhoanLayout = new javax.swing.GroupLayout(pnQuanLyTaiKhoan);
        pnQuanLyTaiKhoan.setLayout(pnQuanLyTaiKhoanLayout);
        pnQuanLyTaiKhoanLayout.setHorizontalGroup(
            pnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
        pnQuanLyTaiKhoanLayout.setVerticalGroup(
            pnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuanLyTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNVActionPerformed
        showPanel(pnNhanVien);
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        showDialogInPanel(pnNhanVien, qlnv);
    }//GEN-LAST:event_btnQLNVActionPerformed

    private void btnQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLTKActionPerformed
        showPanel(pnQuanLyTaiKhoan);
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        showDialogInPanel(pnQuanLyTaiKhoan, qltk);
    }//GEN-LAST:event_btnQLTKActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWithAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQLNV;
    private javax.swing.JButton btnQLTK;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnQuanLyTaiKhoan;
    // End of variables declaration//GEN-END:variables

    public void init(){
        if (Auth.user != null) {
            setAccout(Auth.user.getUserName(), Auth.isManager() ? "Admin ": "Manager");
        }
    }
    
    public void setAccout(String userName, String roleId) {
        lblUserName.setText("Họ tên: " + userName);
        lblRole.setText("Vai trò: " + roleId);
    }
    
    private void showPanel(JPanel visiblePanel) {
        pnNhanVien.setVisible(false);
        pnNhanVien.setVisible(false);
        visiblePanel.setVisible(true);
    }
    
    public void showDialogInPanel(JPanel targetPanel, JFrame dialog) {
        // Tạo một JPanel để chứa nội dung của dialog
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout()); // Thiết lập layout BorderLayout cho contentPanel

        // Thêm nội dung của dialog vào giữa contentPanel
        contentPanel.add(dialog.getContentPane(), BorderLayout.CENTER);

        // Đặt kích thước ưu tiên của contentPanel bằng kích thước của panel đích
        contentPanel.setPreferredSize(new Dimension(targetPanel.getWidth(), targetPanel.getHeight()));

        // Xóa tất cả các thành phần hiện có trong targetPanel
        targetPanel.removeAll();

        // Thiết lập layout cho targetPanel
        targetPanel.setLayout(new BorderLayout());

        // Thêm contentPanel vào targetPanel
        targetPanel.add(contentPanel, BorderLayout.CENTER);

        // Cập nhật lại giao diện của targetPanel để đảm bảo các thay đổi được áp dụng
        targetPanel.revalidate();
        targetPanel.repaint();

        // Điều chỉnh kích thước của dialog để vừa với nội dung
        dialog.pack();
    }
    
}
