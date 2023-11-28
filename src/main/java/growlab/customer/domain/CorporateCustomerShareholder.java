package growlab.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorporateCustomerShareholder {

    private Integer id;
    private Integer customerId;
    private String shareholder;
    private Integer sharePercent;

}
