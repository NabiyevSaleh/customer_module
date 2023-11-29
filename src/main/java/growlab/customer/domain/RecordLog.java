package growlab.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecordLog {

    private Integer id;
    private LocalDateTime eventTime;
    private Integer customerId;
    private String parameter;
    private String oldValue;
    private String newValue;

}
