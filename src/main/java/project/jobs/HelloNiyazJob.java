package project.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloNiyazJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        LOG.info("Hello Niyaz");
    }
}
