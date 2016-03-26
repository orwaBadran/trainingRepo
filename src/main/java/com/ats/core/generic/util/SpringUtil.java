package com.ats.core.generic.util;

import java.sql.Connection;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;


public class SpringUtil  implements ApplicationContextAware  {
    private static ApplicationContext CONTEXT;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
      CONTEXT = context;
    }

    public static Object getBean(String beanName) {
      return CONTEXT.getBean(beanName);
    }
    
    private static Connection connection ;
    
    private static DataSource dataSource ;
    
    
    @PersistenceContext
    EntityManager entityManager;
    
    @PostConstruct
    private  void setConnection() {
       EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
       dataSource = info.getDataSource();
       connection =  DataSourceUtils.getConnection(dataSource);  

    }
    
    public static void releaseConnection(){
		DataSourceUtils.releaseConnection(connection, dataSource);
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public static Connection getConnection() {
		
		return connection;
	}

    

}
