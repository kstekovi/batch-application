package my.batch.application;



import jakarta.batch.api.listener.JobListener;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.jboss.logging.Logger;

@Named("myJobListener")
@ApplicationScoped
public class MyJobListener implements JobListener {

    Logger logger = Logger.getLogger(MyJobListener.class);

    @Override
    public void beforeJob() throws Exception {
        logger.info("My Job is starting");
    }

    @Override
    public void afterJob() throws Exception {
        logger.info("My Job is ending");
    }
}
