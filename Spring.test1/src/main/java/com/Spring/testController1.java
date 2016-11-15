package com.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steven.testSpring.test1.dependencyJar.IApp;
import com.steven.testSpring.test1.dependencyJar.PersonInterface;
import com.steven.testSpring.test1.dependencyJar.impl.App;

@Controller
@RequestMapping(value = "/springTest")
public class testController1 {
	@Autowired
	private IApp m_App;
	@Value("${aa}")
    private String aa;

    @RequestMapping(value = "/value1", method = RequestMethod.GET)
    @ResponseBody
    public String testValue() {
        return aa;
    }
    @RequestMapping(value = "/value2", method = RequestMethod.GET)
    @ResponseBody
    public String testValue2() {
    	
        return m_App.testString() + m_App.getStudent().toString() + " \r\nX:  " + m_App.getX() + "\nteacher: " + m_App.getTeacher().toString();
    }

}
