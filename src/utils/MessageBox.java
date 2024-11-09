// Lớp hiển thị thông báo các hộp thoại: cảnh báo, xác nhận, nhập liệu
package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageBox {
    
    // Thông báo cảnh báo
    public static void alert(Component parent, String messager) {
        JOptionPane.showMessageDialog(parent, messager, "Hệ thống quản lý...", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Thông báo xác nhận
    public static boolean Confirm(Component parent,String messager){
        int result =JOptionPane.showConfirmDialog(parent, messager,"Hệ thống quản lý đào tạo",JOptionPane.YES_NO_OPTION);
        return result==JOptionPane.YES_OPTION;
    }
    
    // Thông báo nhập liệu
    public static void prompt(Component parent,String messager){
        JOptionPane.showInputDialog(parent, messager, "Hệ thống quản lý...", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
