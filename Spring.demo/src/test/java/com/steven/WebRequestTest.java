package com.steven;

import com.steven.testSpring.test1.dependencyJar.util.WebRequestUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kira7 on 2016/11/23 0023.
 */

public class WebRequestTest {
	@Test
	public void baiduTest() throws IOException {
		String x = WebRequestUtil.getHtml("http://www.baidu.com/s?wd=ip&rsv_spt=1&rsv_iqid=0xcab2796100005f1d&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=3&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=1190&rsv_sug4=1226",null);
		System.out.println(x);
	}
}
