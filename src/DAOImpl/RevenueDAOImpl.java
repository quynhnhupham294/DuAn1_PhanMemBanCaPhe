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
    
    public List<Revenue> getAllData() {
        List<Revenue> list = new ArrayList<>();
        String sql = "SELECT * FROM V_DoanhThu ORDER BY NgayLap DESC";
        Object[] values = {};
        
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
        
        return list;
    }
    
    
    public List<Revenue> getDataByValue(String value) {
        List<Revenue> list = new ArrayList<>();
        String sql = "SELECT  * FROM V_DoanhThu "
                + "Where TenSanPham like ? ORDER BY NgayLap DESC";
        Object[] values = {"%" + value + "%"};
        
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
        
        return list;
    }
    
    public List<Integer> getYear() {
        List<Integer> year = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(NgayLap) as Nam FROM V_DoanhThu "
                + "ORDER BY Nam DESC";
        Object[] values = {};
        
        ResultSet rs = Jdbc.executeQuery(sql, values);
        
        try {
            while (rs.next()) {
                year.add(rs.getInt("Nam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RevenueDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return year;
    }
    
    public List<Revenue> getDataByValue(String value1, String value2, int value3) {
        List<Revenue> list = new ArrayList<>();
        String sql = "SELECT  * FROM V_DoanhThu "
                + "Where TenSanPham like ? and TenLoai like ? and Year(NgayLap) = ?"
                + "ORDER BY NgayLap DESC";
        Object[] values = {
            "%" + value1 + "%",
            "%" + value2 + "%",
            value3
        };
        
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
        
        return list;
    }
    
    public List<Revenue> getDataByValue(String value1, String value2) {
        List<Revenue> list = new ArrayList<>();
        String sql = "SELECT  * FROM V_DoanhThu "
                + "Where TenSanPham like ? and TenLoai like ?"
                + "ORDER BY NgayLap DESC";
        Object[] values = {
            "%" + value1 + "%",
            "%" + value2 + "%",
        };
        
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
        
        return list;
    }
}


