package com.steven.demo.dependency.util.config;

import com.steven.demo.dependency.util.bean.SpringConfigInjectBean;
import com.steven.demo.dependency.util.util.quartz.originCodeInitial.QuartzCodeDemo;
import org.quartz.SchedulerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

/**
 * Created by kira7 on 2016/11/30 0030.
 */
@Configuration
public class BeanConfig {
	@Bean
	public SpringConfigInjectBean springConfigInjectBean(){
		return new SpringConfigInjectBean("AA");
	}
//	@Bean
//	public QuartzCodeDemo quartzCodeDemo() throws ParseException, SchedulerException {
//		return new QuartzCodeDemo();
//	}
}
