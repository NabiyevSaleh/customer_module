package growlab.customer.dto.request;

import growlab.customer.dto.UpdatedIndividualCustomerDetail;
import lombok.Data;

@Data
public class UpdatedIndividualCustomer {

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
    private UpdatedIndividualCustomerDetail detail;
}
