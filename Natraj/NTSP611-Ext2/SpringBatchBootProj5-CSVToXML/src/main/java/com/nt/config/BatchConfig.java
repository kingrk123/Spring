package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.nt.model.ExamResult;
import com.nt.processor.ExamResultProcessor;
import com.nt.rowmapper.ExamResultMapper;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	
	@Autowired
	private ExamResultProcessor processor;
	
	@Autowired
	private StepBuilderFactory stepFactory;
	
	@Autowired
	private JobBuilderFactory jobFactory;
	
	//reader
	@Bean
	public  FlatFileItemReader<ExamResult>  reader(){
		FlatFileItemReader<ExamResult> freader=new FlatFileItemReader<ExamResult>();
		
		freader.setResource(new ClassPathResource("com/nt/csv/SuperBrains.csv"));
		freader.setLineMapper(new DefaultLineMapper<ExamResult>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
			}});
			setFieldSetMapper(new ExamResultMapper());
		}});
		return freader;
	}
	
	
	@Bean
	public   StaxEventItemWriter<ExamResult>  writer(){
		Jaxb2Marshaller marshaller=null;
		StaxEventItemWriter<ExamResult> writer=new  StaxEventItemWriter<ExamResult>();
		
		writer.setResource(new FileSystemResource("TopBrains.xml"));
		writer.setRootTagName("TopBrains");

		marshaller=new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(ExamResult.class);
		writer.setMarshaller(marshaller);
	   return writer;	
	}
	
	@Bean(name="step1")
	public  Step   createStep() {
		return  stepFactory.get("step1").<ExamResult,ExamResult>chunk(1).reader(reader()).processor(processor).writer(writer()).build();
	}
	
	@Bean("job1")
	  public Job createJob() {
	    return jobFactory.get("job1").incrementer(new RunIdIncrementer())
	        .flow(createStep()).end().build();
	  }


}
