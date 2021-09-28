package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.model.ExamResult;
import com.nt.processor.ExamResultItemProcessor;
import com.nt.rowmapper.ExamResultMapper;
@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private DataSource ds;
	@Autowired
	private  StepBuilderFactory  stepFactory;
	@Autowired
	private  JobBuilderFactory   jobFactory;
	
	@Autowired
	private ExamResultItemProcessor processor;
	
	 @Bean
	  public FlatFileItemReader<ExamResult> reader() {
		  
	    FlatFileItemReader<ExamResult> reader; 
	    reader= new FlatFileItemReader<>();
	    
	    reader.setResource(new ClassPathResource("com/nt/csv/SuperBrains.csv"));
	    
	    reader.setLineMapper(new DefaultLineMapper<ExamResult>() {{
           setLineTokenizer(new DelimitedLineTokenizer() {{
        	   setDelimiter(",");
           }});
           setFieldSetMapper(new ExamResultMapper());
	    }});
	      
	    return reader;
	  }//reader()
	 
	 
	//Item Writer
	  @Bean
	  public JdbcBatchItemWriter<ExamResult> writer() {
	    JdbcBatchItemWriter<ExamResult> writer =null;
	    writer=	new JdbcBatchItemWriter();

	    writer.setDataSource(ds);
	    writer.setSql("INSERT INTO EXAM_RESULT1(ID,SEMESTER,PERCENTAGE,DOB)  VALUES (:id,:semester,:percentage,:dob)");
	    writer.setItemSqlParameterSourceProvider(
	        new BeanPropertyItemSqlParameterSourceProvider<ExamResult>());
	    
	    return writer;
	  }//writer()
	  
	  
	  //step creation
	  @Bean("step1")
	  public Step createStep() {
	    return stepFactory.get("step1").<ExamResult, ExamResult>chunk(1).reader(reader())
	        .processor(processor).writer(writer()).build();
	  }
	  
	  @Bean("job1")
	  public Job createJob() {
	    return jobFactory.get("job1").incrementer(new RunIdIncrementer())
	        .flow(createStep()).end().build();
	  }

}
