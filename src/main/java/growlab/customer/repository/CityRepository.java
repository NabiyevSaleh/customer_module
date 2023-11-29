package growlab.customer.repository;

import growlab.customer.domain.City;
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
        return jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                cityRowMapper);
    }

    public List<City> getAll() {
        String sql = "SELECT * FROM cities";
        return jdbc.query(sql, cityRowMapper);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM cities WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (Exception e) {
        }
    }

}
