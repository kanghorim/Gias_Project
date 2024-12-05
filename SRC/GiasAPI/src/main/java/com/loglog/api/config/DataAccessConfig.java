package com.loglog.api.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = "com.loglog.api.commons.daos")
public class DataAccessConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(LazyConnectionDataSourceProxy dataSource, ApplicationContext applicationContext) throws Exception {
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);

	    Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath*:com/loglog/api/commons/daos/mapper/*.xml");
	    List<Resource> resourceList = new ArrayList<>(Arrays.asList(mapperLocations));

	    sessionFactory.setMapperLocations(resourceList.toArray(new Resource[0]));
	    return sessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
    public PlatformTransactionManager transactionManager(LazyConnectionDataSourceProxy dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
	 
}