package growlab.customer.dto.request;

import growlab.customer.enums.CustomerCategory;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class UpdatedCorporateCustomer {

    @NotBlank(message = "Please, provide a name")
    @Size(min = 3, max = 25, message = "The length of the name cannot be less than 3 or longer than 25")
    private String name;

    private Integer legalCountryId;
    private Integer legalCityId;
    private String authority;
    private String voen;
    private LocalDate registrationDate;
    private String createdBy;
    private LocalDate createdAt;
    private String authBy;
    private LocalDate authAt;

    @NotBlank(message = "Should not be empty")
    private CustomerCategory customerCategory;
}
