package com.steven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.steven.demo.spring.controller.testController1;
import com.steven.demo.dependency.util.IApp;
import com.steven.demo.dependency.util.aspectJbean.LogAudience;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/application-context.xml")
public class ReadAttTest {
	@Autowired
	private IApp m_App;
	@Autowired
	private LogAudience c_LogAudience;
	@Autowired
	private testController1 c_TestController1;
	@Test
	public void TestReadA(){
		m_App.setAtt("dd");
		org.junit.Assert.assertEquals(m_App.getAtt(), c_LogAudience.getAtt());
	}

}
