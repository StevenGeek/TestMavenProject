package com.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Spring.aop.bean.ProInnerInjectAopBean;
import com.steven.testSpring.test1.dependencyJar.IApp;
import com.steven.testSpring.test1.dependencyJar.PersonInterface;
import com.steven.testSpring.test1.dependencyJar.impl.App;

@Controller
@RequestMapping(value = "/springTest")
public class testController1 {
	@Autowired
	@Qualifier("app")
	private IApp m_App;
	@Value("${aa}")
    private String aa;
	
	@RequestMapping(value = "/repositoryTest", method = RequestMethod.GET)
    @ResponseBody
    public String repositoryTest() {
        return m_App.repositoryTest();
    }
	
    @RequestMapping(value = "/value1", method = RequestMethod.GET)
    @ResponseBody
    public String testValue() {
        return aa;
    }
    @RequestMapping(value = "/value2", method = RequestMethod.GET)
    @ResponseBody
    public String testValue2() {
//    	return m_App.testString();
    	String X = m_App.testString();
        return m_App.testString() + "\n" + m_App.getStudent().toString() + " \r\n" +
                "XX:  " + m_App.getX() + "\nteacher: " + m_App.getTeacher().toString();
    }
    @RequestMapping(value = "/value3/{a}", method = RequestMethod.GET)
    @ResponseBody
    public Double testValue3(@PathVariable int a) {
    	int x = m_App.testInjectAop(a);
    	System.out.println(x);
    	return (double) (2/a);
    }
    @RequestMapping(value = "/testReadAtt/{att}", method = RequestMethod.GET)
    @ResponseBody
    public String testReadAtt(@PathVariable String att) {
    	m_App.setAtt(att);
    	return att;
    }
}
