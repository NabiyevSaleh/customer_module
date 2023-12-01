package growlab.customer.dto.request;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.CreatedShareholder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
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
    private Integer status;

    @NotBlank(message = "Should not be empty")
    private String customerCategory;
    private List<CreatedContactDetail> contactDetails;
    private List<CreatedShareholder> shareholders;

}
