package growlab.customer.dto;

import lombok.Data;

@Data
public class CreatedCorporateCustomerShareholder {

    private Integer customerId;
    private String shareholder;
    private Double sharePercent;

}
