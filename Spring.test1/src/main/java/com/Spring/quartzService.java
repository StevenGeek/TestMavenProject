package com.Spring;

import java.security.GeneralSecurityException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.steven.testSpring.test1.dependencyJar.IMailService;

@Component
public class quartzService{
	@Autowired
	private IMailService c_MailService;
	public void send() throws AddressException, GeneralSecurityException, MessagingException{
		System.out.println("start send");
		System.out.print(new Date().toString());
//		c_MailService.send();
	}
}
