package growlab.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorporateCustomerDetail { //sil

    private Integer id;
    private Integer customerId;
    private Integer inn;
    private String registerTaxAuthority;

}
