package growlab.customer.domain;

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
    private Integer InternalId;
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
    private boolean status;
    private String customerCategory;
}
