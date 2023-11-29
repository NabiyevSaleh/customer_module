package growlab.customer.dto;

import lombok.Data;

@Data
public class CreatedCorporateCustomerDetail {

    private Integer customerId;
    private Integer inn;
    private String registerTaxAuthority;

}
