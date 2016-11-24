package com.steven.testSpring.test1.dependencyJar.util.mailUtil;

import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IMailService {
	public void send(String content) throws GeneralSecurityException, AddressException, MessagingException;
	public void sendQQMail() throws Exception;
}
