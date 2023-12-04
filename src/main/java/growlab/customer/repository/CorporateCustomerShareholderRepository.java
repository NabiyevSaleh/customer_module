package growlab.customer.repository;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CorporateCustomerShareholderRepository {

    private static final String NOT_FOUND_MESSAGE = "Shareholder not found";
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<CorporateCustomerShareholder> corporateCustomerShareholderRowMapper;

    public void create(CorporateCustomerShareholder shareholder) {
        String sql = "INSERT INTO corporate_customer_shareholder (customer_id, shareholder, share_percent) VALUES (:customerId, :shareholder, :sharePercent)";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("customerId", shareholder.getCustomerId())
                        .addValue("shareholder", shareholder.getShareholder())
                        .addValue("sharePercent", shareholder.getSharePercent()));
    }

    public void createAll(List<CorporateCustomerShareholder> shareholders) {
        String sql = "INSERT INTO corporate_customer_shareholder (customer_id, shareholder, share_percent) VALUES (:customerId, :shareholder, :sharePercent)";
        SqlParameterSource[] batchArgs = shareholders.stream()
                .map(shareholder -> new MapSqlParameterSource()
                        .addValue("customerId", shareholder.getCustomerId())
                        .addValue("shareholder", shareholder.getShareholder())
                        .addValue("sharePercent", shareholder.getSharePercent()))
                .toArray(SqlParameterSource[]::new);
        jdbc.batchUpdate(sql, batchArgs);
    }

    public CorporateCustomerShareholder getById(Integer id) {
        String sql = "SELECT * FROM corporate_customer_shareholder WHERE id = :id";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id),
                    corporateCustomerShareholderRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public List<CorporateCustomerShareholder> getAllByCustomerId(Integer customerId) {
        String sql = "SELECT * FROM corporate_customer_shareholder WHERE customer_id = :customerId";
        try {
            return jdbc.query(sql,
                    new MapSqlParameterSource()
                            .addValue("customerId", customerId),
                    corporateCustomerShareholderRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void update(Integer id, CorporateCustomerShareholder shareholder) {
        String sql = "UPDATE corporate_customer_shareholder SET shareholder = :shareholder, share_percent = :sharePercent WHERE id = :id";
        try {
            jdbc.update(sql,
                    new MapSqlParameterSource()
                            .addValue("shareholder", shareholder.getShareholder())
                            .addValue("sharePercent", shareholder.getSharePercent())
                            .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM corporate_customer_shareholder WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void deleteAllByCustomerId(Integer customerId) {
        String sql = "DELETE FROM corporate_customer_shareholder WHERE customer_id = :customerId";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("customerId", customerId));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

}
