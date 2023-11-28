package growlab.customer.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdatedCustomer {

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
    private LocalDate registrationDate;
    private boolean status;
    private String customerCategory;

}
