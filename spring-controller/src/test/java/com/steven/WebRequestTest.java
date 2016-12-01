package com.steven;

import com.steven.demo.dependency.util.util.WebRequestUtil;
import com.steven.demo.spring.webService.WebServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by kira7 on 2016/11/23 0023.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/application-context.xml")
public class WebRequestTest {
	@Autowired
	private WebServiceClient c_WebServiceClient;
//	@Test
//	public void baiduTest() throws IOException {
//		String x = WebRequestUtil.getHtml("http://www.baidu.com/s?wd=ip&rsv_spt=1&rsv_iqid=0xcab2796100005f1d&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=3&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=1190&rsv_sug4=1226",null);
//		System.out.println(x);
//	}

}
