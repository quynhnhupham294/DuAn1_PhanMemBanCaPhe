/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Test;

import DAOImpl.RevenueDAOImpl;
import DAOImpl.ProductTypeDAOImpl;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import Entity.Revenue;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import Entity.ProductType;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 *
 */
public class DoanhThuJDialog extends javax.swing.JFrame {
// Khai báo DAO để truy xuất dữ liệu doanh thu và loại sản phẩm 

    private RevenueDAOImpl dao = new RevenueDAOImpl();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày tháng
    private ProductTypeDAOImpl daoProType = new ProductTypeDAOImpl();

    /**
     * Creates new form DoanhThuJDialog
     */
    public DoanhThuJDialog() {
        initComponents();
        init();

    }

    public void init() {
        fillToTable();     // fill dữ liệu vào bảng
        generateCbx();     // Tạo các combobox

        setLocationRelativeTo(null);
    }

    public void generateCbx() {
        cbxLoaiSanPham();  // Tạo combobox cho loại sản phẩm
        cbxNam();          // Tạo combobox cho năm
    }

    public void cbxNam() {
        // Khởi tạo combobox cho năm
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Integer> list = dao.getYear(); // Lấy LIST các năm từ cơ sở dữ liệu

        model.addElement("Tất cả"); // Thêm lựa chọn "Tất cả"
        for (Integer o : list) {
            model.addElement(String.valueOf(o));  // Thêm các năm vào combobox
        }

        cbxNam.setModel(model);  // fill vào combobox năm
    }

    public void cbxLoaiSanPham() {
        // Khởi tạo  combobox loại sản phẩm
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<ProductType> list = daoProType.getAllData(); // Lấy danh sách loại sản phẩm

        model.addElement("Tất cả"); // Thêm lựa chọn "Tất cả"
        for (ProductType o : list) {
            model.addElement(o.getProductTypeName()); // Thêm tên loại sản phẩm vào combobox
        }

        cbxLoaiSanPham.setModel(model);  // fill vào combobox  loại sản phẩm
    }

    public void fillToTable() {
        DefaultTableModel model = new DefaultTableModel();  // Khởi tạo table
        List<Revenue> list = dao.getAllData();  // Lấy tất cả dữ liệu doanh thu

        // Cột của bảng
        String[] col = {
            "Mã sản phẩm",
            "Tên sản phẩm",
            "Tên loại",
            "Đơn giá",
            "Số lượng",
            "Tổng tiền",
            "Ngày lập"
        };

        model.setColumnIdentifiers(col);  // Đặt các cột cho bảng

        // Điền dữ liệu vào bảng
        for (Revenue o : list) {
            model.addRow(new Object[]{
                o.getIdProduct(),
                o.getProductName(),
                o.getProductNameType(),
                o.getPrice(),
                o.getQuantity(),
                o.getTotalMoney(),
                formatter.format(o.getDateTimeOrder())
            });
        }

        tblDoanhThu.setModel(model);  // fill cho bảng doanh thu
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        cbxLoaiSanPham = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        cbxNam = new javax.swing.JComboBox<>();
        btnImportExel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnDoanhThu = new javax.swing.JPanel();
        lblDoanThu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaSP", "Tên SP", "Số Lượng", "Giá", "Tổng Tiền", "Ngày Lập"
            }
        ));
        jScrollPane1.setViewportView(tblDoanhThu);

        cbxLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiSanPhamActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        cbxNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNamActionPerformed(evt);
            }
        });

        btnImportExel.setText("Xuất Excel");
        btnImportExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportExelActionPerformed(evt);
            }
        });

        jLabel1.setText("Năm");

        jLabel2.setText("Tên Loại");

        jLabel3.setText("Tìm kiếm");

        pnDoanhThu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDoanThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoanThu.setText("Tổng Doanh Thu:");

        javax.swing.GroupLayout pnDoanhThuLayout = new javax.swing.GroupLayout(pnDoanhThu);
        pnDoanhThu.setLayout(pnDoanhThuLayout);
        pnDoanhThuLayout.setHorizontalGroup(
            pnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoanhThuLayout.createSequentialGroup()
                .addComponent(lblDoanThu, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnDoanhThuLayout.setVerticalGroup(
            pnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(btnImportExel))
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLoaiSanPham)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportExel))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        filterTable();
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void cbxLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLoaiSanPhamActionPerformed
        filterTable();
    }//GEN-LAST:event_cbxLoaiSanPhamActionPerformed

    private void cbxNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNamActionPerformed
        filterTable();
    }//GEN-LAST:event_cbxNamActionPerformed

    private void btnImportExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportExelActionPerformed
        exportToExcel();
    }//GEN-LAST:event_btnImportExelActionPerformed

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
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoanhThuJDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImportExel;
    private javax.swing.JComboBox<String> cbxLoaiSanPham;
    private javax.swing.JComboBox<String> cbxNam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoanThu;
    private javax.swing.JPanel pnDoanhThu;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

   public double calculateTotalRevenue(String productType, String year) {
        double totalRevenue = 0.0;

        // Chuyển đổi năm thành null nếu chọn "Tất cả"
        Integer selectedYear = year.equals("Tất cả") ? null : Integer.parseInt(year);

        // Chuyển đổi loại sản phẩm thành chuỗi rỗng nếu chọn "Tất cả"
        String selectedProductType = productType.equals("Tất cả") ? "" : productType;

        // Lấy dữ liệu doanh thu đã lọc
        List<Revenue> filteredData = (selectedYear == null)
                ? dao.getDataByValue("", selectedProductType)
                : dao.getDataByValue("", selectedProductType, selectedYear);

        // Tính tổng doanh thu
        for (Revenue revenue : filteredData) {
            totalRevenue += revenue.getTotalMoney();
        }

        return totalRevenue;  // Trả về tổng doanh thu
    }

    /**
     * Hàm lọc bảng dựa trên các điều kiện đã chọn
     */
    public void filterTable() {
        DefaultTableModel model = new DefaultTableModel();  // Khởi tạo mô hình bảng

        // Lấy dữ liệu từ  ô nhập và combobox
        String searchQuery = txtTimKiem.getText();
        String selectedYear = (String) cbxNam.getSelectedItem();
        String selectedProductType = (String) cbxLoaiSanPham.getSelectedItem();

        // Xử lý các điều kiện lọc
        String yearFilter = selectedYear.equals("Tất cả") ? "" : selectedYear;
        String productTypeFilter = selectedProductType.equals("Tất cả") ? "" : selectedProductType;

        // Lấy dữ liệu doanh thu đã lọc
        List<Revenue> filteredData = yearFilter.isEmpty()
                ? dao.getDataByValue(searchQuery, productTypeFilter)
                : dao.getDataByValue(searchQuery, productTypeFilter, Integer.parseInt(yearFilter));

        
        String[] col = {
            "Mã sản phẩm",
            "Tên sản phẩm",
            "Tên loại",
            "Đơn giá",
            "Số lượng",
            "Tổng tiền",
            "Ngày lập"
        };
        model.setColumnIdentifiers(col);

        for (Revenue revenue : filteredData) {
            model.addRow(new Object[]{
                revenue.getIdProduct(),
                revenue.getProductName(),
                revenue.getProductNameType(),
                revenue.getPrice(),
                revenue.getQuantity(),
                revenue.getTotalMoney(),
                formatter.format(revenue.getDateTimeOrder())
            });
        }
        tblDoanhThu.setModel(model);  // fill vao table doanh thu

        // Tính tổng doanh thu và hiển thị label
        double totalRevenue = calculateTotalRevenue(selectedProductType, selectedYear);
        lblDoanThu.setText("Tổng Doanh Thu: " + totalRevenue + " VND");
    }

    public void exportToExcel() {
    try {
        // Khởi tạo JFileChooser để người dùng chọn nơi lưu tệp
        JFileChooser fileChooser = new JFileChooser();

        // Nếu người dùng chọn tệp để lưu
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Lấy tệp đã chọn
            File file = fileChooser.getSelectedFile();

            // Kiểm tra xem tên tệp có kết thúc bằng ".xlsx" không, nếu không thì thêm phần mở rộng này
            if (!file.getName().toLowerCase().endsWith(".xlsx")) {
                file = new File(file.getAbsolutePath() + ".xlsx");
            }

            // Tạo một workbook (tập tin Excel) mới với Apache POI
            Workbook workbook = new XSSFWorkbook();

            // Tạo một sheet mới trong workbook
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Doanh thu");

            // Lấy mô hình dữ liệu từ bảng (DefaultTableModel) để truy xuất dữ liệu
            DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();

            // Tạo hàng đầu tiên (tiêu đề cột) trong sheet Excel
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                // Đặt tên cột vào các ô trong hàng đầu tiên
                headerRow.createCell(i).setCellValue(model.getColumnName(i));
            }

            // Fill dữ liệu vào các hàng sau
            for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
                // Tạo một hàng mới trong Excel cho mỗi dòng dữ liệu
                Row row = sheet.createRow(rowIndex + 1);
                for (int colIndex = 0; colIndex < model.getColumnCount(); colIndex++) {
                    // Lấy giá trị của mỗi ô trong bảng và điền vào Excel
                    Object cellValue = model.getValueAt(rowIndex, colIndex);
                    row.createCell(colIndex).setCellValue(cellValue != null ? cellValue.toString() : "");
                }
            }

            // Lưu workbook vào tệp
            try (FileOutputStream out = new FileOutputStream(file)) {
                workbook.write(out); // Ghi nội dung workbook vào tệp
            }

            // Đóng workbook sau khi lưu
            workbook.close();

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!");
        }
    } catch (Exception ex) {
        // Nếu có lỗi, hiển thị thông báo lỗi
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}


}
