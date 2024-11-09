// Lớp quản lý phần xác thực vai trò của User
package utils;

import Entity.User;

public class Auth {
    public static User user = null; // Tạo biến lưu trữ thông tin sau khi đăng nhập thành công
    
    // Xóa in4 user hiện tại
    public static void clear(){
        Auth.user = null;
    }  
    
    // KT có User nào đang đăng nhập hay k
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    // KT người dùng hiện tại có phải là manager hay k
    public static boolean isManager(){
        return Auth.user != null && Auth.user.isIdRole();
    }
}
