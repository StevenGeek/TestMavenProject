package com.steven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.steven.testSpring.test1.dependencyJar.IApp;
import com.steven.testSpring.test1.dependencyJar.aspectJbean.LogAudience;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/application-context.xml")
public class testReadAtt {
	@Autowired
	private IApp m_App;
	@Autowired
	private LogAudience c_LogAudience;
	@Test
	public void testReadA(){
		m_App.setAtt("dd");
		org.junit.Assert.assertEquals(m_App.getAtt(), c_LogAudience.getAtt());
	}
}
