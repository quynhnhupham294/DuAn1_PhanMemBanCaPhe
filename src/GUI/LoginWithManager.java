package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.Auth;

public class LoginWithManager extends javax.swing.JFrame {

    public LoginWithManager() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnQLTK = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnQuanLyTaiKhoan = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        btnQLTK.setText("Quản lý tài khoản");
        btnQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLTKActionPerformed(evt);
            }
        });

        jButton2.setText("Danh sách sản phẩm");

        jButton3.setText("Đơn hàng");

        jButton4.setText("Chương trình giảm giá");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THE COFFEE");

        lblUserName.setText("User name:");

        lblRole.setText("Role:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQLTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addGap(36, 36, 36))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new java.awt.CardLayout());

        pnQuanLyTaiKhoan.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout pnQuanLyTaiKhoanLayout = new javax.swing.GroupLayout(pnQuanLyTaiKhoan);
        pnQuanLyTaiKhoan.setLayout(pnQuanLyTaiKhoanLayout);
        pnQuanLyTaiKhoanLayout.setHorizontalGroup(
            pnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        pnQuanLyTaiKhoanLayout.setVerticalGroup(
            pnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuanLyTaiKhoan, "card2");

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, "card3");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLTKActionPerformed
        showPanel(pnQuanLyTaiKhoan);
        QuanLyNhanVien qltk = new QuanLyNhanVien();
        showDialogInPanel(pnQuanLyTaiKhoan, qltk);
    }//GEN-LAST:event_btnQLTKActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWithManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQLTK;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
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
        pnQuanLyTaiKhoan.setVisible(false);
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
}
