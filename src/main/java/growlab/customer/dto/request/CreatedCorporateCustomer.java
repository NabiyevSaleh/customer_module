package growlab.customer.dto.request;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.CreatedShareholder;
import growlab.customer.enums.CustomerCategory;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class CreatedCorporateCustomer {

    @NotBlank(message = "Please, provide a name")
    @Size(min = 3, max = 25, message = "The length of the name cannot be less than 3 or longer than 25")
    private String name;
    private Integer legalCountryId;
    private Integer legalCityId;
    private String authority;
    private String voen;
    private LocalDate registrationDate;
    private Integer createdBy;
    private Integer authBy;
    private LocalDate authAt;

    @Min(0)
    @Max(2)
    @NotNull
    private Integer status;

    @NotBlank(message = "Should not be empty")
    private CustomerCategory customerCategory;
    private List<CreatedContactDetail> contactDetails;
    private List<CreatedShareholder> shareholders;

}
