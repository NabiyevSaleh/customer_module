package growlab.customer.dto;

import lombok.Data;

@Data
public class CreatedShareholder {

    private Integer customerId;
    private String shareholder;
    private Double sharePercent;

}
