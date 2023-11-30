package growlab.customer.repository;

import growlab.customer.domain.RecordLog;
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
public class RecordLogRepository {

    private static final String NOT_FOUND_MESSAGE = "Record log not found";
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<RecordLog> recordLogRowMapper;

    public Integer create(RecordLog recordLog) {
        String sql = "INSERT INTO record_logs (event_time, customer_id, parameter, old_value, new_value) VALUES (:eventTime, :customerId, :parameter, :oldValue, :newValue)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("eventTime", recordLog.getEventTime())
                        .addValue("customerId", recordLog.getCustomerId())
                        .addValue("parameter", recordLog.getParameter())
                        .addValue("oldValue", recordLog.getOldValue())
                        .addValue("newValue", recordLog.getNewValue()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public RecordLog getById(Integer id) {
        String sql = "SELECT * FROM record_logs WHERE id = :id";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id),
                    recordLogRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public List<RecordLog> getAll() {
        String sql = "SELECT * FROM corporate_customer_details";
        try {
            return jdbc.query(sql, recordLogRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

}
