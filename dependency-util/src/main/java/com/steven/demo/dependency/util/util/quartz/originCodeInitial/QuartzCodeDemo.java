package com.steven.demo.dependency.util.util.quartz.originCodeInitial;

import com.steven.demo.dependency.util.util.quartz.springBeanInitial.quartzService;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.utils.Key;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * Created by kira7 on 2016/11/23 0023.
 */
@Component
public class QuartzCodeDemo implements InitializingBean{
	@Autowired
	private SimpleTrigger c_SimpleTrigger;
	@Autowired
	private Scheduler sched;
	@Autowired
	private JobDetail c_JobDetail;
	@Autowired
	@Qualifier("jobBuilder")
	private JobBuilder c_JobBuilder;
	@Autowired
	private QuartzCode c_Quartzcode;
	@Autowired
	private JobDetailImpl c_JobDetailImpl;
	@Autowired
	private quartzService c_QuartzService;

	public void initialQuartz() throws SchedulerException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2016-11-23 14:00:00");
//		SchedulerFactory schedFact = new StdSchedulerFactory();
//		Scheduler sched = schedFact.getScheduler();
		sched.start();

//		JobDetailImpl job = new JobDetailImpl();
		c_JobDetailImpl.setJobClass(c_Quartzcode.getClass());
//		c_JobDetailImpl.setDescription(this.description);

		c_JobDetailImpl.setKey( new JobKey(Key.createUniqueName("myJob"), "group1"));
//		c_JobDetailImpl.setDurability(this.durability);
//		c_JobDetailImpl.setRequestsRecovery(this.shouldRecover);
//		if(!this.jobDataMap.isEmpty()) {
//			c_JobDetailImpl.setJobDataMap(this.jobDataMap);
//		}

//		c_JobDetail = c_JobDetail.getJobBuilder().newJob(QuartzCode.class).withIdentity("myJob","group1").build();
		c_JobDetail = c_JobBuilder.ofType(c_Quartzcode.getClass()).withIdentity("myJob","group1").build();
//		c_JobDetail = c_JobBuilder.newJob(QuartzCode.class).withIdentity("myJob","group1").build();
		c_SimpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")
				.startNow().withSchedule(simpleSchedule().withIntervalInSeconds(6).withRepeatCount(5)) // some Date
//				.forJob("myJob", "group1") // identify job with name, group strings
				.build();
		c_JobDetailImpl.getJobDataMap().put("service",c_QuartzService);
//		Trigger trigger = (Trigger) newTrigger().withIdentity("myTrigger", "group1").startNow().withSchedule((ScheduleBuilder<Trigger>) simpleSchedule().withIntervalInSeconds(6).repeatForever().build());
		sched.scheduleJob(c_JobDetailImpl,c_SimpleTrigger);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initialQuartz();
	}
}
