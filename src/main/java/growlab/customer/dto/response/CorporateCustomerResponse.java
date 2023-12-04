package growlab.customer.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CorporateCustomerResponse {

    private Integer internalId;
    private String name;
    private String legalCountry;
    private String legalCity;
    private String authority;
    private Integer voen;
    private String createdBy;
    private LocalDate createdAt;
    private String authBy;
    private LocalDate authAt;
    private Integer status;
    private String customerCategory;
    private List<ShareholderResponse> shareholderRespons;
    private List<ContactDetailResponse> contactDetailResponses;

}
