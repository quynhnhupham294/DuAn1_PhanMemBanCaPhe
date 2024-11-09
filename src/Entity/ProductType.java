package Entity;

public class ProductType {
    private String idProductType;
    private String productTypeName;
    private String description;

    public ProductType() {
    }

    public ProductType(String idProductType, String productTypeName, String description) {
        this.idProductType = idProductType;
        this.productTypeName = productTypeName;
        this.description = description;
    }

    public String getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(String idProductType) {
        this.idProductType = idProductType;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
