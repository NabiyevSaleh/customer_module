package growlab.customer.repository;

import growlab.customer.domain.IndividualCustomerDetail;
import growlab.customer.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IndividualCustomerDetailRepository {

    private static final String NOT_FOUND_MESSAGE = "Individual customer detail not found";
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<IndividualCustomerDetail> individualCustomerDetailsRowMapper;

    public Integer create(Integer customerId, IndividualCustomerDetail individualCustomerDetail) {
        String sql = "INSERT INTO individual_customer_details (pin, customer_id, unique_id_name, unique_id_value, birth_country_id, birth_city_id, id_begin_date, id_end_date, image, birthdate, gender, marital_status, work_place, position) VALUES(:pin, :customerId, :uniqueIdName, :uniqueIdValue, :birthCountryId, :birthCityId, :idBeginDate, :idEndDate, :image, :birthdate, :gender, :maritalStatus, :workPlace, :position)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("pin", individualCustomerDetail.getPin())
                        .addValue("customerId", customerId)
                        .addValue("uniqueIdName", individualCustomerDetail.getUniqueIdName())
                        .addValue("uniqueIdValue", individualCustomerDetail.getUniqueIdValue())
                        .addValue("birthCountryId", individualCustomerDetail.getBirthCountryId())
                        .addValue("birthCityId", individualCustomerDetail.getBirthCityId())
                        .addValue("idBeginDate", individualCustomerDetail.getIdBeginDate())
                        .addValue("idEndDate", individualCustomerDetail.getIdEndDate())
                        .addValue("image", individualCustomerDetail.getImage())
                        .addValue("birthdate", individualCustomerDetail.getBirthdate())
                        .addValue("gender", individualCustomerDetail.getGender().name())
                        .addValue("maritalStatus", individualCustomerDetail.getMaritalStatus().name())
                        .addValue("workPlace", individualCustomerDetail.getWorkPlace())
                        .addValue("position", individualCustomerDetail.getPosition()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public IndividualCustomerDetail getByCustomerId(Integer customerId) {
        String sql = "SELECT * FROM individual_customer_details WHERE customer_id = :customerId";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("customerId", customerId),
                    individualCustomerDetailsRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void update(Integer id, IndividualCustomerDetail individualCustomerDetail) {
        String sql = "UPDATE individual_customer_details SET pin = :pin, customer_id = :customerId, unique_id_name = :uniqueIdName, unique_id_value = :uniqueIdValue, birth_country_id = :birthCountryId, birth_city_id = :birthCityId, id_begin_date = :idBeginDate, id_end_date = :idEndDate, image = :image, birthdate = :birthdate, gender = :gender, marital_status = :maritalStatus, work_place = :workPlace, position = :position WHERE id = :id";

        try {
            jdbc.update(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id)
                            .addValue("pin", individualCustomerDetail.getPin())
                            .addValue("uniqueIdName", individualCustomerDetail.getUniqueIdName())
                            .addValue("uniqueIdValue", individualCustomerDetail.getUniqueIdValue())
                            .addValue("birthCountryId", individualCustomerDetail.getBirthCountryId())
                            .addValue("birthCityId", individualCustomerDetail.getBirthCityId())
                            .addValue("idBeginDate", individualCustomerDetail.getIdBeginDate())
                            .addValue("idEndDate", individualCustomerDetail.getIdEndDate())
                            .addValue("image", individualCustomerDetail.getImage())
                            .addValue("birthdate", individualCustomerDetail.getBirthdate())
                            .addValue("gender", individualCustomerDetail.getGender().name())
                            .addValue("maritalStatus", individualCustomerDetail.getMaritalStatus().name())
                            .addValue("workPlace", individualCustomerDetail.getWorkPlace())
                            .addValue("position", individualCustomerDetail.getPosition()));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

}

