package my.batch.application;

import jakarta.batch.api.Batchlet;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.jboss.logging.Logger;
import org.wildfly.security.auth.server.SecurityDomain;

import java.util.Objects;

@Named
@ApplicationScoped
@org.jboss.ejb3.annotation.SecurityDomain("mySecurityDomain")
public class MyBatchlet implements Batchlet {

    Logger logger = Logger.getLogger(MyBatchlet.class);

    @Override
    public String process() throws Exception {
        logger.info("MyBatchlet start of process method");
        final SecurityDomain domain = SecurityDomain.getCurrent();
        Objects.requireNonNull(domain, "Security domain of the deployment is null");
        return domain.getCurrentSecurityIdentity().getPrincipal().getName();
    }

    @Override
    public void stop() throws Exception {
        logger.info("MyBatchlet stop method");
    }
}
