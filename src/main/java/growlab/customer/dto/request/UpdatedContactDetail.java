package growlab.customer.dto.request;

import growlab.customer.enums.ContactType;
import lombok.Data;

@Data
public class UpdatedContactDetail {

    private ContactType contactType;
    private String contactValue;

}
