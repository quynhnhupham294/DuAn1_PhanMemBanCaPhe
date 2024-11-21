/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAOImpl.ProductDAOImpl;
import Entity.Product;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author vuthe
 */
public class Oder extends javax.swing.JFrame {
    ProductDAOImpl dao =new ProductDAOImpl();
    private List<OrderItem> orderItems = new ArrayList<>();
    /**
     * 
     */
    public Oder() {
        initComponents();
        form();
        loadProductData1();
        
        
       
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
                case 2: return String.format("%.2f", item.price); // Giá
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
        jbltongtien.setText("Tổng số tiền: " + String.format("%.2f", totalPrice));
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
    JLabel productPrice = new JLabel(String.format("Giá: %.2f", product.getPrice()));
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
            orderDetails.append(orderItem.productName)
                        .append(" - Số lượng: ").append(orderItem.quantity)
                        .append(" - Giá: ").append(orderItem.getTotalPrice())
                        .append("\n");
        }
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("The Coffee");

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
            .addGap(0, 557, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbltongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnthanhtoan)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnxoa1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnxoa)))
                                .addGap(21, 21, 21))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnxoa)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnxoa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jbltongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnthanhtoan)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblcoffe)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxoa1;
    private javax.swing.JLabel jLabel1;
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
    // End of variables declaration//GEN-END:variables
}
