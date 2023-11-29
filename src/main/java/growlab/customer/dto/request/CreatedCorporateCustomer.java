package growlab.customer.dto.request;

import growlab.customer.domain.CorporateCustomerDetail;
import growlab.customer.dto.CreatedCorporateCustomerShareholder;
import growlab.customer.dto.CreatedCustomerContactDetail;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class CreatedCorporateCustomer {

    private Integer internalId;
    private String name;
    private Integer legalCountryId;
    private Integer legalCityId;
    private String authority;
    private String voen;
    private LocalDate registrationDate;
    private Integer createdBy;
    private Integer authBy;
    private LocalDate authAt;
    private Integer status;
    private String customerCategory;
    private CorporateCustomerDetail detail;
    private List<CreatedCustomerContactDetail> contactDetails;
    private List<CreatedCorporateCustomerShareholder> shareholders;

}
