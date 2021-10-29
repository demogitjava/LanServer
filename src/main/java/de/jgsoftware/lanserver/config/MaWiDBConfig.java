package de.jgsoftware.lanserver.config;


import java.sql.SQLException;
import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class MaWiDBConfig
{
    @Autowired
    JdbcTemplate jtm1;


    @Autowired
    DataSource dataSource;



    public MaWiDBConfig()
    {

    }



    @Bean("ds2")
    @ConfigurationProperties(prefix="app.datasource2")
    public DataSource secondDS()
    {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "mawiEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mawiEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("ds2") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        //properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("de.jgsoftware.lanserver.model.mawi").persistenceUnit("Mawi").build();
    }

    @Bean(name = "mawiTransactionManager")
    public PlatformTransactionManager mawiTransactionManager(
            @Qualifier("mawiEntityManagerFactory") EntityManagerFactory mawiEntityManagerFactory) {
        return new JpaTransactionManager(mawiEntityManagerFactory);
    }

    @Bean(name = "mawiJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("ds2") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }



}
