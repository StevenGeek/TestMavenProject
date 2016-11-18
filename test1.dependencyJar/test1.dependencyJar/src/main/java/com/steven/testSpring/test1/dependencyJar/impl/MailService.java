package com.steven.testSpring.test1.dependencyJar.impl;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.steven.testSpring.test1.dependencyJar.IMailService;
import com.sun.mail.util.MailSSLSocketFactory;
@Component
public class MailService implements IMailService {
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	@Override
	public void send() throws GeneralSecurityException, AddressException, MessagingException {
//		// Recipient's email ID needs to be mentioned.
//	      String to = "gf164295903@163.com";
//
//	      // Sender's email ID needs to be mentioned
//	      String from = "719527102@qq.com";
//
//	      // Assuming you are sending email from localhost
//	      String host = "localhost";
//
//	      // Get system properties
//	      Properties properties = System.getProperties();
//
//	      // Setup mail server
//	      properties.setProperty("mail.debug", "true");
//	      properties.setProperty("mail.smtp.host", "smtp.qq.com");
//	      properties.setProperty("mail.smtp.port", "465");
//	      properties.setProperty("mail.smtp.socketFactory.port", "465");
//	      properties.put("mail.smtp.auth", "true");
//	      properties.put("mail.debug", "true");
//	      properties.put("mail.store.protocol", "pop3");
//	      properties.put("mail.transport.protocol", "smtp");
//	      MailSSLSocketFactory sf = new MailSSLSocketFactory();
//	      sf.setTrustAllHosts(true);
//	      properties.put("mail.smtp.ssl.enable", "true");
//	      properties.put("mail.smtp.ssl.socketFactory", sf);
//	      // Get the default Session object.
//	      Session session = Session.getDefaultInstance(properties,new Authenticator() {
//	    	  protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("719527102@qq.com", "wvvrnybafxgtbdab");
//			}
//		});
//
//	      try {
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//	         // Set Subject: header field
//	         message.setSubject("This is the Subject Line!");
//
//	         // Now set the actual message
//	         message.setText("This is actual message");
//
//	         // Send message
//	         Transport.send(message);
//	         System.out.println("Sent message successfully....");
//	      }catch (MessagingException mex) {
//	         mex.printStackTrace();
//	      }	
		Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.163.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

//        MailSSLSocketFactory sf = new MailSSLSocketFactory();
//        sf.setTrustAllHosts(true);
//        props.put("mail.smtp.ssl.enable", "true");
//        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        Message msg = new MimeMessage(session);
        msg.setSubject("seenews 错误");
        StringBuilder builder = new StringBuilder();
        builder.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
        builder.append("\n页面爬虫错误");
//        builder.append("\n时间 " + TimeTool.getCurrentTime());
        msg.setText(builder.toString());
        msg.setFrom(new InternetAddress("gf164295903@163.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("719527102@qq.com"));
        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", "gf164295903@163.com", "hjgs343ll");

        transport.sendMessage(msg, new Address[] { new InternetAddress("719527102@qq.com") });
        transport.close();
	      }
	@Override
	public void sendQQMail() throws Exception {
		Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        Message msg = new MimeMessage(session);
        msg.setSubject("seenews 错误");
        StringBuilder builder = new StringBuilder();
        builder.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
        builder.append("\n页面爬虫错误");
//        builder.append("\n时间 " + TimeTool.getCurrentTime());
        msg.setText(builder.toString());
        msg.setFrom(new InternetAddress("719527102@qq.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("gf164295903@163.comm"));
        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "719527102@qq.com", "wvvrnybafxgtbdab");

        transport.sendMessage(msg, new Address[] { new InternetAddress("gf164295903@163.com") });
        transport.close();
		
	}
	    @Autowired
	    @Qualifier("sender")
	    private JavaMailSender sender;
}
