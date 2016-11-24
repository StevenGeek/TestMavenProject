package com.steven;



import com.steven.testSpring.test1.dependencyJar.util.quartz.springBeanInitial.quartzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/application-context.xml")
public class MailTest {
	@Autowired
	private quartzService c_quartzService;
	@Test
	public void sendTest() throws Exception{
		//c_quartzService.send();
	}
}
