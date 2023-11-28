package growlab.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    @Bean("jdbc")
    @Autowired
    public NamedParameterJdbcTemplate getJDBCTemplate(@Qualifier("customerDS") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
