package com.steven;

import com.steven.demo.dependency.util.IApp;
import com.steven.demo.dependency.util.bean.SpringConfigInjectBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kira7 on 2016/12/24 0024.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/application-context.xml")
public class ThreadTest {
	@Autowired
	private SpringConfigInjectBean c_SpringConfigInjectBean;
	@Autowired
	@Qualifier("app")
	private IApp c_App;
	@Test
	public void threadTest(){
		Thread t1 = new Thread(new T1(c_SpringConfigInjectBean, "Thread 1"));
		Thread t2 = new Thread(new T1(c_SpringConfigInjectBean, "Thread 2"));
		Thread t3 = new Thread(new T1(c_SpringConfigInjectBean, "Thread 3"));
		Thread t4 = new Thread(new T1(c_SpringConfigInjectBean, "Thread 4"));
		t2.setName("Thread2");
		t1.setName("Thread1");
		t3.setName("Thread3");
		t4.setName("Thread4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
class T1 implements Runnable{
	private SpringConfigInjectBean c_SpringConfigInjectBean;

	public String getPrintContent() {
		return printContent;
	}

	public void setPrintContent(String printContent) {
		this.printContent = printContent;
	}

	private String printContent;
	public T1(SpringConfigInjectBean m_SpringconfigInjectBean, String m_PrintContent){
		this.c_SpringConfigInjectBean = m_SpringconfigInjectBean;
		this.printContent = m_PrintContent;
	}
	@Override
	public void run() {
		c_SpringConfigInjectBean.print(printContent);
	}
}
