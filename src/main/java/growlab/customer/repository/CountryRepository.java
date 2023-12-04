package growlab.customer.repository;

import growlab.customer.domain.Country;
import growlab.customer.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CountryRepository {

    private static final String NOT_FOUND_MESSAGE = "Country not found";
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Country> countryRowMapper;

    public void create(Country country) {
        String sql = "INSERT INTO countries (name) VALUES (:name)";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("name", country.getName()));
    }

    public Country getById(Integer id) {
        String sql = "SELECT * FROM countries WHERE id = :id";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id),
                    countryRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public List<Country> getAll() {
        String sql = "SELECT * FROM countries";
        try {
            return jdbc.query(sql, countryRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM countries WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

}
