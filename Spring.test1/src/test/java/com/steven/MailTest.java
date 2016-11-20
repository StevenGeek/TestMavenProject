package com.steven;

import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.steven.testSpring.test1.dependencyJar.IMailService;
import com.steven.testSpring.test1.dependencyJar.impl.MailService;

public class MailTest {
	@Autowired
	private IMailService c_MailService;
	@Test
	public void sendTest() throws Exception{
		c_MailService = new MailService();
//		c_MailService.sendQQMail();
		c_MailService.send();
	}
}
