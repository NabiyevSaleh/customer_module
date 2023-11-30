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

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<City> cityRowMapper;

    public Integer create(City city) {
        String sql = "INSERT INTO cities (country_id, name) VALUES (:countryId, :name)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("countryId", city.getCountryId())
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
            throw new NotFoundException("City not found");
        }
    }

    public List<City> getAll() {
        String sql = "SELECT * FROM cities";
        try {
            return jdbc.query(sql, cityRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("City not found");
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM cities WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("City not found");
        }
    }

}
