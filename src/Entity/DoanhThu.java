/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Shreck
 */
public class DoanhThu {
    private String idProduct;
    private String productName;
    private int quantity;
    private double donGia;

    public DoanhThu(String string, short aShort, short aShort1) {
    }

    public DoanhThu(String idProduct, String productName, int quantity, double donGia) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.quantity = quantity;
        this.donGia = donGia;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
