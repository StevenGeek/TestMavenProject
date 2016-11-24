package com.Spring;

import com.steven.testSpring.test1.dependencyJar.util.quartz.originCodeInitial.QuartzCodeDemo;
import com.steven.testSpring.test1.dependencyJar.util.quartz.springBeanInitial.quartzService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steven.utilDependency.jar.IApp;

import java.text.ParseException;

@Controller
@RequestMapping(value = "/springTest")
public class testController1 {
	@Autowired
	@Qualifier("app")
	private IApp m_App;
	@Value("${aa}")
    private String aa;
	@Autowired
    @Qualifier("quartzService")
    private quartzService c_QuartzService;
	@Autowired
	private QuartzCodeDemo c_QuartzCodeDemo;
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
//    @RequestMapping(value = "scheduleDemo", method = RequestMethod.GET)
//    @ResponseBody
//    public void scheduleDemo()throws Exception{
//        c_QuartzService.send();
//    }
    @RequestMapping(value = "scheduleCodeInitial", method = RequestMethod.GET)
	@ResponseBody
	public void scheduleCodeInitial () throws SchedulerException, ParseException {
	    c_QuartzCodeDemo.initialQuartz();
    }
}
