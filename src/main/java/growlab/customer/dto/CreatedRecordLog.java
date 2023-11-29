package growlab.customer.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatedRecordLog {

    private LocalDateTime eventTime;
    private Integer customerId;
    private String parameter;
    private String oldValue;
    private String newValue;

}
