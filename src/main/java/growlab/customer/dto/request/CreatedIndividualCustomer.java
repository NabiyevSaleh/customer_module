package growlab.customer.dto.request;

import growlab.customer.enums.CustomerCategory;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class CreatedIndividualCustomer {

    @NotBlank(message = "Please, provide a name")
    @Size(min = 3, max = 25, message = "The length of the name cannot be less than 3 or longer than 25")
    private String name;

    @NotBlank(message = "Please, provide a surname")
    @Size(min = 3, max = 25, message = "The length of the surname cannot be less than 3 or longer than 25")
    private String surname;

    @NotBlank(message = "Please, provide a middle name")
    @Size(min = 3, max = 25, message = "The length of the middle name cannot be less than 3 or longer than 25")
    private String middleName;

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

    @Min(0)
    @Max(2)
    @NotNull
    private Integer status;

    @NotBlank(message = "Should not be empty")
    private CustomerCategory customerCategory;
    private CreatedIndividualCustomerDetail detail;
    private List<CreatedContactDetail> contactDetails;

}
