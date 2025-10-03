package com.base.admin.config.datasource;

import com.base.admin.mybatis.typehandlers.UUIDTypeHandler;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
//@ComponentScan(basePackages = "com.base.admin")
@EnableTransactionManagement(proxyTargetClass = true)
//@MapperScan({"com.base.admin.mapper"})
//@MapperScan({"com.base.admin.mapper", "com.base.admin.hrm.mapper", "com.base.admin.masterdata.mapper"})
public class MybatisMultipleDatasource {
    public static final String SQL_SESSION_FACTORY_NAME_ADMIN = "sqlSessionFactoryAdmin";
    public static final String MAPPERS_PACKAGE_NAME_ADMIN = "com.base.admin.mapper";

    public static final String SQL_SESSION_FACTORY_NAME_MASTERDATA = "sqlSessionFactoryMasterdata";
    public static final String MAPPERS_PACKAGE_NAME_MASTERDATA = "com.base.admin.masterdata.mapper";

    public static final String SQL_SESSION_FACTORY_NAME_HRM = "sqlSessionFactoryHrm";
    public static final String MAPPERS_PACKAGE_NAME_HRM = "com.base.admin.hrm.mapper";


    private SqlSessionFactory getSqlSessionFactory(DataSource datasource, Resource[] resources) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeHandlersPackage(UUIDTypeHandler.class.getPackage().getName());
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setDataSource(datasource);
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        if (sqlSessionFactory != null) {
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
            sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        }
        return sqlSessionFactory;
    }

    @Bean("adminProperties")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourcePropertiesAdmin() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean("dataSourceAdmin")
    public DataSource dataSourceAdmin(@Qualifier("adminProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(SQL_SESSION_FACTORY_NAME_ADMIN)
    public SqlSessionFactory sqlSessionFactoryAdmin(@Qualifier("dataSourceAdmin") DataSource datasource) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:sqlmap/admin/mappers/**/*.xml");
        return getSqlSessionFactory(datasource, resources);
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManagerAdmin(@Qualifier("dataSourceAdmin") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Primary
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerAdmin() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(MAPPERS_PACKAGE_NAME_ADMIN);
        configurer.setSqlSessionFactoryBeanName(SQL_SESSION_FACTORY_NAME_ADMIN);
        return configurer;
    }


    ////////////////////////////////////////////////////
    @Bean("masterdataProperties")
    @ConfigurationProperties(prefix = "spring.datasource.masterdata")
    public DataSourceProperties dataSourcePropertiesMasterdata() {
        return new DataSourceProperties();
    }

    @Bean("datasourceMasterdata")
    public DataSource datasourceMasterdata(@Qualifier("masterdataProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(SQL_SESSION_FACTORY_NAME_MASTERDATA)
    public SqlSessionFactory sqlSessionFactoryMasterdata(@Qualifier("datasourceMasterdata") DataSource datasource) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:sqlmap/masterdata/mappers/**/*.xml");
        return getSqlSessionFactory(datasource, resources);
    }

    @Bean
    public PlatformTransactionManager transactionManagerMasterdata(@Qualifier("datasourceMasterdata") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerMasterdata() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(MAPPERS_PACKAGE_NAME_MASTERDATA);
        configurer.setSqlSessionFactoryBeanName(SQL_SESSION_FACTORY_NAME_MASTERDATA);
        return configurer;
    }

    ////////////////////////////////////////////////////
    @Bean("hrmProperties")
    @ConfigurationProperties(prefix = "spring.datasource.hrm")
    public DataSourceProperties dataSourcePropertiesHRM() {
        return new DataSourceProperties();
    }

    @Bean("dataSourceHrm")
    public DataSource dataSourceHRM(@Qualifier("hrmProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(SQL_SESSION_FACTORY_NAME_HRM)
    public SqlSessionFactory sqlSessionFactoryHRM(@Qualifier("dataSourceHrm") DataSource datasource) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:sqlmap/hrm/mappers/**/*.xml");
        return getSqlSessionFactory(datasource, resources);
    }

    @Bean
    public PlatformTransactionManager transactionManagerHRM(@Qualifier("dataSourceHrm") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerHRM() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(MAPPERS_PACKAGE_NAME_HRM);
        configurer.setSqlSessionFactoryBeanName(SQL_SESSION_FACTORY_NAME_HRM);
        return configurer;
    }

}
