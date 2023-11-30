package growlab.customer.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdatedCorporateCustomer {

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
}
