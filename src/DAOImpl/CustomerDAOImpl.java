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
    // Tạo một danh sách rỗng để lưu trữ các đối tượng Customer
    List<Customer> list = new ArrayList<>();

    // Câu lệnh SQL để lấy tất cả dữ liệu từ table Customer
    String sql = "SELECT * FROM Customer";
    
    // Mảng giá trị rỗng, vì truy vấn không cần tham số
    Object[] values = {};

    // Thực thi câu lệnh SQL và trả về kết quả dưới dạng ResultSet
    ResultSet rs = Jdbc.executeQuery(sql, values);
    
    try {
        // Duyệt qua từng hàng trong ResultSet
        while (rs.next()) {
            // Thêm một đối tượng Customer vào danh sách
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

    // Trả về list các đối tượng Customer
    return list;
}

    @Override
public Customer getDataById(String ma) {
    // Khởi tạo đối tượng Customer trống để lưu dữ liệu truy vấn 
    Customer cust = new Customer();

    // Câu lệnh SQL để lấy dữ liệu từ table Customer theo idCustomer
    String sql = "SELECT * FROM Customer WHERE idCustomer = ?";
    
    // Mảng giá trị chứa tham số cho câu lệnh SQL (idCustomer cần tìm)
    Object[] values = {ma};

    // Thực thi câu lệnh SQL và trả về kết quả dưới dạng ResultSet
    ResultSet rs = Jdbc.executeQuery(sql, values);

    try {
        // Nếu tìm thấy kết quả, gán dữ liệu vào đối tượng Customer
        while (rs.next()) {
            cust.setIdCustomer(rs.getString("idCustomer"));       
            cust.setCustomerName(rs.getString("customerName"));   
            cust.setPoint(rs.getInt("point"));                    
            cust.setPhone(rs.getString("phone"));                 
            cust.setStatus(rs.getBoolean("status"));              
            cust.setDescription(rs.getString("description"));     
        }
    } catch (SQLException ex) {
        // Ghi lại lỗi nếu có ngoại lệ xảy ra khi xử lý ResultSet
        Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Trả về đối tượng Customer chứa dữ liệu đã truy vấn 
    return cust;
}

   @Override
public void insertData(Customer o) {
    // Câu lệnh SQL để chèn dữ liệu vào table Customer
    String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?)";

    // Mảng giá trị chứa dữ liệu của đối tượng Customer để chèn vào cơ sở dữ liệu
    Object[] values = {
        o.getIdCustomer(),     
        o.getCustomerName(),   
        o.getPoint(),          
        o.getPhone(),          
        o.isStatus(),          
        o.getDescription()     
    };

    // Thực thi câu lệnh SQL để chèn dữ liệu vào cơ sở dữ liệu
    Jdbc.executeUpdate(sql, values);
}

   @Override
public void updateData(Customer o) {
    // Câu lệnh SQL để cập nhật dữ liệu của một khách hàng trong table Customer
    String sql = "UPDATE Customer SET customerName=?, point=?, phone=?, status=?, description=? WHERE idCustomer=?";

    // Mảng giá trị chứa dữ liệu cần cập nhật cho đối tượng Customer
    Object[] values = {
        o.getCustomerName(),  
        o.getPoint(),         
        o.getPhone(),         
        o.isStatus(),         
        o.getDescription(),   
        o.getIdCustomer()     
    };

    // Thực thi câu lệnh SQL để cập nhật dữ liệu trong cơ sở dữ liệu
    Jdbc.executeUpdate(sql, values);
}


    @Override
    public void deleteById(String ma) {
        String sql = """
                UPDATE [Order] SET idCustomer = NULL WHERE idCustomer = ?;
                DELETE FROM Customer WHERE idCustomer = ?;
                """;
        Object[] values = {ma, ma};
        Jdbc.executeUpdate(sql, values);
    }
}

//"UPDATE [Order] SET idCustomer = NULL WHERE idCustomer = ? " +
//                "UPDATE OrderDetail SET idOrder = NULL WHERE idOrder IN (SELECT idOrder FROM [Order] WHERE idCustomer = ?)\n" +
//                 "DELETE FROM Customer WHERE idCustomer = ?";
