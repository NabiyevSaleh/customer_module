package growlab.customer.dto;

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
}
