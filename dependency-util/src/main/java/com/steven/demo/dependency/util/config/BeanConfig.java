package com.steven.demo.dependency.util.config;

import com.steven.demo.dependency.util.bean.SpringConfigInjectBean;
import com.steven.demo.dependency.util.util.quartz.originCodeInitial.QuartzCodeDemo;
import org.quartz.SchedulerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.text.ParseException;

/**
 * Created by kira7 on 2016/11/30 0030.
 */
@Configuration //xml文件的替换形式写法（@Component也可以，最好用@Configuration）
public class BeanConfig {
	@Bean //相当于在xml里配置了该bean
	public SpringConfigInjectBean springConfigInjectBean(){
		return new SpringConfigInjectBean("AA");
	}
	@Bean
	public QuartzCodeDemo quartzCodeDemo() throws ParseException, SchedulerException {
		return new QuartzCodeDemo();
	}
}
