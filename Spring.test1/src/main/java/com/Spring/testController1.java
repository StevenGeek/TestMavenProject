package com.Spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/springTest")
public class testController1 {
    private static String aa;
    private static final String AA = "1";

    @RequestMapping(value = "/value1", method = RequestMethod.GET)
    @ResponseBody
    public String testValue() {
        return AA;
    }

}
