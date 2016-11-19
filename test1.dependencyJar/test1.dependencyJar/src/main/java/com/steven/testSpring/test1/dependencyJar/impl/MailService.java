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
		Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.163.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");


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
        msg.setText(builder.toString());
        msg.setFrom(new InternetAddress("719527102@qq.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("gf164295903@163.comm"));
        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "719527102@qq.com", "wvvrnybafxgtbdab");

        transport.sendMessage(msg, new Address[] { new InternetAddress("gf164295903@163.com") });
        transport.close();
		
	}
}
