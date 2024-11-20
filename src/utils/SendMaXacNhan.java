package utils;

import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMaXacNhan {
    public static void sendMail (String to, String maXacNhan) {
        final String from = "phamnhuquynh294@gmail.com";
        final String password = "htjw gzbh lcxz gbhh";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        // Tạo lớp xác thực tài khoản khi kết nối với máy chủ email
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        
        // Phiên làm việc
        Session session = Session.getInstance(prop, auth);
        
        // Gửi email + tạo message
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; Charset=UTF-8");
            //Nguoi Gui
            msg.setFrom(new InternetAddress(from));
            //Nguoi Nhan
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject("Mã xác nhận của Phần mềm bán cà phê là :");
            msg.setSentDate(new Date());
            msg.setText("Mã xác nhận của bạn là: " + maXacNhan, "UTF-8");
            Transport.send(msg);
            System.out.println("Thanh Cong");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    // Check email bằng biểu thức chính quy
    public static boolean isEmail(String email) {
        String regex = "^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,5}+([.][a-zA-Z]+){1,3}$";
        Pattern pt = Pattern.compile(regex);
        Matcher mat = pt.matcher(email);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
}
