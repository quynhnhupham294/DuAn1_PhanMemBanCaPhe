/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImpl;

import Entity.Revenue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Jdbc;

/**
 *
 * @author Shreck
 */
public class RevenueDAOImpl {

    // Phương thức lấy tất cả dữ liệu doanh thu từ bảng V_DoanhThu
    public List<Revenue> getAllData() {

        List<Revenue> list = new ArrayList<>();

        // Câu lệnh SQL để lấy tất cả dữ liệu từ bảng V_DoanhThu, sắp xếp theo NgayLap giảm dần
        String sql = "SELECT * FROM V_DoanhThu ORDER BY NgayLap DESC";

        // Mảng giá trị không có tham số, vì câu lệnh SQL không sử dụng tham số
        Object[] values = {};

        // Thực thi câu lệnh SQL và lấy kết quả dưới dạng ResultSet
        ResultSet rs = Jdbc.executeQuery(sql, values);

        try {
            // Lặp qua từng dòng dữ liệu trong ResultSet và tạo đối tượng Revenue từ dữ liệu đó
            while (rs.next()) {
                // Thêm đối tượng Revenue vào danh sách với dữ liệu từ ResultSet
                list.add(new Revenue(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("TenLoai"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("Gia"),
                        rs.getDouble("TongTien"),
                        rs.getDate("NgayLap")
                ));
            }
        } catch (SQLException ex) {

            Logger.getLogger(RevenueDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Trả về LIST chứa các đối tượng Revenue đã được tạo
        return list;
    }

    public List<Revenue> getDataByValue(String value) {

        List<Revenue> list = new ArrayList<>();

        // Câu lệnh SQL để lấy dữ liệu từ bảng V_DoanhThu, lọc theo tên sản phẩm chứa VALUE và sắp xếp theo NgayLap giảm dần
        String sql = "SELECT * FROM V_DoanhThu "
                + "WHERE TenSanPham LIKE ? ORDER BY NgayLap DESC";

        // Mảng giá trị chứa tham số VALUE với ký tự % bao quanh để tìm kiếm theo kiểu LIKE (tìm kiếm không phân biệt trước sau)
        Object[] values = {"%" + value + "%"};

        // Thực thi câu lệnh SQL và lấy kết quả dưới dạng ResultSet
        ResultSet rs = Jdbc.executeQuery(sql, values);

        try {
            // Lặp qua từng dòng dữ liệu trong ResultSet và tạo đối tượng Revenue từ dữ liệu đó
            while (rs.next()) {
                // Thêm đối tượng Revenue vào danh sách với dữ liệu từ ResultSet
                list.add(new Revenue(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("TenLoai"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("Gia"),
                        rs.getDouble("TongTien"),
                        rs.getDate("NgayLap")
                ));
            }
        } catch (SQLException ex) {

            Logger.getLogger(RevenueDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Trả về LIST chứa các đối tượng Revenue đã được tạo
        return list;
    }

    public List<Integer> getYear() {

        List<Integer> year = new ArrayList<>();

        // Câu lệnh SQL để lấy các năm độc nhất từ cột NgayLap trong bảng V_DoanhThu
        // Dùng DISTINCT để lọc ra các năm khác nhau, sắp xếp theo năm giảm dần
        String sql = "SELECT DISTINCT YEAR(NgayLap) as Nam FROM V_DoanhThu "
                + "ORDER BY Nam DESC";

        Object[] values = {};

        // Thực thi câu lệnh SQL và lấy kết quả dưới dạng ResultSet
        ResultSet rs = Jdbc.executeQuery(sql, values);

        try {

            while (rs.next()) {
                // Thêm năm vào danh sách year
                year.add(rs.getInt("Nam"));
            }
        } catch (SQLException ex) {

            Logger.getLogger(RevenueDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Trả về LIST các năm
        return year;
    }

    public List<Revenue> getDataByValue(String value1, String value2, int value3) {

        List<Revenue> list = new ArrayList<>();

        // Câu lệnh SQL để lấy dữ liệu từ bảng V_DoanhThu, lọc theo tên sản phẩm, tên loại, và năm
        // Dùng LIKE cho cả tên sản phẩm và tên loại, và sử dụng giá trị năm (value3) để lọc theo năm
        String sql = "SELECT * FROM V_DoanhThu "
                + "WHERE TenSanPham LIKE ? AND TenLoai LIKE ? AND YEAR(NgayLap) = ? "
                + "ORDER BY NgayLap DESC";

        // Mảng giá trị chứa các tham số: tên sản phẩm, tên loại và năm
        Object[] values = {
            "%" + value1 + "%", // Tìm kiếm tên sản phẩm chứa 'value1'
            "%" + value2 + "%", // Tìm kiếm tên loại chứa 'value2'
            value3 // Lọc theo năm 'value3'
        };

        // Thực thi câu lệnh SQL và lấy kết quả dưới dạng ResultSet
        ResultSet rs = Jdbc.executeQuery(sql, values);

        try {

            while (rs.next()) {

                list.add(new Revenue(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("TenLoai"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("Gia"),
                        rs.getDouble("TongTien"),
                        rs.getDate("NgayLap")
                ));
            }
        } catch (SQLException ex) {

            Logger.getLogger(RevenueDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Trả về LIST chứa các đối tượng Revenue đã được tạo
        return list;
    }

    public List<Revenue> getDataByValue(String value1, String value2) {

        List<Revenue> list = new ArrayList<>();

        // Câu lệnh SQL để lấy dữ liệu từ bảng V_DoanhThu, lọc theo tên sản phẩm và tên loại
        // Sử dụng LIKE cho cả tên sản phẩm và tên loại để tìm kiếm theo chuỗi chứa các giá trị value1 và value2
        String sql = "SELECT * FROM V_DoanhThu "
                + "WHERE TenSanPham LIKE ? AND TenLoai LIKE ? "
                + "ORDER BY NgayLap DESC";

        // Mảng giá trị chứa các tham số: tên sản phẩm và tên loại
        Object[] values = {
            "%" + value1 + "%", // Tìm kiếm tên sản phẩm chứa 'value1'
            "%" + value2 + "%" // Tìm kiếm tên loại chứa 'value2'
        };

        // Thực thi câu lệnh SQL và lấy kết quả dưới dạng ResultSet
        ResultSet rs = Jdbc.executeQuery(sql, values);

        try {
            // Lặp qua từng dòng dữ liệu trong ResultSet và tạo đối tượng Revenue từ dữ liệu đó
            while (rs.next()) {
                // Thêm đối tượng Revenue vào danh sách
                list.add(new Revenue(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("TenLoai"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("Gia"),
                        rs.getDouble("TongTien"),
                        rs.getDate("NgayLap")
                ));
            }
        } catch (SQLException ex) {

            Logger.getLogger(RevenueDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Trả về LIST chứa các đối tượng Revenue đã được tạo
        return list;
    }

}
