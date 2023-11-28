package growlab.customer.repository;

import growlab.customer.domain.RecordLogs;
import growlab.customer.dto.request.CreatedRecordLog;
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
public class RecordLogRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<RecordLogs> recordLogRowMapper;

    public Integer create(CreatedRecordLog request) {
        String sql = "INSERT INTO record_logs (event_time, customer_id, parameter, old_value, new_value) VALUES (:eventTime, :customerId, :parameter, :oldValue, :newValue)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("eventTime", request.getEventTime())
                        .addValue("customerId", request.getCustomerId())
                        .addValue("parameter", request.getParameter())
                        .addValue("oldValue", request.getOldValue())
                        .addValue("newValue", request.getNewValue()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public RecordLogs getById(Integer id) {
        String sql = "SELECT * FROM record_logs WHERE id = :id";
        return jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                recordLogRowMapper);
    }

    public List<RecordLogs> getAll() {
        String sql = "SELECT * FROM corporate_customer_details";
        return jdbc.query(sql, recordLogRowMapper);
    }

}
