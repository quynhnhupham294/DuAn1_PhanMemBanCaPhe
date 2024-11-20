/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Jdbc;
import Entity.ProductType;
/**
 *
 * @author Shreck
 */
public class ProductTypeDAOImpl {
     public List<ProductType> getAllData() {
       List<ProductType> list = new ArrayList<>();
       
       String sql = "Select * from ProductType";
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
}
