package utils;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUitl {
    public static Long sendTime =0L;
    public static Long nowTime =0L;
    public static void sendMail(String mail, String str) throws Exception {
            Properties properties = new Properties();
            properties.put("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
            properties.put("mail.smtp.port", 465);// 端口号
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
//            properties.put("mail.debug", "false");// 设置是否显示debug信息 true 会在控制台显示相关信息
            Session session = Session.getInstance(properties);
            Message message = new MimeMessage(session);
            // 设置发件人邮箱地址
            message.setFrom(new InternetAddress("1820272088@qq.com"));
            // 设置收件人邮箱地址
            message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(mail)});
            // 设置邮件标题
            message.setSubject("active account");
            // 设置邮件内容
            message.setText(str);
            // 得到邮差对象
            Transport transport = session.getTransport();
            transport.connect("1820272088@qq.com", "cwcyeunamdgbdhae");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

    }

    public static void main(String[] args) throws Exception {

    }

}
