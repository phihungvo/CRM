package com.base.admin.quartz.config;

import com.base.admin.quartz.service.JobsListener;
import com.base.admin.quartz.service.TriggerListner;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableAsync
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class QuartzSchedulerConfig {

//    @Autowired
//    DataSource dataSource;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TriggerListner triggerListner;

    @Autowired
    private JobsListener jobsListener;
//


    //    @Bean
//    @QuartzDataSource
//    public DataSource quartzDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//    @Primary
//    @Bean
//    @QuartzDataSource
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource qzDatasource (){
//        return DataSourceBuilder.create().build();
//    }
    @Bean("quartzDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.quartz")
    public DataSourceProperties quartzDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("datasourceQuartz")
    @QuartzDataSource
    public DataSource datasourceQuartz(@Qualifier("quartzDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public PlatformTransactionManager transactionManagerQuartz(@Qualifier("datasourceQuartz") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    /**
     * create scheduler
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("datasourceQuartz") DataSource datasource) throws IOException {

        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // don't use it, created some chaos for us
//        factory.setOverwriteExistingJobs(true);
        factory.setDataSource(datasource);
        factory.setQuartzProperties(quartzProperties());

        //Register listeners to get notification on Trigger misfire etc
        factory.setGlobalTriggerListeners(triggerListner);
        factory.setGlobalJobListeners(jobsListener);

        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        factory.setJobFactory(jobFactory);

        return factory;
    }

    //
//    /**
//     * Configure quartz using properties file
//     */
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
}