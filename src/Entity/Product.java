package Entity;

public class Product {
    private String idProduct;
    private String idProductName;
    private float price;
    private String image;
    private String description;
    private String idProductType;

    public Product() {
    }

    public Product(String idProduct, String idProductName, float price, String image, String description, String idProductType) {
        this.idProduct = idProduct;
        this.idProductName = idProductName;
        this.price = price;
        this.image = image;
        this.description = description;
        this.idProductType = idProductType;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdProductName() {
        return idProductName;
    }

    public void setIdProductName(String idProductName) {
        this.idProductName = idProductName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(String idProductType) {
        this.idProductType = idProductType;
    }
    
    
}
