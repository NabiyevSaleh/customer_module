package growlab.customer.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndividualCustomerDetailsResponse {

    private Integer pin;
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
