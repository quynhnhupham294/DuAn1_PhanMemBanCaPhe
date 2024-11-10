package DAOImpl;

import DAO.DAO;
import Entity.User; // Tạo lớp User trong package Entity
import utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl implements DAO<User, String> {

    @Override
    public List<User> getAllData() {
        List<User> list = new ArrayList<>();
        
        String sql = "SELECT * FROM [User]";
        Object[] values = {};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            while (rs.next()) {
                list.add(new User(
                        rs.getString("idUser"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("description"),
                        rs.getBoolean("idRole") // Quyền hạn (Admin/Staff)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User getDataById(String username) {
        User user = null;
        
        String sql = "SELECT * FROM [User] WHERE userName = ?";
        Object[] values = {username};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            if (rs.next()) { // Chỉ cần một bản ghi
                user = new User(
                        rs.getString("idUser"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("description"),
                        rs.getBoolean("idRole")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user; // Trả về null nếu không tìm thấy
    }

    @Override
    public void insertData(User user) {
        String sql = "INSERT INTO [User] VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {
            user.getIdUser(),
            user.getUserName(),
            user.getPassword(),
            user.getPhone(),
            user.getAddress(),
            user.getDescription(),
            user.isIdRole() // Quyền hạn
        };
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public void updateData(User user) {
        String sql = "UPDATE [User] SET userName=?, password=?, phone=?, address=?, description=?, idRole=? WHERE idUser=?";
        Object[] values = {
            user.getUserName(),
            user.getPassword(),
            user.getPhone(),
            user.getAddress(),
            user.getDescription(),
            user.isIdRole(),
            user.getIdUser()
        };
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public void deleteById(String idUser) {
        String sql = "DELETE FROM [User] WHERE idUser = ?";
        Object[] values = {idUser};
        Jdbc.executeUpdate(sql, values);
    }

    @Override
    public ArrayList<String> SelectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
