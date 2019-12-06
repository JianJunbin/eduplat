package com.team05.eduplat.utils.user;

import com.team05.eduplat.entity.vo.user.EmailVo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @program: eduplat
 * @description: 用户模块帮助类
 * @author: chen wenliang
 * @Date 2019/11/25
 **/
public class UserUtil {
    public static String passwordEcode(String password){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    //比较两个密码是否相同，第一个不加密，第二个加密
    public static boolean passwordIsSame(String password,String encodePassword){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        if (encoder.matches(password,encodePassword)){
            System.out.println("true");
            return true;
        }else {
            System.out.println("false");
            return false;
        }
    }
    //发邮件
    public static boolean emailSend(EmailVo emailVo){
        try {
            //配置文件
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.host", emailVo.getHost());
            properties.put("mail.smtp.port", 25);
            properties.put("mail.smtp.starrttls.enable", "true");
            //创建会话
            VerifyEmailAuthentication verifyEmailAuthentication = new VerifyEmailAuthentication(emailVo.getUserName(),emailVo.getPassword());
            Session mailSession = Session.getInstance(properties, verifyEmailAuthentication);
//            mailSession.setDebug(true);
            //创建信息对象
            Message message = new MimeMessage(mailSession);
            InternetAddress from = new InternetAddress(emailVo.getFromAddress());
            InternetAddress to = new InternetAddress(emailVo.getToAddress());
            //设置邮件信息的来源
            message.setFrom(from);
            //设置邮件的接收者
            message.setRecipient(MimeMessage.RecipientType.TO, to);
            message.setSubject(emailVo.getSubject());
            //设置邮件发送日期
            message.setSentDate(new Date());
            //设置邮件内容
            message.setText(emailVo.getContext());
            message.saveChanges();
            //发送邮件
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(emailVo.getHost(),emailVo.getUserName(), emailVo.getPassword());
            System.out.println("发送:" + transport);
            transport.sendMessage(message, message.getAllRecipients());
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("dddd");
            return false;
        }
    }

    private static int width = 110;// 定义图片的width
    private static int height = 30;// 定义图片的height
    private static int codeCount = 4;// 定义图片上显示验证码的个数
    private static int fontHeight = 25;
    private static  int codeY = 23;
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    public static Map<String,Object> generateCodeAndPic() {
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics gd = buffImg.getGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.BLUE);
        gd.fillRect(0, 0, width, height);
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // 设置字体。
        gd.setFont(font);
        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);

        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(25);
            int yl = random.nextInt(25);
            gd.drawLine(x, y, x + xl, y + yl);
        }

        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证
        StringBuffer randomCode = new StringBuffer();

        // 随机产生codeCount数字的验证码
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            // 用随机产生的颜色将验证码绘制到图像中
            gd.setColor(new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255)));
            gd.drawString(code, (i+1)*(width/6), codeY);
            // 将产生的四个随机数组合在一起
            randomCode.append(code);
        }
        Map<String, Object> map = new HashMap<>();
        //存放验证码
        map.put("code", randomCode);
        //存放生成的验证码BufferedImage对象
        map.put("codeImg", buffImg);
        return map;
    }
    //时间格式化
    public static String DateToString(Date time){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(time);
    }

}
