package growlab.customer.dto;

import growlab.customer.enums.ContactType;
import lombok.Data;

@Data
public class CreatedCustomerContactDetail {

    private Integer customerId;
    private ContactType contactType;
    private String contactValue;
    private Integer isActive;

}
