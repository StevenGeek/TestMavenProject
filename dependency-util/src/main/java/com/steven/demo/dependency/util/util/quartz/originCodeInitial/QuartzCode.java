package com.steven.demo.dependency.util.util.quartz.originCodeInitial;

import com.steven.demo.dependency.util.util.quartz.springBeanInitial.quartzService;
import org.quartz.*;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * Created by kira7 on 2016/11/23 0023.
 */
@Component
public class QuartzCode implements Job{


	private static int i=1;
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		try {
			printTime(jobExecutionContext);
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	void printTime(JobExecutionContext jobExecutionContext) throws SchedulerException, MessagingException, GeneralSecurityException, InterruptedException, IOException {
		System.out.println("start  " + i++ + "  at");
		System.out.println(new Date());
		System.out.println("end");
		quartzService ser = (quartzService) jobExecutionContext.getJobDetail().getJobDataMap().get("service");
		ser.send();
		if (i==1){
			JobKey key = jobExecutionContext.getJobDetail().getKey();
			TriggerKey Tkey = jobExecutionContext.getTrigger().getKey();
			JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//			SchedulerFactory schedFact = new StdSchedulerFactory();
//			Scheduler sched = schedFact.getScheduler();
			TriggerKey tkey = new TriggerKey("trigger1","group1");
			Trigger trigger = jobExecutionContext.getScheduler().getTrigger(tkey);
//			SimpleTrigger newTrigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("newTrigger","group1").withSchedule(simpleSchedule().withIntervalInSeconds(100).withRepeatCount(10)).build();
			SimpleTrigger newTrigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("newTrigger","group1").withSchedule(simpleSchedule().withIntervalInSeconds(100).withRepeatCount(5)).build();
			jobExecutionContext.getScheduler().rescheduleJob(tkey,newTrigger);
//			SimpleTrigger trigger = (SimpleTrigger) jobExecutionContext.getTrigger();
//			trigger.getTriggerBuilder().withSchedule(simpleSchedule().withIntervalInSeconds(12));
//			jobExecutionContext.getScheduler().scheduleJob(jobExecutionContext.getJobDetail(),jobExecutionContext.getTrigger());
			System.out.println("changed");
		}else {
			if (i ==2) {
				Scheduler sched = jobExecutionContext.getScheduler();
				sched.shutdown();
			}
		}
	}
}
