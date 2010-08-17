package hu.modsstore.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class is utility class for Spring.
 * */
public final class SpringUtil {

    /**
     * private default constructor.
     * */
    private SpringUtil() {
        super();
    }

    /**
     * LOG is logger.
     * */
    private static final Log LOG = LogFactory.getLog(SpringUtil.class);

    /**
     * contextXMLName is the name of the spring xml.
     * */
    private static String contextXMLName = "spring.xml";
    /**
     * testContextXMLName is the name of the test spring xml.
     * */
    private static String testContextXMLName = "spring-test.xml";
    /**
     * context is the {@link ApplicationContext}, when we use contextXMLName.
     * */
    private static ApplicationContext context;
    /**
     * testContext is the {@link ApplicationContext},
     * when we use testContextXMLName.
     * */
    private static ApplicationContext testContext;


    /**
     * This method set the contextXMLName.
     * @param paramContextXMLName name of the context xml
     * */
    public static void setContextXMLName(final String paramContextXMLName) {
        SpringUtil.contextXMLName = paramContextXMLName;
    }

    /**
     * Get testContext to testing.
     * @return testContext {@link ApplicationContext}
     * */
    private static ApplicationContext getTestContext() {
        if (testContext == null) {
            LOG.info("Context lookup " + testContextXMLName);
            testContext = new ClassPathXmlApplicationContext(
                    testContextXMLName);
        }
        return testContext;
    }

    /**
     * Get testContext to running application.
     * @return context {@link ApplicationContext}
     * */
    private static ApplicationContext getContext() {
        if (context == null) {
            LOG.info("Context lookup " + contextXMLName);
            context = new ClassPathXmlApplicationContext(contextXMLName);
        }
        return context;
    }

    /**
     *  Get the object by name.
     *  You can retrieve instances of your beans.
     *  @param bean id of the bean (in xml)
     *  @return object the instances of the bean
     * */
    public static Object getBean(final String bean) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Lookup: " + bean);
        }
        return getContext().getBean(bean);
    }

    /**
     *  Get the test bean by class.
     *  You can retrieve instances of your beans.
     *  @param theClass class of the bean
     *  @param <T> type of the class
     *  @return object the instances of the bean
     * */
    @SuppressWarnings("unchecked")
    public static < T > T getTestBean(final Class < T > theClass) {
        String bean;
        bean = theClass.getName();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Lookup: " + bean);
        }
        return (T) getTestContext().getBean(bean);
    }

    /**
     *  Get the bean by class.
     *  You can retrieve instances of your beans.
     *  @param theClass class of the bean
     *  @param <T> type of the class
     *  @return object the instances of the bean
     * */
    @SuppressWarnings("unchecked")
    public static < T > T getBean(final Class < T > theClass) {
        String bean;
        bean = theClass.getName();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Lookup: " + bean);
        }
        return (T) getContext().getBean(bean);
    }

    /**
     * isContextInitialized is true if context != null, otherwise it is false.
     * @return boolean
     * */
    public static boolean isContextInitialized() {
        return context != null;
    }

}
