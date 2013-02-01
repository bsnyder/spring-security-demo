# Spring Security Demo 

This is a simple demo for Spring Security. 

Use Maven to build the WAR: 

    mvn clean install 

Deploy the WAR file to Tomcat or Jetty: 

    cp target/spring-security-demo.war $JETTY_HOME/webapps/

or 

    cp target/spring-security-demo.war $TOMCAT_HOME/webapps/

Then visit the following URL in a browser: `http://localhost:8080/spring-security-demo/welcome`

To demonstrate the different roles defined by the groups in the LDAP store,
log in with the following username/password combinations: 

    ROLE_ADMIN = bsnyder/pass
    ROLE_ADMIN = jlebowski/pass

    ROLE_RELEASE_OWNER = wsobchak/pass

    ROLE_DEPLOYER = dkerabatsos/pass

## Dependency Version Notes 

Spring Security 3.1.x depends on Apache Directory Server 1.5.5 for the embedded LDAP server

## Errors

### LDAP 
The following errors and warnings will be found in the logs and each one comes from the version of Apache Directory Server that is
embedded in Spring Security 3.1.x. 

This warning seems harmless, so I just ignored it: 

    WARN : org.apache.directory.server.core.DefaultDirectoryService - ApacheDS shutdown hook has NOT been registered with the runtime.  This default setting for standalone operation has been overriden.

This error was confirmed by members of the Apache Directory Services team to be innocuous (the was inappropriately categorized as an error in this release of Apache Directory): 

    ERROR: org.apache.directory.server.schema.registries.DefaultAttributeTypeRegistry - attributeType w/ OID 2.5.4.16 not registered!
    ERROR: org.springframework.security.ldap.server.ApacheDSContainer - Failed to create dc entry
    java.lang.IllegalArgumentException: [Assertion failed] - this expression must be true
        at org.springframework.util.Assert.isTrue(Assert.java:65)
        at org.springframework.util.Assert.isTrue(Assert.java:77)
        at org.springframework.security.ldap.server.ApacheDSContainer.start(ApacheDSContainer.java:175)
        at org.springframework.security.ldap.server.ApacheDSContainer.afterPropertiesSet(ApacheDSContainer.java:115)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1514)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1452)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:519)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:456)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:294)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:225)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:291)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:193)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:585)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:913)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:464)
        at org.springframework.web.context.ContextLoader.configureAndRefreshWebApplicationContext(ContextLoader.java:385)
        at org.springframework.web.context.ContextLoader.initWebApplicationContext(ContextLoader.java:284)
        at org.springframework.web.context.ContextLoaderListener.contextInitialized(ContextLoaderListener.java:111)
        at org.apache.catalina.core.StandardContext.listenerStart(StandardContext.java:4779)
        at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5273)
        at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
        at org.apache.catalina.core.ContainerBase.addChildInternal(ContainerBase.java:895)
        at org.apache.catalina.core.ContainerBase.addChild(ContainerBase.java:871)
        at org.apache.catalina.core.StandardHost.addChild(StandardHost.java:615)
        at org.apache.catalina.startup.HostConfig.deployWAR(HostConfig.java:962)
        at org.apache.catalina.startup.HostConfig$DeployWar.run(HostConfig.java:1603)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:441)
        at java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
        at java.util.concurrent.FutureTask.run(FutureTask.java:138)
        at java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
        at java.lang.Thread.run(Thread.java:680)


