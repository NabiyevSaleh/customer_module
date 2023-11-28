package growlab.customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("customerDS")
    @ConfigurationProperties("spring.datasource.customer")
    public DataSource getCustomerDS() {
        return DataSourceBuilder.create().build();
    }
}
