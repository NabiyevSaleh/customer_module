package growlab.customer.repository;

import growlab.customer.domain.City;
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
public class CityRepository {

    private static final String NOT_FOUND_MESSAGE = "City not found";
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<City> cityRowMapper;

    public void create(Integer countryId, City city) {
        String sql = "INSERT INTO cities (country_id, name) VALUES (:countryId, :name)";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("countryId", countryId)
                        .addValue("name", city.getName()));
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

    public List<City> getAllByCountryId(Integer countryId) {
        String sql = "SELECT * FROM cities WHERE country_id = :countryId";
        return jdbc.queryForList(sql,
                new MapSqlParameterSource()
                        .addValue("countryId", countryId),
                City.class);
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
