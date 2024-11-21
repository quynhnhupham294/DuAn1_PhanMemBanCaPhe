/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Shreck
 */
public class Revenue {
    private String idProduct;
    private String productName;
    private String productNameType;
    private int quantity;
    private double price;
    private double totalMoney;
    private Date dateTimeOrder;

    public Revenue() {
    }

    public Revenue(String idProduct, String productName, String productNameType, int quantity, double price, double totalMoney, Date dateTimeOrder) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productNameType = productNameType;
        this.quantity = quantity;
        this.price = price;
        this.totalMoney = totalMoney;
        this.dateTimeOrder = dateTimeOrder;
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

    public String getProductNameType() {
        return productNameType;
    }

    public void setProductNameType(String productNameType) {
        this.productNameType = productNameType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(Date dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    
}