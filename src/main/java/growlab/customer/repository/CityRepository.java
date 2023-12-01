package growlab.customer.repository;

import growlab.customer.domain.City;
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
public class CityRepository {

    private static final String NOT_FOUND_MESSAGE = "City not found";
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<City> cityRowMapper;

    public Integer create(Integer countryId, City city) {
        String sql = "INSERT INTO cities (country_id, name) VALUES (:countryId, :name)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("countryId", countryId)
                        .addValue("name", city.getName()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public City getById(Integer id) {
        String sql = "SELECT * FROM cities WHERE id = :id";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id),
                    cityRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public List<City> getAll() {
        String sql = "SELECT * FROM cities";
        try {
            return jdbc.query(sql, cityRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void update() {

    }

    public void delete(Integer id) {
        String sql = "DELETE FROM cities WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void deleteAllByCountryId(Integer countryId) {
        String sql = "DELETE FROM cities WHERE country_id = :countryId";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("countryId", countryId));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

}
