package growlab.customer.dto.request;

import lombok.Data;

@Data
public class CreatedCorporateCustomerShareholder {

    private Integer customerId;
    private String shareholder;
    private Integer sharePercent;

}
