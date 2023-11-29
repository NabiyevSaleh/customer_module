package growlab.customer.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndividualCustomerDetailsRequest {

    private String pin;
    private Integer customerId;
    private String uniqueIdName;
    private String uniqueIdValue;
    private Integer birthCountryId;
    private Integer birthCityId;
    private LocalDate idBeginDate;
    private LocalDate idEndDate;
    private String image;
    private LocalDate birthDate;
    private String gender;
    private String maritalStatus;
    private String workPlace;
    private String position;

}
