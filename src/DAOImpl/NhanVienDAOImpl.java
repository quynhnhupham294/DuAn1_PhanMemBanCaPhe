package DAOImpl;

import DAO.NhanVienDAO;
import Entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Jdbc;

public class NhanVienDAOImpl implements NhanVienDAO{ 
    String sqlSelectAll = "SELECT * FROM [User]"; // find
    String sqlSelectID = "SELECT * FROM [User] WHERE idUser = ?"; // findById
    String sqlInsert = "INSERT INTO [User](idUser, userName, password, phone, address, description, email, idRole)"
                     + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    String sqlUpdate = "uPDATE [User] SET userName = ?, password = ?, phone = ?, address = ?, deUPDATE [User] SET userName = ?, password = ?, phone = ?, address = ?, description = ?, email = ?, idRole = ? WHERE idUser = ?";
    String sqlDelete = "DELETE FROM [User] WHERE idUser = ?";
    
    @Override
    public List<User> find(String sql, Object... args) {
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = Jdbc.executeQuery(sql, args);
            while(rs.next()) {
                User nv = new User();
                nv.setIdUser(rs.getString("idUser"));
                nv.setUserName(rs.getString("userName"));
                nv.setPassword(rs.getString("password"));
                nv.setPhone(rs.getString("phone"));
                nv.setAddress(rs.getString("address"));
                nv.setDescription(rs.getString("description"));
                nv.setEmail(rs.getString("email"));
                nv.setIdRole(rs.getBoolean("idRole"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    
    @Override
    public List<User> findAll() {
        return find(sqlSelectAll);
    }

    @Override
    public User findById(String id) {
        List<User> list = find(sqlSelectID, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public User create(User entity) {
        Jdbc.executeUpdate(sqlInsert,
            entity.getIdUser(),
            entity.getUserName(),
            entity.getPassword(),
            entity.getPhone(),
            entity.getAddress(),
            entity.getDescription(), 
            entity.getEmail(),
            entity.isIdRole()? 1 : 0);
        return entity;
    }

    @Override
    public User update(User entity) {
        Jdbc.executeUpdate(sqlUpdate,
            entity.getUserName(),
            entity.getPassword(),
            entity.getPhone(),
            entity.getAddress(),
            entity.getDescription(), 
            entity.getEmail(),
            entity.isIdRole()? 1 : 0,
            entity.getIdUser());
        return entity;
    }

    @Override
    public void deleteById(String id) {
        Jdbc.executeUpdate(sqlDelete, id);
    }
    
//    @Override
//    public List<User> findAllFormQLTK() {
//        return find(sqlSelectAll);
//    }
}
