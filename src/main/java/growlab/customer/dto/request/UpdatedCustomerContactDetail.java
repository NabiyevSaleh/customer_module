package growlab.customer.dto.request;

import growlab.customer.enums.ContactType;
import lombok.Data;

@Data
public class UpdatedCustomerContactDetail {

    private ContactType contactType;
    private String contactValue;
    private boolean isActive;

}
