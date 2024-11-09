package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost;database=phanmembanhang;encrypt=true;trustServerCertificate=true;";
    private static final String USERNAME = "DuAn1";
    private static final String PASSWORD = "123";

    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                System.out.println("Connect success!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static PreparedStatement createPreparedStatement(String sql, Object... values) {
        try {
            PreparedStatement ps = null;
            if(sql.trim().startsWith("{")){
                ps = Jdbc.getConnection().prepareCall(sql);
            } else {
                ps = Jdbc.getConnection().prepareStatement(sql);
            }
            for (int i = 0; i < values.length; i++) { // set Parameters
                ps.setObject(i + 1, values[i]);
            }
            return ps;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Thực thi câu lệnh SQL thao tác dữ liệu (INSERT, UPDATE, DELETE)
     * @param sql câu lệnh SQL chưa ?
     * @param values các giá trị thay thế vào ?
     * @return số lượng bản ghi đã thao tác
     */
    public static int executeUpdate(String sql, Object... values) {
        PreparedStatement ps = Jdbc.createPreparedStatement(sql, values);
        try {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Thực thi câu lệnh SQL truy vấn dữ liệu (SELECT)
     * @param sql câu lệnh SQL chưa ?
     * @param values các giá trị thay thế vào ?
     * @return kết quả truy vấn (ResultSet)
     */
    public static ResultSet executeQuery(String sql, Object... values) {
        PreparedStatement ps = Jdbc.createPreparedStatement(sql, values);
        try {
            return ps.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Thực thi câu lệnh thao SQL truy vấn 1 giá trị
     * @param sql câu lệnh SQL chứa ?
     * @param values các giá trị thay thế vào ?
     * @return giá trị truy vấn được
     */
    public static <T> T getValue(String sql, Object... values) {
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            rs.next();
            return (T) rs.getObject(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}