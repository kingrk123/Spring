package com.nt.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobLauncher launcher=null;
		Job job=null;
		JobExecution execution=null;
		 //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get JobLauncher
		launcher=ctx.getBean("jobLauncher",JobLauncher.class);
		//get Job
		job=ctx.getBean("job1",Job.class);
		
		try {
			//run the Job
			execution=launcher.run(job,new JobParameters());
			System.out.println("Job Execution status ::"+execution.getStatus());
		}
		catch(JobExecutionException ex) {
			ex.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
