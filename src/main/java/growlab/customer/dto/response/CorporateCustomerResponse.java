package growlab.customer.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CorporateCustomerResponse {

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
    private Integer voen;
    private Integer createdBy;
    private LocalDate createdAt;
    private Integer authBy;
    private LocalDate authAt;
    private Integer status;
    private String customerCategory;
    private List<ShareHolderResponse> shareHolderResponses;
    private List<ContactDetailResponse> contactDetailResponses;
}
