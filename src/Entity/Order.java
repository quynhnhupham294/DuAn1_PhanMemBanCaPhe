package Entity;

public class Order {
    private String idOrder;
    private String dateTimeOrder;
    private String description;
    private String idUser;
    private String idCustomer;
    private String idDiscount;

    public Order() {
    }

    public Order(String idOrder, String dateTimeOrder, String description, String idUser, String idCustomer, String idDiscount) {
        this.idOrder = idOrder;
        this.dateTimeOrder = dateTimeOrder;
        this.description = description;
        this.idUser = idUser;
        this.idCustomer = idCustomer;
        this.idDiscount = idDiscount;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(String dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }
    
    
}
