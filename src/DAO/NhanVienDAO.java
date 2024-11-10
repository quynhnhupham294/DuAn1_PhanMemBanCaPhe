package DAO;

import Entity.User;
import java.util.List;

public interface NhanVienDAO{
    /**
     * Truy vấn nhân viên
     * @param sql Câu lệnh truy vấn SQL
     * @param values Dữ liệu cung cấp cho các dấu hỏi bên trong câu lệnh SQL
     * @return Danh sách các thực thể truy vấn được
     */
    List<User> find(String sql,Object...args);
    /**
     * Truy vấn tất cả nhân viên
     * @return Danh sách các thực thể truy vấn được
     */
    List<User> findAll();
    /**
     * Truy vấn nhân viên theo MaNV
     * @param id mã nhân viên cần truy vấn
     * @return Thực thể truy vấn được
     */
    User findById(String id);
    /**
     * Tạo nhân viên mới
     * @param entity thực thể chứa dữ liệu cần thêm mới
     * @return Thực thể sau khi đã thêm vào CSDL
     */
    User create(User entity);
    /**
     * Cập nhật nhân viên
     * @param entity thực thể chứa dữ liệu cần cập nhật
     * @return Thực thể sau khi đã cập nhật
     */
    User update(User entity);
    /**
     * Xóa nhân viên theo mã
     * @param id mã nhân viên cần xóa
     */
    void deleteById(String id);
}
