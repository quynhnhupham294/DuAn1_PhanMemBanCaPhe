package Entity;

public class Customer {
    private String idCustomer;
    private String customerName;
    private int point;
    private String phone;
    private boolean status;
    private String description;

    public Customer() {
    }

    
    public Customer(String idCustomer, String customerName, int point, String phone, boolean status, String description) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.point = point;
        this.phone = phone;
        this.status = status;
        this.description = description;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", customerName=" + customerName + ", point=" + point + ", phone=" + phone + ", status=" + status + ", description=" + description + '}';
    }
    
}
