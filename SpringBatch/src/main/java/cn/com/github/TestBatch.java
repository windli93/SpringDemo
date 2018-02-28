package cn.com.github;

import java.io.File;
import java.io.FileReader;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

public class TestBatch {

	
	 public static void main(String[] args) throws Exception{
		 //加载上下文
		 String[] configLocation = {"classpath:applicationContext.xml"};
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		 
		 //获得任务启动器
		 JobLauncher launcher = applicationContext.getBean(JobLauncher.class);
		 JobRepository repository = applicationContext.getBean(JobRepository.class);
		 PlatformTransactionManager manager = applicationContext.getBean(PlatformTransactionManager.class);
		 
		 //创建Reader
		 FlatFileItemReader<DeviceCommand> flatFileItemReader = new FlatFileItemReader<DeviceCommand>();
		 flatFileItemReader.setResource(new FileSystemResource(new File("src/main/resources/batch.properties")));
		 flatFileItemReader.setLineMapper(new HelloMapper());
		 
		 //创建processor
		 HelloItemProcessor processor = new HelloItemProcessor();
		 
		 //创建writer
		 FlatFileItemWriter<DeviceCommand> fileItemWriter = new FlatFileItemWriter<DeviceCommand>();
		 fileItemWriter.setResource(new FileSystemResource(new File("src/main/resources/batch.properties")));
		 fileItemWriter.setLineAggregator(new HelloLineAggregator());
		 
		 //创建step
		 StepBuilderFactory  factory = new StepBuilderFactory(repository, manager);
		 Step step = factory.get("Step")
				     .<DeviceCommand,DeviceCommand>chunk(1)
				     .reader(flatFileItemReader)
				     .processor(processor)
				     .writer(fileItemWriter)
				     .build();
		 
		 //创建job
		 JobBuilderFactory factory2 = new JobBuilderFactory(repository);
		 Job job = factory2.get("job").start(step).build();
		
		 //启动任务
		 launcher.run(job, new JobParameters());
	}
}
