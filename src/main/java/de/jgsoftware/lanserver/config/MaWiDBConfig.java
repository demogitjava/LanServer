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
@PropertySource({"classpath:mawi.properties"})
@EnableTransactionManagement
public class MaWiDBConfig
{

    JdbcTemplate jtm1;

    @Autowired
    EntityManagerFactoryBuilder builder;

    @Autowired
    DataSource dataSource;



    public MaWiDBConfig()
    {
      startH2Server();
    }

    // start h2 database server
    private static void startH2Server()
    {
        try
        {
            //org.h2.tools.Server h2Server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
            org.h2.tools.Server h2Server = Server.createTcpServer().start();
            if (h2Server.isRunning(true))
            {
                System.out.print("H2 server was started and is running." + "\n");
            } else
            {
                h2Server = Server.createTcpServer().start();
                throw new RuntimeException("Could not start H2 server." + "\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to start H2 server: " + e + "\n");
        }

    }

    @Bean(name = "mawiDataSource")
    @ConfigurationProperties(prefix = "spring.mawi.datasource")
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mawiEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mawiEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("mawiDataSource") DataSource dsmawi) {
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
    public JdbcTemplate jdbcTemplate(@Qualifier("mawiDataSource") DataSource dsmawi)
    {
        return new JdbcTemplate(dsmawi);
    }

    public JdbcTemplate getJtm1() {
        return jtm1;
    }

    public void setJtm1(JdbcTemplate jtm1) {
        this.jtm1 = jtm1;
    }


}
