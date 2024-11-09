package Entity;

public class OrderDetail {
    private String idOrderDetail;
    private int quantity;
    private boolean status;
    private String description;
    private String idOrder;
    private String idProduct;

    public OrderDetail() {
    }

    public OrderDetail(String idOrderDetail, int quantity, boolean status, String description, String idOrder, String idProduct) {
        this.idOrderDetail = idOrderDetail;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
    }

    public String getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(String idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
    
    
}
