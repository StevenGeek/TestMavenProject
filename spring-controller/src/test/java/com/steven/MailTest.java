package com.steven;



import com.steven.demo.dependency.util.bean.SpringConfigInjectBean;
import com.steven.demo.dependency.util.util.mailUtil.IMailService;
import com.steven.demo.dependency.util.util.quartz.springBeanInitial.quartzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/application-context.xml")
public class MailTest {
	@Autowired
	private IMailService c_MailService;
	@Autowired
	private SpringConfigInjectBean c_SpringConfigInjectBean;
	@Test
	public void sendTest() throws Exception{
//		c_MailService.send("x");
		c_MailService.sendQQMail();
	}
}
