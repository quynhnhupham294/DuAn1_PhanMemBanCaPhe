/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Linh
 */
public class XImage {
   public static Image getAppIcon() {
    URL url = XImage.class.getResource("/src/images/anh/th.jpg"); 
    if (url == null) {
        System.err.println("Icon not found at path: /images/th.jpg");
        return null;
    }
    return new ImageIcon(url).getImage();
}

    
   public static ImageIcon read(String fileName){
        File part=new File("D:\\duan1\\DuAn1_PhanMemBanCaPhe\\src\\img",fileName); 
        return new ImageIcon(part.getAbsolutePath());
    } 
    public static void save(File src){
        File dst=new File("D:\\duan1\\DuAn1_PhanMemBanCaPhe\\src\\img", src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        try {
            Path from=Paths.get(src.getAbsolutePath());
            Path to=Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
