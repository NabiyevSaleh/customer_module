package growlab.customer.dto.request;

import growlab.customer.domain.CustomerContactDetails;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateIndividualCustomerRequest {

    private Integer internalId;
    private String name;
    private String surname;
    private String middleName;
    private Integer legalCountryId;
    private Integer legalCityId;
    private String registrationAddress1;
    private String registrationAddress2;
    private String registrationAddress3;
    private String registrationAddress4;
    private String residentialAddress1;
    private String residentialAddress2;
    private String residentialAddress3;
    private String residentialAddress4;
    private String authority;
    private Integer voen;
    private String customerType;
    private LocalDate registrationDate;
    private Integer createdBy;
    private LocalDate createdAt;
    private Integer authBy;
    private LocalDate authAt;
    private Integer status;
    private String customerCategory;
    private IndividualCustomerDetailsRequest individualCustomerDetailsRequest;
    private List<CreatedCustomerContactDetail> createdCustomerContactDetails;
}
