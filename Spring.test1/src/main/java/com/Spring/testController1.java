package com.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steven.testSpring.test1.dependencyJar.App;

@Controller
@RequestMapping(value = "/springTest")
public class testController1 {
	@Autowired
	private App m_App;
	@Value("${aa}")
    private String aa;
    private final String AA = aa;

    @RequestMapping(value = "/value1", method = RequestMethod.GET)
    @ResponseBody
    public String testValue() {
        return aa;
    }
    @RequestMapping(value = "/value2", method = RequestMethod.GET)
    @ResponseBody
    public String testValue2() {
        return m_App.testString();
    }

}
