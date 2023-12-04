package growlab.customer.repository;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
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
public class CorporateCustomerShareholderRepository {

    private static final String NOT_FOUND_MESSAGE = "Shareholder not found";
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
            List<CorporateCustomerShareholder> result = jdbc.query(sql,
                    new MapSqlParameterSource()
                            .addValue("customerId", customerId),
                    corporateCustomerShareholderRowMapper);
            return result;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public List<CorporateCustomerShareholder> getAll() {
        String sql = "SELECT * FROM corporate_customer_shareholder";
        try {
            return jdbc.query(sql, corporateCustomerShareholderRowMapper);
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
