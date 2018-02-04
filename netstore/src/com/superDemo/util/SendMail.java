package com.superDemo.util;

import com.superDemo.domain.Customer;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail extends Thread{
    private Customer c;

    public SendMail(Customer c){
        this.c = c;
    }

    @Override
    public void run() {
        try{
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");//指定邮件发送的协议，参数是规范规定的
            props.setProperty("mail.host", "smtp.163.com");//指定发件服务器的地址，参数是规范规定的
//		    props.setProperty("mail.debug", "true");//邮件发送的调试模式，参数是规范规定的
            props.setProperty("mail.smtp.auth", "true");//请求服务器进行身份认证。参数与具体的JavaMail实现有关
            Session session = Session.getInstance(props);
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("superCodingssssss@163.com"));
            message.setRecipients(Message.RecipientType.TO, c.getEmail());
            message.setSubject("来自XX网站的激活邮件");

            message.setContent("亲爱的"+c.getUsername()+"<br/>感谢您注册成为我们的会员，请猛戳下面激活您的账户。<br/><a href='http://localhost:8080/day23_00_netstore/ClientServlet?op=active&code="+c.getCode()+"'>戳这里</a><br/>本邮件由系统自动发出，请不要直接回复。", "text/html;charset=UTF-8");
            message.saveChanges();

            Transport ts = session.getTransport();
            ts.connect("superCodingssssss", "842499467");
            ts.sendMessage(message, message.getAllRecipients());
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
