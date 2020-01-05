package io.msdalp.configuration;



import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "ds1EntityManagerFactory",
        transactionManagerRef = "ds1TransactionManager",
        basePackages = "io.msdalp.dsone"
)
@EnableTransactionManagement
public class FirstEntityManagerFactory {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean ds1EntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSourceBlogDb") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("io.msdalp.dsone")
                .persistenceUnit("ds1-pu")
                .properties(hibernateProperties())
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager ds1TransactionManager(
            @Qualifier("ds1EntityManagerFactory") EntityManagerFactory ds1EntityManagerFactory) {
        return new JpaTransactionManager(ds1EntityManagerFactory);
    }

    protected Map<String, String> hibernateProperties() {
        return new HashMap<String, String>() {
            {
                put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
                put("hibernate.hbm2ddl.auto", "create");
            }
        };
    }
}
