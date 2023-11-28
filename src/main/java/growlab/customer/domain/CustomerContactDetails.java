package growlab.customer.domain;

import growlab.customer.enums.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerContactDetails {

    private Integer id;
    private Integer customerId;
    private ContactType contactType;
    private String contactValue;
    private boolean isActive;

}
