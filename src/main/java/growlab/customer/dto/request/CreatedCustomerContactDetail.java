package growlab.customer.dto.request;

import growlab.customer.enums.ContactType;
import lombok.Data;

@Data
public class CreatedCustomerContactDetail {

    private Integer customerId;
    private ContactType contactType;
    private String contactValue;
    private boolean isActive;

}
