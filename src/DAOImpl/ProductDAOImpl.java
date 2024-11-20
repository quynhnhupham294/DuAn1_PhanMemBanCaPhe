package DAOImpl;

import DAO.DAO;
import Entity.Product; // Correctly import the Product class
import utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAOImpl implements DAO<Product, String> {

    @Override
    public List<Product> getAllData() {
        List<Product> list = new ArrayList<>();
        
        String sql = "SELECT * FROM [Product]";
        Object[] values = {};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            while (rs.next()) {
                list.add(new Product(
                        rs.getString("idProduct"),
                        rs.getString("productName"),
                        rs.getFloat("price"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("idProductType")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Product getDataById(String idProduct) {
        Product product = null;
        
        String sql = "SELECT * FROM [Product] WHERE idProduct = ?";
        Object[] values = {idProduct};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            if (rs.next()) { 
                product = new Product(
                        rs.getString("idProduct"),
                        rs.getString("productName"),
                        rs.getFloat("price"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("idProductType")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product; 
    }

    @Override
    public void insertData(Product product) {
        String sql = "INSERT INTO [Product] (idProduct, idProductName, price, image, description, idProductType) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] values = {
            product.getIdProduct(),
            product.getIdProductName(),
            product.getPrice(),
            product.getImage(),
            product.getDescription(),
            product.getIdProductType()
        };
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public void updateData(Product product) {
        String sql = "UPDATE [Product] SET idProductName=?, price=?, image=?, description=?, idProductType=? WHERE idProduct=?";
        Object[] values = {
            product.getIdProductName(),
            product.getPrice(),
            product.getImage(),
            product.getDescription(),
            product.getIdProductType(),
            product.getIdProduct()
        };
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public void deleteById(String idProduct) {
        String sql = "DELETE FROM [Product] WHERE idProduct = ?";
        Object[] values = {idProduct};
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public ArrayList<String> SelectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
