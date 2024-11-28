/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImpl;

import DAO.DAO;
import Entity.Discount;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author thing
 */
public class DiscountDAOImpl implements DAO<Discount, String>{
    // Lấy dl
    @Override
    public List<Discount> getAllData() {
        List<Discount> list = new ArrayList<>();
        String sql = "SELECT * FROM Discount";
        Object[] values = {};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            while (rs.next()) {
                list.add(new Discount(
                        rs.getString("idDiscount"),
                        rs.getString("dateStart"),
                        rs.getString("dateEnd"),
                        rs.getString("nameDiscount"),
                        rs.getString("condition"),
                        rs.getString("discountPercentage"),
                        rs.getString("description"),
                        rs.getString("note")
    
                ));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DiscountDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return list;
    }
    // Lấy dl bằng ID
    @Override
    public Discount getDataById(String idDiscount) {
         Discount discount = null;
        
        String sql = "SELECT * FROM Discount WHERE idDiscount= ?";
        Object[] values = {idDiscount};
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            if (rs.next()) {
                discount = new Discount(
                        rs.getString("idDiscount"),
                        rs.getString("dateStart"),
                        rs.getString("dateEnd"),
                        rs.getString("nameDiscount"),
                        rs.getString("condition"),
                        rs.getString("discountPercentage"),
                        rs.getString("description"),
                        rs.getString("note")
                );
            }
        } catch (SQLException ex) {
           java.util.logging.Logger.getLogger(DiscountDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return discount;
    }
    
    
    //Thêm chương trình khuyến mãi
    @Override
    public void insertData(Discount discount) {
    String sql = "INSERT INTO Discount (idDiscount, dateStart, dateEnd, nameDiscount, condition, discountPercentage, description, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    Object[] values = {
        discount.getIdDiscount(),
        discount.getDateStart(),
        discount.getDateEnd(),
        discount.getNameDiscount(),
        discount.getCondition(),
        discount.getDiscountPercentage(),
        discount.getDescription(),
        discount.getNote()
    };
    Jdbc.executeUpdate(sql, values);
    }

//    Cập nhật dl
    @Override
    public void updateData(Discount discount) {
        String sql = "UPDATE Discount SET dateStart=?, dateEnd=?, nameDiscount=?, condition=?, discountPercentage=?, description=?, note=? WHERE idDiscount=?";
        Object[] values = {
            discount.getDateStart(),
            discount.getDateEnd(),
            discount.getNameDiscount(),
            discount.getCondition(),
            discount.getDiscountPercentage(),
            discount.getDescription(),
            discount.getNote(),
            discount.getIdDiscount()
        };
         Jdbc.executeUpdate(sql, values);
    }
//    id
    @Override
    public void deleteById(String idDiscount) {
        String sql = "DELETE FROM Discount WHERE idDiscount = ?";
        Object[] values = {idDiscount};
        Jdbc.executeUpdate(sql, values);
    }

}
