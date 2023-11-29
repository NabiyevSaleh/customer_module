package growlab.customer.dto.request;

import growlab.customer.dto.CreatedCustomerContactDetail;
import growlab.customer.dto.CreatedIndividualCustomerDetailDto;
import growlab.customer.dto.UpdatedIndividualCustomerDetailDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreatedIndividualCustomer {

    private Integer internalId;
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
    private Integer createdBy;
    private Integer authBy;
    private LocalDateTime authAt;
    private Integer status;
    private String customerCategory;
    private CreatedIndividualCustomerDetailDto detail;
    private List<CreatedCustomerContactDetail> contactDetails;
}
