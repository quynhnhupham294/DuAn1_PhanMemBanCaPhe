package DAOImpl;

import DAO.DAO;
import Entity.ProductType; // Correctly import the ProductType class
import utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductTypeDAOImpl implements DAO<ProductType, String> {

    @Override
    public List<ProductType> getAllData() {
        List<ProductType> list = new ArrayList<>();
        
        String sql = "SELECT * FROM [ProductType]";
        Object[] values = {};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString("idProductType"),
                        rs.getString("productTypeName"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ProductType getDataById(String idProductType) {
        ProductType productType = null;
        
        String sql = "SELECT * FROM [ProductType] WHERE idProductType = ?";
        Object[] values = {idProductType};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            if (rs.next()) {
                productType = new ProductType(
                        rs.getString("idProductType"),
                        rs.getString("productTypeName"),
                        rs.getString("description")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productType;
    }

    @Override
    public void insertData(ProductType productType) {
        String sql = "INSERT INTO [ProductType] (idProductType, productTypeName, description) VALUES (?, ?, ?)";
        Object[] values = {
            productType.getIdProductType(),
            productType.getProductTypeName(),
            productType.getDescription()
        };
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public void updateData(ProductType productType) {
        String sql = "UPDATE [ProductType] SET productTypeName=?, description=? WHERE idProductType=?";
        Object[] values = {
            productType.getProductTypeName(),
            productType.getDescription(),
            productType.getIdProductType()
        };
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public void deleteById(String idProductType) {
        String sql = "DELETE FROM [ProductType] WHERE idProductType = ?";
        Object[] values = {idProductType};
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public ArrayList<String> SelectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
