package growlab.customer.repository;

import growlab.customer.domain.CorporateCustomerDetails;
import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.dto.request.CreatedCorporateCustomerDetails;
import growlab.customer.dto.request.CreatedCorporateCustomerShareholder;
import growlab.customer.dto.request.UpdatedCorporateCustomerDetails;
import growlab.customer.dto.request.UpdatedCorporateCustomerShareholder;
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
public class CorporateCustomerShareholderRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<CorporateCustomerShareholder> corporateCustomerShareholderRowMapper;

    public Integer create(CorporateCustomerShareholder request) {
        String sql = "INSERT INTO corporate_customer_shareholder (customer_id, shareholder, share_percent) VALUES (:customerId, :shareholder, :sharePercent)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("customerId", request.getCustomerId())
                        .addValue("shareholder", request.getShareholder())
                        .addValue("sharePercent", request.getSharePercent()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public CorporateCustomerShareholder getById(Integer id) {
        String sql = "SELECT * FROM corporate_customer_shareholder WHERE id = :id";
        return jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                corporateCustomerShareholderRowMapper);
    }
    public List<CorporateCustomerShareholder> getAll() {
        String sql = "SELECT * FROM corporate_customer_shareholder";
        return jdbc.query(sql, corporateCustomerShareholderRowMapper);
    }

    public void update(Integer id, UpdatedCorporateCustomerShareholder request) {
        String sql = "UPDATE corporate_customer_shareholder SET shareholder = :shareholder, share_percent = :sharePercent WHERE id = :id";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("shareholder", request.getShareholder())
                        .addValue("sharePercent", request.getSharePercent())
                        .addValue("id", id));
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM corporate_customer_shareholder WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (Exception e) {
        }
    }

}
