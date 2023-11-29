package growlab.customer.repository;

import growlab.customer.domain.IndividualCustomerDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IndividualCustomerDetailsRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<IndividualCustomerDetails> individualCustomerDetailsRowMapper;

    public Integer create(Integer individualCustomerId, IndividualCustomerDetails individualCustomerDetails) {
        String sql = "INSERT INTO individual_customer_details (pin, customer_id, unique_id_name, unique_id_value, birth_country_id, birth_city_id, id_begin_date, id_end_date, image, birth_date, gender, marital_status, work_place, position) " +
                "VALUES(:pin, :customerId, :uniqueIdName, :uniqueIdValue, :birthCountryId, :birthCityId, :idBeginDate, :idEndDate, :image, :birthDate, :gender, :maritalStatus, :workPlace, :position)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("pin", individualCustomerDetails.getPin())
                        .addValue("customerId", individualCustomerId)
                        .addValue("uniqueIdName", individualCustomerDetails.getUniqueIdName())
                        .addValue("uniqueIdValue", individualCustomerDetails.getUniqueIdValue())
                        .addValue("birthCountryId", individualCustomerDetails.getBirthCountryId())
                        .addValue("birthCityId", individualCustomerDetails.getBirthCityId())
                        .addValue("idBeginDate", individualCustomerDetails.getIdBeginDate())
                        .addValue("idEndDate", individualCustomerDetails.getIdEndDate())
                        .addValue("image", individualCustomerDetails.getImage())
                        .addValue("birthDate", individualCustomerDetails.getBirthDate())
                        .addValue("gender", individualCustomerDetails.getGender())
                        .addValue("maritalStatus", individualCustomerDetails.getMaritalStatus())
                        .addValue("workPlace", individualCustomerDetails.getWorkPlace())
                        .addValue("position", individualCustomerDetails.getPosition()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public IndividualCustomerDetails getById(Integer id) {
        String sql = "SELECT * FROM individual_customer_details WHERE id = :id";
        return jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                individualCustomerDetailsRowMapper);
    }

    public List<IndividualCustomerDetails> findAll() {
        String sql = "SELECT * FROM individual_customer_details";
        return jdbc.query(sql, individualCustomerDetailsRowMapper);
    }

    public void update(Integer id, IndividualCustomerDetails individualCustomerDetails) {
        String sql = "UPDATE individual_customer_details SET " +
                "pin = :pin, " +
                "customer_id = :customerId, " +
                "unique_id_name = :uniqueIdName, " +
                "unique_id_value = :uniqueIdValue, " +
                "birth_country_id = :birthCountryId, " +
                "birth_city_id = :birthCityId, " +
                "id_begin_date = :idBeginDate, " +
                "id_end_date = :idEndDate " +
                "image = :image" +
                "birth_date = :birthDate" +
                "gender = :gender" +
                "marital_status = :maritalStatus" +
                "work_place = :workPlace" +
                "position = :position" +
                "WHERE id = :id";

        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("id", id)
                        .addValue("pin", individualCustomerDetails.getPin())
                        .addValue("customerId", individualCustomerDetails.getCustomerId())
                        .addValue("uniqueIdName", individualCustomerDetails.getUniqueIdName())
                        .addValue("uniqueIdValue", individualCustomerDetails.getUniqueIdValue())
                        .addValue("birthCountryId", individualCustomerDetails.getBirthCountryId())
                        .addValue("birthCityId", individualCustomerDetails.getBirthCityId())
                        .addValue("idBeginDate", individualCustomerDetails.getIdBeginDate())
                        .addValue("idEndDate", individualCustomerDetails.getIdEndDate())
                        .addValue("image", individualCustomerDetails.getImage())
                        .addValue("birthDate", individualCustomerDetails.getBirthDate())
                        .addValue("gender", individualCustomerDetails.getGender())
                        .addValue("maritalStatus", individualCustomerDetails.getMaritalStatus())
                        .addValue("workPlace", individualCustomerDetails.getWorkPlace())
                        .addValue("position", individualCustomerDetails.getPosition()));
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM individual_customer_details WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            log.error("Individual customer details not found with id: {}", id);
        }
    }
}

