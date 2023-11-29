package growlab.customer.dto.response;

import growlab.customer.enums.ContactType;
import lombok.Data;

@Data
public class CustomerContactDetailResponse {
    private Integer customerId;
    private ContactType contactType;
    private String contactValue;
    private Integer isActive;
}
