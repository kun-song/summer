package com.satansk.summer.config;


import java.util.Hashtable;
import java.util.Map;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableTransactionManagement(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.LOWEST_PRECEDENCE
)
@ComponentScan(
		basePackages = "com.satansk.summer.site",
		excludeFilters = @ComponentScan.Filter({ Controller.class, ControllerAdvice.class })
		)
public class RootContextConfiguration {
	
	private static final Logger log = LogManager.getLogger();
	
    @Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,
                false);
        return mapper;
    }
    
    /**
     * 在根应用上下文中数据源，需要在 Tomcat 的 context.xml 文件中预先定义好数据源
     * 
     * @return 返回查找到的数据源
     */
    @Bean
    public DataSource springJpaDataSource() {
    	JndiDataSourceLookup lookup = new JndiDataSourceLookup();
    	return lookup.getDataSource("jdbc/EntityMappings");
    }
    
    /**
     * 创建持久化单元，代替原来 src/main/source/persistence.xml 配置文件
     * 
     * @return 创建好的持久化单元
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
    	Map<String, Object> properties = new Hashtable<>();
        properties.put("javax.persistence.schema-generation.database.action", "none");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        adapter.setShowSql(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(this.springJpaDataSource());
        factory.setPackagesToScan("com.satansk.summer.site.entity");
        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factory.setValidationMode(ValidationMode.NONE);
        factory.setJpaPropertyMap(properties);
        
        return factory;
    }
    
    /**
     * 使用 @EnableTransactionManagement 注解必须提供一个 PlatformTransactionManager 的默认实现
     * 
     * @return 构造好的 JpaTransactionManager
     */
    @Bean
    public PlatformTransactionManager jpaTransactionManager() {
    	return new JpaTransactionManager(this.entityManagerFactoryBean().getObject());
    }

    /**
     * 1. 事务管理默认返回第一个找到的 PlatformTransactionManager，但上下文可以存在多个 PlatformTransactionManager。
     * 2. Spring 总是使用 TransactionManagementConfigurer 接口的 annotationDrivenTransactionManager 方法返回的
     * 		管理器作为 @Transactional 方法的默认管理器。
     */
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return this.jpaTransactionManager();
	}
}
