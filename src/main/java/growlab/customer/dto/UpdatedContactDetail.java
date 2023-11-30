package growlab.customer.dto;

import growlab.customer.enums.ContactType;
import lombok.Data;

@Data
public class UpdatedContactDetail {

    private ContactType contactType;
    private String contactValue;
    private Integer isActive;

}