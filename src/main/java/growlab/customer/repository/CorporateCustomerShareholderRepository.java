package growlab.customer.repository;

import growlab.customer.domain.CorporateCustomerShareholder;
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

    public Integer create(CorporateCustomerShareholder shareholder) {
        String sql = "INSERT INTO corporate_customer_shareholder (customer_id, shareholder, share_percent) VALUES (:customerId, :shareholder, :sharePercent)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("customerId", shareholder.getCustomerId())
                        .addValue("shareholder", shareholder.getShareholder())
                        .addValue("sharePercent", shareholder.getSharePercent()),
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

    public void update(Integer id, CorporateCustomerShareholder shareholder) {
        String sql = "UPDATE corporate_customer_shareholder SET shareholder = :shareholder, share_percent = :sharePercent WHERE id = :id";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("shareholder", shareholder.getShareholder())
                        .addValue("sharePercent", shareholder.getSharePercent())
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
