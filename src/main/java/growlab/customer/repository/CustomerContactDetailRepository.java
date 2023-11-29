package growlab.customer.repository;

import growlab.customer.domain.CustomerContactDetail;
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
public class CustomerContactDetailRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<CustomerContactDetail> customerContactDetailRowMapper;

    public Integer create(CustomerContactDetail contactDetails) {
        String sql = "INSERT INTO customer_contact_details (customer_id, contact_type, contact_value, is_active) VALUES (:customerId, :contactType, :contactValue, :isActive)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("customerId", contactDetails.getCustomerId())
                        .addValue("contactType", contactDetails.getContactType())
                        .addValue("contactValue", contactDetails.getContactValue())
                        .addValue("isActive", contactDetails.getIsActive()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public CustomerContactDetail getById(Integer id) {
        String sql = "SELECT * FROM customer_contact_details WHERE id = :id";
        return jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                customerContactDetailRowMapper);
    }

    public List<CustomerContactDetail> getAllByCustomerId(Integer customerId) {
        String sql = "SELECT * FROM customer_contact_details WHERE customerId = :customerId";
        return jdbc.query(sql,
                new MapSqlParameterSource()
                        .addValue("customerId", customerId),
                customerContactDetailRowMapper);
    }

    public void update(Integer id, CustomerContactDetail request) {
        String sql = "UPDATE customer_contact_details SET contact_type = :contactType, contact_value = :contactValue, is_active = :isActive WHERE id = :id";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("contactType", request.getContactType())
                        .addValue("contactValue", request.getContactValue())
                        .addValue("isActive", request.getIsActive())
                        .addValue("id", id));
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM customer_contact_details WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (Exception e) {
        }
    }
}
