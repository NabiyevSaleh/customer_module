package growlab.customer.repository;

import growlab.customer.domain.IndividualCustomerDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IndividualCustomerDetailsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<IndividualCustomerDetails> individualCustomerDetailsRowMapper;

    public Integer create(IndividualCustomerDetails individualCustomerDetails) {
        String sql = "INSERT INTO individual_customer_details (pin, customer_id, unique_id_name, unique_id_value, birth_country_id, birth_city_id, id_begin_date, id_end_date, image ) " +
                "VALUES(:pin, :customerId, :uniqueIdName, :uniqueIdValue, :birthCountryId, :birthCityId, :idBeginDate, :idEndDate, :image)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql,
                new MapSqlParameterSource()
                        .addValue("pin", individualCustomerDetails.getPin())
                        .addValue("customerId", individualCustomerDetails.getCustomerId())
                        .addValue("uniqueIdName", individualCustomerDetails.getUniqueIdName())
                        .addValue("uniqueIdValue", individualCustomerDetails.getUniqueIdValue())
                        .addValue("birthCountryId", individualCustomerDetails.getBirthCountryId())
                        .addValue("birthCityId", individualCustomerDetails.getBirthCityId())
                        .addValue("idBeginDate", individualCustomerDetails.getIdBeginDate())
                        .addValue("idEndDate", individualCustomerDetails.getIdEndDate())
                        .addValue("image", individualCustomerDetails.getImage()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public IndividualCustomerDetails getById(Integer id) {
        String sql = "SELECT * FROM individual_customer_details WHERE id = :id";
        return jdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                         individualCustomerDetailsRowMapper);
    }

    public List<IndividualCustomerDetails> findAll(){
        String sql = "SELECT * FROM individual_customer_details";
        return jdbcTemplate.query(sql, individualCustomerDetailsRowMapper);
    }
}
