/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImpl;
import DAO.DAO;
import Entity.Customer;
import utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shreck
 */
public class CustomerDAOImpl implements DAO<Customer, String> {

    @Override
    public List<Customer> getAllData() {
        List<Customer> list  = new ArrayList<>();
        
        String sql = "SELECT * FROM Customer";
        Object[] values = {};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            while (rs.next()) {
                list.add(new Customer(
                        rs.getString("idCustomer"),
                        rs.getString("customerName"),
                        rs.getInt("point"),
                        rs.getString("phone"),
                        rs.getBoolean("status"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Customer getDataById(String ma) {
        Customer cust = new Customer();
        
        String sql = "SELECT * FROM Customer WHERE =?";
        Object[] values = {ma};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            while (rs.next()) {
                cust.setIdCustomer(rs.getString("idCustomer"));
                cust.setCustomerName(rs.getString("customerName"));
                cust.setPoint(rs.getInt("point"));
                cust.setPhone(rs.getString("phone"));
                cust.setStatus(rs.getBoolean("status"));
                cust.setDescription(rs.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  cust;
    }

    @Override
    public void insertData(Customer o) {
       String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?)";
    }

    @Override
    public void updateData(Customer o) {
     
    }

    @Override
    public void deleteById(String ma) {
        String sql ="DELETE FROM Customer WHERE idCustomer =?";
        Object[] values = {ma};
        Jdbc.executeUpdate(sql, values);
    }
    
}
