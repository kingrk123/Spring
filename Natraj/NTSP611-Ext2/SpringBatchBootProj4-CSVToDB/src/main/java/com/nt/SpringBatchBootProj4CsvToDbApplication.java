package com.nt;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBatchBootProj4CsvToDbApplication {
	@Autowired
	private static JobLauncher launcher;

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Job job=null;
		JobExecution execution;
		//get IOC contaienr
		ctx=SpringApplication.run(SpringBatchBootProj4CsvToDbApplication.class, args);
		//get Job object
		job=ctx.getBean("job1",Job.class);
		try {
			//execute Job
			execution=launcher.run(job,new JobParameters());
			System.out.println("Status ::"+execution.getStatus());
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
