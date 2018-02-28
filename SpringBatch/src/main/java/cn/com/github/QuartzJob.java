package cn.com.github;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzJob extends QuartzJobBean{

	public static final String RUN_MONTH_KEY="RUN.MONTH";
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		Logger logger = LoggerFactory.getLogger(BillingItemProcessor.class);  
        logger.info("beginning");    
             
           SimpleJobLauncher launcher = new SimpleJobLauncher();  
           Map<String, Object> jobDataMap = paramJobExecutionContext.getMergedJobDataMap();  
           launcher.setJobRepository((JobRepository) jobDataMap.get("jobRepository"));  
           launcher.setTaskExecutor(new SyncTaskExecutor());  
           try {  
               Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();  
               parameters.put(RUN_MONTH_KEY, new JobParameter("2011-2"+System.currentTimeMillis()));  
                 
               Long startTime=System.currentTimeMillis();  
                 
               JobExecution je = launcher.run((Job) jobDataMap.get("jobName"),  
                       new JobParameters(parameters));  
               System.out.println("使用时间："+(System.currentTimeMillis()-startTime));  
                 
               //System.out.println(je);  
               //System.out.println(je.getJobInstance());  
               //System.out.println(je.getStepExecutions());  
           } catch (Exception e) {  
               e.printStackTrace();  
           }         
            System.out.println("endding");  
	}

}
