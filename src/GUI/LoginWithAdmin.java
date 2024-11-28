package GUI;

import Test.ChuongTrinhGiamGia;
import Test.DoanhThuJDialog;
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
        btnQLCTGG = new javax.swing.JButton();
        btnQLSP = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        btnDonHang = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnQLKH = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnQuanLyTaiKhoan = new javax.swing.JPanel();
        pnQuanLyNhanVien = new javax.swing.JPanel();
        pnQuanLySanPham = new javax.swing.JPanel();
        pnChuongTrinhGiamGia = new javax.swing.JPanel();
        pnQuanLyKhachHang = new javax.swing.JPanel();
        pnQuanLyDoanhThu = new javax.swing.JPanel();
        pnDonHang = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        btnQLNV.setText("Quản lý nhân viên - Admin");
        btnQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNVActionPerformed(evt);
            }
        });

        btnQLTK.setBackground(new java.awt.Color(153, 255, 153));
        btnQLTK.setText("Quản lý tài khoản");
        btnQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLTKActionPerformed(evt);
            }
        });

        btnQLCTGG.setText("Quản lý chương trình giảm giá - Admin");
        btnQLCTGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLCTGGActionPerformed(evt);
            }
        });

        btnQLSP.setText("Quản lý sản phẩm - Admin");
        btnQLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLSPActionPerformed(evt);
            }
        });

        jButton3.setText("Quản lý doanh thu - Admin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THE COFFEE");

        btnThoat.setBackground(new java.awt.Color(153, 255, 153));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        lblUserName.setText("UserName:");

        lblRole.setText("Role:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRole)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        btnDonHang.setText("Đơn hàng + Mã giảm giá");
        btnDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonHangActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(153, 255, 153));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnQLKH.setText("Quản lý khách hàng");
        btnQLKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQLNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQLCTGG, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(btnQLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQLTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDonHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLTK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQLNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQLSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQLCTGG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(btnDonHang)
                .addGap(18, 18, 18)
                .addComponent(btnQLKH)
                .addGap(18, 18, 18)
                .addComponent(btnThoat)
                .addGap(18, 18, 18)
                .addComponent(btnDangXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new java.awt.CardLayout());

        pnQuanLyTaiKhoan.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnQuanLyTaiKhoanLayout = new javax.swing.GroupLayout(pnQuanLyTaiKhoan);
        pnQuanLyTaiKhoan.setLayout(pnQuanLyTaiKhoanLayout);
        pnQuanLyTaiKhoanLayout.setHorizontalGroup(
            pnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnQuanLyTaiKhoanLayout.setVerticalGroup(
            pnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuanLyTaiKhoan, "card3");

        pnQuanLyNhanVien.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnQuanLyNhanVienLayout = new javax.swing.GroupLayout(pnQuanLyNhanVien);
        pnQuanLyNhanVien.setLayout(pnQuanLyNhanVienLayout);
        pnQuanLyNhanVienLayout.setHorizontalGroup(
            pnQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        pnQuanLyNhanVienLayout.setVerticalGroup(
            pnQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuanLyNhanVien, "card2");

        pnQuanLySanPham.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnQuanLySanPhamLayout = new javax.swing.GroupLayout(pnQuanLySanPham);
        pnQuanLySanPham.setLayout(pnQuanLySanPhamLayout);
        pnQuanLySanPhamLayout.setHorizontalGroup(
            pnQuanLySanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        pnQuanLySanPhamLayout.setVerticalGroup(
            pnQuanLySanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuanLySanPham, "card4");

        pnChuongTrinhGiamGia.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnChuongTrinhGiamGiaLayout = new javax.swing.GroupLayout(pnChuongTrinhGiamGia);
        pnChuongTrinhGiamGia.setLayout(pnChuongTrinhGiamGiaLayout);
        pnChuongTrinhGiamGiaLayout.setHorizontalGroup(
            pnChuongTrinhGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnChuongTrinhGiamGiaLayout.setVerticalGroup(
            pnChuongTrinhGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel2.add(pnChuongTrinhGiamGia, "card5");

        pnQuanLyKhachHang.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnQuanLyKhachHangLayout = new javax.swing.GroupLayout(pnQuanLyKhachHang);
        pnQuanLyKhachHang.setLayout(pnQuanLyKhachHangLayout);
        pnQuanLyKhachHangLayout.setHorizontalGroup(
            pnQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        pnQuanLyKhachHangLayout.setVerticalGroup(
            pnQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuanLyKhachHang, "card8");

        pnQuanLyDoanhThu.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnQuanLyDoanhThuLayout = new javax.swing.GroupLayout(pnQuanLyDoanhThu);
        pnQuanLyDoanhThu.setLayout(pnQuanLyDoanhThuLayout);
        pnQuanLyDoanhThuLayout.setHorizontalGroup(
            pnQuanLyDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        pnQuanLyDoanhThuLayout.setVerticalGroup(
            pnQuanLyDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuanLyDoanhThu, "card6");

        pnDonHang.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnDonHangLayout = new javax.swing.GroupLayout(pnDonHang);
        pnDonHang.setLayout(pnDonHangLayout);
        pnDonHangLayout.setHorizontalGroup(
            pnDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        pnDonHangLayout.setVerticalGroup(
            pnDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel2.add(pnDonHang, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNVActionPerformed
        showPanel(pnQuanLyNhanVien);
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        showDialogInPanel(pnQuanLyNhanVien, qlnv);
    }//GEN-LAST:event_btnQLNVActionPerformed

    private void btnQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLTKActionPerformed
        showPanel(pnQuanLyTaiKhoan);
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        showDialogInPanel(pnQuanLyTaiKhoan, qltk);
    }//GEN-LAST:event_btnQLTKActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnQLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSPActionPerformed
//        showPanel(pnQuanLySanPham);
//        Oder qlsp = new Oder();
//        showDialogInPanel(pnQuanLySanPham, qlsp);
    }//GEN-LAST:event_btnQLSPActionPerformed

    private void btnQLCTGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLCTGGActionPerformed
        showPanel(pnChuongTrinhGiamGia);
        ChuongTrinhGiamGia ctgg = new ChuongTrinhGiamGia();
        showDialogInPanel(pnChuongTrinhGiamGia, ctgg);
    }//GEN-LAST:event_btnQLCTGGActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showPanel(pnQuanLyDoanhThu);
        DoanhThuJDialog dt = new DoanhThuJDialog();
        showDialogInPanel(pnQuanLyDoanhThu, dt);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonHangActionPerformed
        showPanel(pnQuanLySanPham);
        Oder qlsp = new Oder();
        showDialogInPanel(pnQuanLySanPham, qlsp);
    }//GEN-LAST:event_btnDonHangActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnQLKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKHActionPerformed
        showPanel(pnQuanLyKhachHang);
        CustomerJDialog qlkh = new CustomerJDialog();
        showDialogInPanel(pnQuanLyKhachHang, qlkh);
    }//GEN-LAST:event_btnQLKHActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWithAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDonHang;
    private javax.swing.JButton btnQLCTGG;
    private javax.swing.JButton btnQLKH;
    private javax.swing.JButton btnQLNV;
    private javax.swing.JButton btnQLSP;
    private javax.swing.JButton btnQLTK;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnChuongTrinhGiamGia;
    private javax.swing.JPanel pnDonHang;
    private javax.swing.JPanel pnQuanLyDoanhThu;
    private javax.swing.JPanel pnQuanLyKhachHang;
    private javax.swing.JPanel pnQuanLyNhanVien;
    private javax.swing.JPanel pnQuanLySanPham;
    private javax.swing.JPanel pnQuanLyTaiKhoan;
    // End of variables declaration//GEN-END:variables

    public void init(){
        if (Auth.user != null) {
            setAccout(Auth.user.getUserName(), Auth.isManager() ? "Admin ": "Manager");
        }
        
        updateStatus();
    }
    
    public void setAccout(String userName, String roleId) {
        lblUserName.setText("Họ tên: " + userName);
        lblRole.setText("Vai trò: " + roleId);
    }
    
    private void showPanel(JPanel visiblePanel) {
        pnQuanLyNhanVien.setVisible(false);
        pnQuanLyNhanVien.setVisible(false);
        pnQuanLySanPham.setVisible(false);
        pnChuongTrinhGiamGia.setVisible(false);
        pnQuanLyTaiKhoan.setVisible(false);
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
    
    public void updateStatus() {
        if (!Auth.isManager()) {
            // Nếu là Manager thì ẩn JButton và vô hiệu hóa chức năng liên quan
//            btnQLNV.setVisible(false);
//            btnQLNV.setEnabled(false);
            btnQLSP.setVisible(false);
            btnQLSP.setEnabled(false);
            btnQLCTGG.setVisible(false);
            btnQLCTGG.setEnabled(false);
            btnQLKH.setVisible(false);
            btnQLKH.setEnabled(false);
        } else {
//            btnQLNV.setVisible(true);
//            btnQLNV.setEnabled(true);
            btnQLSP.setVisible(true);
            btnQLSP.setEnabled(true);
            btnQLCTGG.setVisible(true);
            btnQLCTGG.setEnabled(true);
            btnQLKH.setVisible(true);
            btnQLKH.setEnabled(true);
        }
    }

}
