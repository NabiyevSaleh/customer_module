package growlab.customer.repository;

import growlab.customer.domain.Country;
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
public class CountryRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Country> countryRowMapper;

    public Integer create(Country country) {
        String sql = "INSERT INTO countries (name) VALUES (:name)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("name", country.getName()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Country getById(Integer id) {
        String sql = "SELECT * FROM countries WHERE id = :id";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id),
                    countryRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Country not found");
        }
    }

    public List<Country> getAll() {
        String sql = "SELECT * FROM countries";
        try {
            return jdbc.query(sql, countryRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Country not found");
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM countries WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (Exception e) {
        }
    }

}
