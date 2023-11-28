package growlab.customer.config;

import growlab.customer.domain.IndividualCustomerDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;


@Configuration
public class RowMapperConfig {

    @Bean("individualCustomerDetailsRowMapper")
    public RowMapper<IndividualCustomerDetails> getCustomerRowMapper() {
        return (rs, rowNum) -> IndividualCustomerDetails.builder()
                .id(rs.getInt("id"))
                .pin(rs.getInt("pin"))
                .uniqueIdName(rs.getString("unique_id_name"))
                .uniqueIdValue(rs.getString("unique_id_value"))
                .birthCountryId(rs.getInt("birth+_country_id"))
                .birthCityId(rs.getInt("birth_city_id"))
                .idBeginDate(rs.getDate("id_begin_date").toLocalDate())
                .idEndDate(rs.getDate("id_end_date").toLocalDate())
                .image(rs.getString("image"))
                .build();
    }
}
