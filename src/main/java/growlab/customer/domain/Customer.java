package growlab.customer.domain;

import growlab.customer.enums.CustomerCategory;
import growlab.customer.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private Integer id;
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
    private String voen;
    private CustomerType customerType;
    private LocalDate registrationDate;
    private String createdBy;
    private LocalDate createdAt;
    private String authBy;
    private LocalDate authAt;
    private Integer status;
    private CustomerCategory customerCategory;

}
