package growlab.customer.dto.request;

import lombok.Data;

@Data
public class CreatedCorporateCustomerDetails {

    private Integer customerId;
    private Integer inn;
    private String registerTaxAuthority;

}
