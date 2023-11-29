package growlab.customer.repository;

import growlab.customer.domain.CorporateCustomerDetails;
import growlab.customer.dto.request.CreatedCorporateCustomerDetails;
import growlab.customer.dto.request.UpdatedCorporateCustomerDetails;
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
public class CorporateCustomerDetailRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<CorporateCustomerDetails> corporateCustomerDetailsRowMapper;

    public Integer create(CreatedCorporateCustomerDetails request) {
        String sql = "INSERT INTO corporate_customer_details (customer_id, inn, register_tax_authority) VALUES (:customerId, :inn, :registerTaxAuthority)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("customerId", request.getCustomerId())
                        .addValue("inn", request.getInn())
                        .addValue("registerTaxAuthority", request.getRegisterTaxAuthority()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public CorporateCustomerDetails getById(Integer id) {
        String sql = "SELECT * FROM corporate_customer_details WHERE id = :id";
        return jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                corporateCustomerDetailsRowMapper);
    }

    public List<CorporateCustomerDetails> getAll() {
        String sql = "SELECT * FROM corporate_customer_details";
        return jdbc.query(sql, corporateCustomerDetailsRowMapper);
    }

    public void update(Integer id, UpdatedCorporateCustomerDetails request) {
        String sql = "UPDATE corporate_customer_details SET inn = :inn, register_tax_authority = :registerTaxAuthority WHERE id = :id";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("inn", request.getInn())
                        .addValue("registerTaxAuthority", request.getRegisterTaxAuthority())
                        .addValue("id", id));
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM corporate_customer_details WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (Exception e) {
        }
    }

}