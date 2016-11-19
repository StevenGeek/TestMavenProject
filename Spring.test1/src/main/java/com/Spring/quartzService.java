package com.Spring;

import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.steven.testSpring.test1.dependencyJar.IMailService;

@Component
public class quartzService{
	@Autowired
	private IMailService c_MailService;
	public void send() throws AddressException, GeneralSecurityException, MessagingException{
		System.out.println("start send");
		c_MailService.send();
	}
}
