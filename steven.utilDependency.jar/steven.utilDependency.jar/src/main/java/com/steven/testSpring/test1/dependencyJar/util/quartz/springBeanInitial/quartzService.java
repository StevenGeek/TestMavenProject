package com.steven.testSpring.test1.dependencyJar.util.quartz.springBeanInitial;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import com.steven.testSpring.test1.dependencyJar.util.WebRequestUtil;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.steven.testSpring.test1.dependencyJar.util.mailUtil.IMailService;

@Component
public class quartzService{
	@Autowired
	@Qualifier("mailService")
	private IMailService c_MailService;

	public void send() throws GeneralSecurityException, MessagingException, IOException, InterruptedException, SchedulerException {
		System.out.println("start send");
		System.out.print(new Date().toString());
		String x = WebRequestUtil.getHtml("http://www.baidu.com/s?wd=ip&rsv_spt=1&rsv_iqid=0xcab2796100005f1d&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=3&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=1190&rsv_sug4=1226",null);
		c_MailService.send(getMyIpRegex(x));
	}
	public String getMyIpRegex(String article){
		Pattern pattern = Pattern.compile("(?<=fk=\\\")[\\d\\W]+");
		Matcher matcher = pattern.matcher(article);
		if(matcher.find()){
			article+="\n\n\n"+matcher.group();
		}
		return article;
	}
	public void sendx(){
		System.out.println();
	}

}
