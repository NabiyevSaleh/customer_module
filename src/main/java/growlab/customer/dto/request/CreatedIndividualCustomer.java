package growlab.customer.dto.request;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.CreatedIndividualCustomerDetail;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreatedIndividualCustomer {

    private String name;
    private String surname;
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
    private Integer status;
    private String customerCategory;
    private CreatedIndividualCustomerDetail detail;
    private List<CreatedContactDetail> contactDetails;

}
