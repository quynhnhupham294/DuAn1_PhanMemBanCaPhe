package GUI;

import Controller.CrudController;
import Controller.NaviController;
import DAO.NhanVienDAO;
import DAOImpl.NhanVienDAOImpl;
import Entity.User;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MessageBox;

public class QuanLyNhanVien extends javax.swing.JFrame implements NaviController, CrudController{
    
    int row = -1; 
    NhanVienDAO dao = new NhanVienDAOImpl();
    
    public QuanLyNhanVien() {
        initComponents();
        initialize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLyNhanVien = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        rboAdmin = new javax.swing.JRadioButton();
        rboManager = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        tbnLamMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý nhân viên");

        jToolBar1.setRollover(true);

        tblQuanLyNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "SDT", "Email", "Vai trò"
            }
        ));
        tblQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuanLyNhanVien);

        jToolBar1.add(jScrollPane1);

        tabs.addTab("Danh sách nhân viên", jToolBar1);

        jToolBar2.setRollover(true);
        jToolBar2.add(jLabel2);
        jToolBar2.add(jLabel3);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel4.setText("Mã nhân viên: ");

        jLabel5.setText("Tên nhân viên:");

        jLabel8.setText("Số điện thoại:");

        jLabel9.setText("Địa chỉ:");

        jLabel10.setText("Ghi chú:");

        jLabel11.setText("Vai trò:");

        rboAdmin.setText("Admin");
        rboAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboAdminActionPerformed(evt);
            }
        });

        rboManager.setText("Manager");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tbnLamMoi.setText("Làm mới");
        tbnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLamMoiActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel6.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                            .addComponent(txtSDT)
                            .addComponent(txtDiaChi)
                            .addComponent(txtMaNV)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rboAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rboManager, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnThem)
                                    .addComponent(btnFirst))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPrevious, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoa))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbnLamMoi)
                                    .addComponent(btnLast)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmail))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rboAdmin)
                    .addComponent(rboManager))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSua)
                        .addComponent(btnThem))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa)
                        .addComponent(tbnLamMoi)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jToolBar2.add(jPanel1);

        tabs.addTab("Thông tin chi tiết", jToolBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void tblQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyNhanVienMouseClicked
        row = tblQuanLyNhanVien.getSelectedRow();
        edit();
    }//GEN-LAST:event_tblQuanLyNhanVienMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        moveFirst();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        movePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        moveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        moveLast();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tbnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLamMoiActionPerformed
        this.reset();   
    }//GEN-LAST:event_tbnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.create();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        this.update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void rboAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboAdminActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JRadioButton rboAdmin;
    private javax.swing.JRadioButton rboManager;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblQuanLyNhanVien;
    private javax.swing.JButton tbnLamMoi;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables

    User nv = new User();
    
    @Override
    public void initialize(){
        this.setLocationRelativeTo(null);
        fillToTable();
        updateStatus();
    }
    
    // fillToTable: Lấy dữ liệu dưới data fill lên bảng danh sách nhân viên
    public void fillToTable(){
        List<User> list = dao.findAll();

        DefaultTableModel model = (DefaultTableModel) tblQuanLyNhanVien.getModel();
        model.setRowCount(0);

        list.forEach(nv -> {
            Object[] row = {nv.getIdUser()
                              , nv.getUserName()
                              , nv.getPhone()
                              , nv.getEmail()
                              , nv.isIdRole() ? 1 : 0};
            model.addRow(row);
        });
    }
    
    // Getter && Setter
    public void setForm(User nv) {
        txtMaNV.setText(nv.getIdUser());
        txtTenNV.setText(nv.getUserName());
//        txtMatKhau.setText(nv.getPassword());
//        txtXacNhanMatKhau.setText(nv.getPassword());
        txtSDT.setText(nv.getPhone());
        txtDiaChi.setText(nv.getAddress());
        txtEmail.setText(nv.getEmail());
        txtGhiChu.setText(nv.getDescription());
        rboAdmin.setSelected(nv.isIdRole());
        rboManager.setSelected(!nv.isIdRole());
    }
    
    public User getForm() {
        nv.setIdUser(txtMaNV.getText());
        nv.setUserName(txtTenNV.getText());
//        nv.setPassword(txtMatKhau.getText());
//        nv.setPassword(txtXacNhanMatKhau.getText());
        nv.setPhone(txtSDT.getText());
        nv.setAddress(txtDiaChi.getText());
        nv.setEmail(txtEmail.getText());
        nv.setDescription(txtGhiChu.getText());
        nv.setIdRole(rboAdmin.isSelected());
        return nv;
    }
    
    // Edit: Click vô table dữ liệu sẽ đẩy qua tabs Thông tin nhân viên
    @Override
    public void edit() {
        String idUser = (String) (tblQuanLyNhanVien.getValueAt(row, 0));
        User nv = (User) dao.findById(idUser);
        setForm(nv);
        tabs.setSelectedIndex(1); // Sự kiện click chuyển tabs
        updateStatus();
    }
    
    // Xử lý sự kiện các nút button: First, Back, Next, Last
    @Override
    public void moveFirst() {
        row = 0;
        edit();
    }
    
    @Override
    public void movePrevious() {
        if (row > 0) {
            row --;
            edit();
        }
    }
    
    @Override
    public void moveNext() {
        if (row < tblQuanLyNhanVien.getRowCount() -1){
            row ++;
            edit();
        }
    }
    
    @Override
    public void moveLast() {
        row = tblQuanLyNhanVien.getRowCount() - 1;
        edit();
    }

    // Xử lý sự kiện các nút: Thêm - Sửa - Xóa - Làm mới
    
    @Override
    public void create() {
        User nv = this.getForm(); 
//        String xacNhan = txtXacNhanMatKhau.getText();
        // Kiểm tra mật khẩu xác nhận
//        if (!xacNhan.equals(nv.getPassword())) {
//            MessageBox.alert(this, "Xác nhận mật khẩu không đúng!");
//            return;
//        }
        
        // Check biểu thức chính quy
        if (!validateRegex(nv)) {
            return;
        }
        
        try {
            dao.create(nv); 
            this.reset();
            this.fillToTable();
            MessageBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MessageBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    @Override
    public void update() {
        User nv = this.getForm(); 
//        String xacNhan = txtXacNhanMatKhau.getText();

//        if (!xacNhan.equals(nv.getPassword())) {
//            MessageBox.alert(this, "Xác nhận mật khẩu không đúng!");
//            return;
//        }
        
        // Check biểu thức chính quy
        if (!validateRegex(nv)) {
            return;
        }
        
        try {
            dao.update(nv); 
            this.reset();
            this.fillToTable();
            MessageBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MessageBox.alert(this, "Cập nhật thất bại! Lỗi: " + e.getMessage());
        }
    }

    @Override
    public void delete() {
        User nv = this.getForm();
        boolean confirm = MessageBox.Confirm(this, "Bạn có chắc chắn muốn xóa người dùng này không?");
        if (!confirm) {
            return; 
        }
        try {
            dao.deleteById(nv.getIdUser());
            this.reset();
            this.fillToTable();
            MessageBox.alert(this, "Xóa thành công!");
        } catch (Exception e) {
            MessageBox.alert(this, "Xóa thất bại! Lỗi: " + e.getMessage());
        }
    }

    @Override
    public void reset() {
        this.setForm(new User());
        ButtonGroup groupRole = new ButtonGroup();
        groupRole.add(rboAdmin);
        groupRole.add(rboManager);
        groupRole.clearSelection();
        updateStatus();
    }
    
    // Biểu thức chính quy(Check dữ liệu đầu vào)
    private boolean validateRegex(User user) {
        // Regex cho các cột
        String idUser = "^NV\\d{2}$";  
        String phone = "^0\\d{9}$"; 

        if (txtMaNV.getText().trim().length() == 0 || !user.getIdUser().matches(idUser)) {
            MessageBox.alert(this, txtMaNV.getText().trim().length() == 0 ? "Vui lòng nhập mã nhân viên" : "Mã nhân viên không hợp lệ! Mã bắt đầu với 'NV' + 2 số");
            txtMaNV.requestFocus();
            return false;
        }

        if (txtTenNV.getText().trim().length() == 0) {
            MessageBox.alert(this, "Vui lòng nhập tên nhân viên");
            txtTenNV.requestFocus();
            return false;
        }

//        if (txtMatKhau.getText().trim().length() == 0) {
//            MessageBox.alert(this, "Vui lòng nhập mật khẩu");
//            txtMatKhau.requestFocus();
//            return false;
//        }

//        if (txtXacNhanMatKhau.getText().trim().length() == 0 || !txtMatKhau.getText().equals(txtXacNhanMatKhau.getText())) {
//            MessageBox.alert(this, txtXacNhanMatKhau.getText().trim().length() == 0 ? "Vui lòng nhập xác nhận mật khẩu" : "Mật khẩu xác nhận không khớp");
//            txtXacNhanMatKhau.requestFocus();
//            return false;
//        }

        if (txtSDT.getText().trim().length() == 0 || !user.getPhone().matches(phone)) {
            MessageBox.alert(this, txtSDT.getText().trim().length() == 0 ? "Vui lòng nhập số điện thoại" : "Số điện thoại không hợp lệ! Số điện thoại phải bắt đầu từ số 0 và có 10 số.");
            txtSDT.requestFocus();
            return false;
        }

        if (txtDiaChi.getText().trim().length() == 0) {
            MessageBox.alert(this, "Vui lòng nhập địa chỉ");
            txtDiaChi.requestFocus();
            return false;
        }

        if (!rboAdmin.isSelected() && !rboManager.isSelected()) {
            MessageBox.alert(this, "Vui lòng chọn vai trò");
            return false;
        }

        // Phần ghi chú có thể bỏ trống nên không cần kiểm tra
        return true;
    }
    
    // Update status: Phân chia quyền cho các chức năng
    public void updateStatus() {
        boolean edit = (row>= 0);
        boolean first = (row == 0);
        boolean last = (row == tblQuanLyNhanVien.getRowCount() - 1);
        
        if (Auth.isManager()) {
            txtMaNV.setEnabled(!edit);
            btnThem.setEnabled(!edit);
            btnSua.setEnabled(edit);
            btnXoa.setEnabled(edit);
        } else {
            txtMaNV.setEnabled(false);
            txtTenNV.setEnabled(false);
//            txtMatKhau.setEnabled(false);
//            txtXacNhanMatKhau.setEnabled(false);
            txtSDT.setEnabled(false);
            txtDiaChi.setEnabled(false);
            txtEmail.setEnabled(false);
            txtGhiChu.setEnabled(false);
            rboAdmin.setEnabled(false);
            rboManager.setEnabled(false);
            
            btnThem.setEnabled(false);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
        }
        
        btnFirst.setEnabled(edit && !first);
        btnPrevious.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !first);
        btnLast.setEnabled(edit && !first);
    }
}
