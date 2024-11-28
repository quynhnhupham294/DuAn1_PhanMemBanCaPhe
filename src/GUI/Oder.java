/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import DAOImpl.DiscountDAOImpl;
import DAOImpl.ProductDAOImpl;
import Entity.Discount;
import javax.swing.JOptionPane;
import Entity.Product;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import utils.Jdbc;
    import java.text.DecimalFormat;
/**
 *
 * @author vuthe
 */
public class Oder extends javax.swing.JFrame {
    ProductDAOImpl dao =new ProductDAOImpl();
    private List<OrderItem> orderItems = new ArrayList<>();

    private DiscountDAOImpl daoImpl = new DiscountDAOImpl();
    int row = -1;








    /**
     * Creates new form Oder
     */
    public Oder() {
        initComponents();
        form();
        loadProductData1();
        showComboData();
    }

    class OrderItem {
        String productName;
        int quantity;
        double price;
        public OrderItem(int quantity) {
        this.quantity = quantity;
    }

        public OrderItem(String productName, int quantity, double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public double getTotalPrice() {
            return quantity * price; 
        }
    }


    private void form() {
        jplcoffe.setLayout(new GridLayout(0, 3));
        jplnuoc.setLayout(new GridLayout(0, 3));
        jplthucan.setLayout(new GridLayout(0, 3));
        jpltall.setLayout(new GridLayout(0, 3));
        jpltra.setLayout(new GridLayout(0, 3));
        tblcoffe.addTab("Tất cả", new JScrollPane(jpltall)); // thêm JScrollPane
        tblcoffe.addTab("Cà phê", new JScrollPane(jplcoffe)); 
        tblcoffe.addTab("Nước", new JScrollPane(jplnuoc)); 
        tblcoffe.addTab("Thức ăn", new JScrollPane(jplthucan));
        tblcoffe.addTab("Trà", new JScrollPane(jpltra));
    }

    
   

   class OrderTableModel extends AbstractTableModel {//bảng sp đã oder
        private final String[] columnNames = {"STT", "Tên sản phẩm", "Giá", "Số lượng"};

        @Override
        public int getRowCount() {
            return orderItems.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            OrderItem item = orderItems.get(rowIndex);
            switch (columnIndex) {
                case 0: return rowIndex + 1; // STT
                case 1: return item.productName; // Tên sản phẩm
                case 2: return String.format("%.3f", item.price); // Giá
                case 3: return item.quantity; // Số lượng
                
                default: return null;
            }
        }
        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return (columnIndex == 4) ? JPanel.class : super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false; // Các ô không thể chỉnh sửa
        }
    }




    private void updateOrderTotal() {
        double totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        jbltongtien.setText("Tổng thành tiền: " + String.format("%.3f", totalPrice));
        showComboData(); // Áp dụng mã giảm giá nếu tổng tiền thỏa mãn điều kiện

    }

    private void updateOrderDetails() {
        OrderTableModel model = new OrderTableModel();
        jtblthongtin.setModel(model);
        updateOrderTotal();
    }


    private void loadProductData1() {//lấy sp từ DAO
        List<Product> products = dao.getAllData();
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm nào trong cơ sở dữ liệu!");
            return;
        }
        for (Product product : products) {//phân sản phẩm theo loại
            addProductToPanel(product, jpltall);
            switch (product.getIdProductType()) {
                case "LSP01":
                    addProductToPanel(product, jplnuoc);
                    break;
                case "LSP02":
                    addProductToPanel(product, jplcoffe);
                    break;
                case "LSP03":
                    addProductToPanel(product, jplthucan);
                    break;
                case "LSP05":
                    addProductToPanel(product, jpltra);
                    break;
                default:
                    break;
            }
        }
    }

   private void addProductToPanel(Product product, JPanel panel) {// set sản phẩm vào jpanel
    JPanel productPanel = new JPanel();
    productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

    JLabel productName = new JLabel(product.getIdProductName());
    JLabel productPrice = new JLabel(String.format("Giá: %.3f", product.getPrice()));
    JLabel productImage = new JLabel();
    setProductImage(product.getImage(), productImage);

    productImage.setPreferredSize(new Dimension(150, 150));//set size ảnh
    JTextField quantityField = new JTextField("1", 5);
    quantityField.setMaximumSize(new Dimension(50, 30));

    JButton addButton = new JButton("Thêm");
    addButton.addActionListener(evt -> addProductToOrder(product.getIdProductName(), productPrice, quantityField));

    productPanel.add(productImage);
    productPanel.add(productName);
    productPanel.add(productPrice);
    productPanel.add(quantityField);
    productPanel.add(addButton);

    panel.add(productPanel);
    panel.revalidate();
    panel.repaint();
}



    private void setProductImage(String imagePath, JLabel label) {
        try {
            URL url = new URL(imagePath);
            Image image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            label.setText("Hình ảnh không có");
        }
    }

    private void addProductToOrder(String productName, JLabel priceLabel, JTextField quantityField) {
        String priceText = priceLabel.getText().replace("Giá: ", "").replace(",", ".").trim();

        try {
            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityField.getText());
            if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số dương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
            boolean productExists = false;
            for (OrderItem orderItem : orderItems) {
                if (orderItem.productName.equals(productName)) {
                    orderItem.quantity += quantity;
                    productExists = true;
                    break;
                }
            }

            if (!productExists) {
                OrderItem item = new OrderItem(productName, quantity, price);
                orderItems.add(item);
            }
            updateOrderDetails();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm không hợp lệ: " + priceText, "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPayment() {
        StringBuilder orderDetails = new StringBuilder();
        for (OrderItem orderItem : orderItems) {
            orderDetails.append("\n").append(orderItem.productName)
                        .append("  Số lượng: ").append(orderItem.quantity)
                        .append("  Thành tiền: ").append(orderItem.getTotalPrice());

        }
 // Lấy giá trị discountAmount và finalPrice
    double discountAmount = Double.parseDouble(txtDiscountAmount.getText().replaceAll("[^\\d.]", ""));
    double finalPrice = Double.parseDouble(txtFinalPrice.getText().replaceAll("[^\\d.]", ""));

    // Thêm thông tin mã giảm giá, số tiền giảm và tổng tiền sau giảm vào orderDetails
    orderDetails.append("Mã giảm giá: ").append(txtComboID.getSelectedItem())
                .append("\nSố tiền giảm: ").append(String.format("%.3f", discountAmount))
                .append("\nTổng tiền sau giảm: ").append(String.format("%.3f", finalPrice));

    // In ra thông tin đơn hàng
    System.out.println(orderDetails.toString());

        if (orderDetails.length() > 0) {
            JOptionPane.showMessageDialog(this, "Đã xử lý thanh toán cho:\n" + orderDetails.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Không có món nào để xử lý thanh toán.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
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
        jLabel1 = new javax.swing.JLabel();
        btnthanhtoan = new javax.swing.JButton();
        tblcoffe = new javax.swing.JTabbedPane();
        jplcoffe = new javax.swing.JPanel();
        jplnuoc = new javax.swing.JPanel();
        jplthucan = new javax.swing.JPanel();
        jpltra = new javax.swing.JPanel();
        jpltall = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblthongtin = new javax.swing.JTable();
        jbltongtien = new javax.swing.JLabel();
        btnxoa = new javax.swing.JButton();
        btnxoa1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtComboID = new javax.swing.JComboBox<>();
        txtDiscountAmount = new javax.swing.JLabel();
        txtFinalPrice = new javax.swing.JLabel();
        btnclearForm = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("The Coffee");

        btnthanhtoan.setBackground(new java.awt.Color(255, 0, 51));
        btnthanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btnthanhtoan.setText("Thanh toán");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });

        jplcoffe.setLayout(new java.awt.GridLayout(1, 0));
        tblcoffe.addTab("Coffe", jplcoffe);

        jplnuoc.setLayout(new java.awt.GridLayout(1, 0));
        tblcoffe.addTab("Nước ngọt & suối", jplnuoc);

        jplthucan.setLayout(new java.awt.GridLayout(1, 0));
        tblcoffe.addTab("Thức ăn nhanh", jplthucan);

        javax.swing.GroupLayout jpltraLayout = new javax.swing.GroupLayout(jpltra);
        jpltra.setLayout(jpltraLayout);
        jpltraLayout.setHorizontalGroup(
            jpltraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        jpltraLayout.setVerticalGroup(
            jpltraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        tblcoffe.addTab("Trà ", jpltra);
        tblcoffe.addTab("all", jpltall);

        jtblthongtin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(jtblthongtin);

        jbltongtien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnxoa1.setText("Xóa 1");
        btnxoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoa1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nhập mã giảm giá:");

        txtComboID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComboIDActionPerformed(evt);
            }
        });

        txtDiscountAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtFinalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFinalPrice.setForeground(new java.awt.Color(255, 0, 51));

        btnclearForm.setBackground(new java.awt.Color(242, 242, 242));
        btnclearForm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclearForm.setText("Bỏ chọn mã giảm giá");
        btnclearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearFormActionPerformed(evt);
            }
        });

        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tblcoffe, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnInHoaDon)
                                .addGap(115, 115, 115)
                                .addComponent(btnthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnxoa1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnxoa))
                                    .addComponent(jLabel2)
                                    .addComponent(txtComboID, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnclearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiscountAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(jbltongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFinalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblcoffe)
                .addGap(3, 3, 3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbltongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnxoa1)
                        .addComponent(btnxoa)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtDiscountAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtFinalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtComboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnclearForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInHoaDon))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        processPayment();
    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
int selectedRow = jtblthongtin.getSelectedRow(); // Get the selected row index
    if (selectedRow >= 0) {
        
        orderItems.remove(selectedRow);
        updateOrderDetails(); 
        JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);     
    }
     orderItems.clear();
     updateOrderDetails(); 
    JOptionPane.showMessageDialog(this, "Đã xóa tất cả sản phẩm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnxoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoa1ActionPerformed
int selectedRow = jtblthongtin.getSelectedRow(); 
    if (selectedRow >= 0) {
        OrderItem selectedItem = orderItems.get(selectedRow);
        if (selectedItem.quantity > 1) {
          
            selectedItem.quantity--;
        } else {
           
            orderItems.remove(selectedRow);
        }
        updateOrderDetails(); // Refresh the order details
        JOptionPane.showMessageDialog(this, "Đã xóa 1 sản phẩm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Show a warning if no row is selected
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_btnxoa1ActionPerformed

    private void txtComboIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComboIDActionPerformed
    txtComboID.addItemListener(e -> {
    if (e.getStateChange() == ItemEvent.SELECTED) {
        applySelectedDiscount(); // Gọi lại hàm áp dụng giảm giá
    }
});
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComboIDActionPerformed

    private void btnclearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearFormActionPerformed
                // Tạo nút "Bỏ chọn" và thêm vào giao diện
                btnclearForm.addActionListener(e -> clearForm());
        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearFormActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        // Đường dẫn lưu file PDF
        String filePath = "D:\\FPTPoly\\KY_III\\DuAn1\\DuAn1_PhanMemBanCaPhe\\HoaDon.pdf";

        try {
            // Tạo đối tượng Document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();

            // Đường dẫn đến file font hỗ trợ Unicode
            String fontPath = "C:\\Windows\\Fonts\\times.ttf"; // Đường dẫn đến file TTF trên Windows

            // Cấu hình font
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(baseFont, 18, Font.BOLD, BaseColor.BLACK);
            Font fontInfo = new Font(baseFont, 12, Font.NORMAL, BaseColor.BLACK);
            Font fontHeader = new Font(baseFont, 12, Font.BOLD, BaseColor.WHITE);

            // Tiêu đề hóa đơn
            Paragraph title = new Paragraph("HÓA ĐƠN THANH TOÁN\n\n", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Thông tin cửa hàng
            Paragraph shopInfo = new Paragraph("The Coffee\nĐịa chỉ: Tòa T - Công viên phần mềm Quận 12\nĐiện thoại: 0339248209\n\n", fontInfo);
            shopInfo.setAlignment(Element.ALIGN_LEFT);
            document.add(shopInfo);

            // Thêm ngày giờ
            Paragraph dateTime = new Paragraph("Ngày: " + java.time.LocalDate.now() + " - Giờ: " + java.time.LocalTime.now() + "\n\n", fontInfo);
            document.add(dateTime);

            // Tạo bảng hóa đơn
            PdfPTable table = new PdfPTable(3); // 3 cột: Tên món, số lượng, giá
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Tiêu đề các cột
            PdfPCell header1 = new PdfPCell(new Phrase("Tên món", fontHeader));
            PdfPCell header2 = new PdfPCell(new Phrase("Số lượng", fontHeader));
            PdfPCell header3 = new PdfPCell(new Phrase("Giá (VND)", fontHeader));

            header1.setBackgroundColor(BaseColor.GRAY);
            header2.setBackgroundColor(BaseColor.GRAY);
            header3.setBackgroundColor(BaseColor.GRAY);

            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);

            // Dữ liệu hóa đơn
            for (OrderItem orderItem : orderItems) {
                table.addCell(new Phrase(orderItem.productName, fontInfo));
                table.addCell(new Phrase(String.valueOf(orderItem.quantity), fontInfo));
                table.addCell(new Phrase(String.valueOf(orderItem.getTotalPrice()), fontInfo));
            }

            document.add(table);

            // Tổng tiền
            double totalAmount = orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
            Paragraph total = new Paragraph("Tổng tiền: " + totalAmount + " VND", fontInfo);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            document.close();
            JOptionPane.showMessageDialog(this, "In hóa đơn thành công! File lưu tại: " + filePath);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi in hóa đơn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(Oder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Oder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Oder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Oder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Oder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnclearForm;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxoa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbltongtien;
    private javax.swing.JPanel jplcoffe;
    private javax.swing.JPanel jplnuoc;
    private javax.swing.JPanel jpltall;
    private javax.swing.JPanel jplthucan;
    private javax.swing.JPanel jpltra;
    private javax.swing.JTable jtblthongtin;
    private javax.swing.JTabbedPane tblcoffe;
    private javax.swing.JComboBox<String> txtComboID;
    private javax.swing.JLabel txtDiscountAmount;
    private javax.swing.JLabel txtFinalPrice;
    // End of variables declaration//GEN-END:variables
    // CHỨC NĂNG ÁP DỤNG MÃ GIẢM GIÁ
    private List<String> showComboData() {
    // Danh sách rỗng lưu trữ mã giảm giá đủ điều kiện
    List<String> availableDiscounts = new ArrayList<>();
    // Lấy danh sách tất cả Discount thông qua dao
    List<Discount> discounts = daoImpl.getAllData();
    // Xóa dữ liệu cũ trong comboBox
    txtComboID.removeAllItems();
    // Thêm item mặc định "Chọn mã giảm giá"
    txtComboID.addItem("");
    // Lấy tổng tiền từ jbltongtien, chuyển đổi chuỗi thành số thực để xét
    double totalPrice = extractNumericValue(jbltongtien.getText());
    // Duyệt qua danh sách và thêm idDiscount vào comboBox
    for (Discount discount : discounts) {
        // Kiểm tra trạng thái "description"
        if (!"Hoạt động".equalsIgnoreCase(discount.getDescription())) {
            continue; // Nếu trạng thái không phải "Hoạt động", bỏ qua
        }
        // Lấy điều kiện của Discount, chuyển chuỗi String sang số thực double
        String condition = discount.getCondition();
        double conditionValue = extractConditionValue(condition); // Chuyển điều kiện thành giá trị số
        // Nếu tổng tiền >= điều kiện, thêm mã giảm giá vào danh sách
        if (totalPrice >= conditionValue) {
            availableDiscounts.add(discount.getIdDiscount());
        }
    }
    // Cập nhật ComboBox với các mã giảm giá khả dụng
    for (String discountCode : availableDiscounts) {
        txtComboID.addItem(discountCode);
    }
    // Trả về danh sách mã giảm giá đủ điều kiện
    return availableDiscounts;
    }

    private double extractNumericValue(String inputText) {
        // Loại bỏ tất cả các ký tự không phải số hoặc dấu chấm
        String cleanedText = inputText.replaceAll("[^\\d.]", "");
        // Kiểm tra nếu chuỗi sau khi làm sạch rỗng
        if (cleanedText.isEmpty()) {
            return 0; // Nếu rỗng, trả về 0
        }
        // Loại bỏ dấu chấm phân cách hàng nghìn (nếu có) -> Giúp chỉ giữ lại dấu . phân cách thập phân
        cleanedText = cleanedText.replace(".", "");
        try {
            return Double.parseDouble(cleanedText); // Chuyển đổi chuỗi thành số double
        } catch (NumberFormatException e) {
            return 0; // Nếu có lỗi khi chuyển đổi, trả về 0
        }
    }
    private double extractConditionValue(String conditionText) {
        // Loại bỏ các ký tự không phải số hoặc dấu chấm
        String cleanedText = conditionText.replaceAll("[^\\d.]", "");

        // Kiểm tra nếu chuỗi sau khi làm sạch rỗng
        if (cleanedText.isEmpty()) {
            return 0; // Nếu rỗng, trả về 0
        }
        // Loại bỏ dấu chấm phân cách hàng nghìn (nếu có)
        cleanedText = cleanedText.replace(".", "");
        try {
            return Double.parseDouble(cleanedText); // Chuyển đổi chuỗi thành số double
        } catch (NumberFormatException e) {
            return 0; // Nếu có lỗi khi chuyển đổi, trả về 0
        }
    }


    // Cập nhật ComboBox với mã giảm giá khả dụng
    private void updateDiscountComboBox(double totalPrice) throws SQLException {
        // Lấy ds mã giảm giả khả dụng
        List<String> availableDiscounts = showComboData();
        // Xóa hết item trong combobox
        txtComboID.removeAllItems();
        // Thêm item mặc định "Chọn mã giảm giá"
        txtComboID.addItem("Chọn mã giảm giá");
        // Kiểm tra nếu k có mgg nào khả dụng, nếu có thêm vào combobox
        if (availableDiscounts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không có mã giảm giá nào khả dụng cho tổng tiền này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (String discountCode : availableDiscounts) {
                txtComboID.addItem(discountCode);
            }
        }

    }

    // Áp dụng mã giảm giá
    private void applySelectedDiscount() {
    String selectedDiscountCode = (String) txtComboID.getSelectedItem();
    if (selectedDiscountCode == null || selectedDiscountCode.isEmpty()) {
        return; // Nếu không chọn mã nào, không làm gì cả
    }

    // Lấy đối tượng Discount từ mã giảm giá
    Discount discount = daoImpl.getDataById(selectedDiscountCode);
    if (discount == null) {
        JOptionPane.showMessageDialog(null, "Không tìm thấy mã giảm giá đã chọn!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Chuyển đổi phần trăm giảm giá thành số thực
    double discountPercentage;
    try {
        discountPercentage = Double.parseDouble(discount.getDiscountPercentage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Phần trăm giảm giá không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Lấy tổng tiền từ jbltongtien
    double totalPrice = extractNumericValue(jbltongtien.getText());
    double discountAmount = totalPrice * (discountPercentage / 100);
    double finalPrice = totalPrice - discountAmount;

        // Cập nhật các ô label hiển thị
        txtDiscountAmount.setText("Giảm giá: "+String.format("%.3f",discountAmount));
        txtFinalPrice.setText("Tổng tiền: "+String.format("%.3f", finalPrice));
        DecimalFormat df = new DecimalFormat("#.##"); // Không hiển thị số 0 thừa
        txtDiscountAmount.setText("Giảm giá: " + df.format(discountAmount));
        txtFinalPrice.setText("Tổng tiền: " + df.format(finalPrice));

     }


        // Phương thức bỏ chọn mã giảm giá
         private void clearForm() {
         // Đặt lại item mặc định "Chọn mã giảm giá"
         txtComboID.setSelectedIndex(0); // Điều này sẽ chọn lại item đầu tiên trong ComboBox, tức là "Chọn mã giảm giá"
         txtFinalPrice.setText("");
         txtDiscountAmount.setText("");
         // Nếu bạn muốn giữ ComboBox trống thay vì chọn lại item đầu tiên, có thể dùng:
         // txtComboID.setSelectedIndex(-1);
          }
         
    
}