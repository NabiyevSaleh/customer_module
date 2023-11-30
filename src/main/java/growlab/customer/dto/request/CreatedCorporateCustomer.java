package growlab.customer.dto.request;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.CreatedShareholder;
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
    private List<CreatedContactDetail> contactDetails;
    private List<CreatedShareholder> shareholders;

}
