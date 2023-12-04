package growlab.customer.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndividualCustomerDetailResponse {

    private String pin;
    private String uniqueIdName;
    private String uniqueIdValue;
    private String birthCountry;
    private String birthCity;
    private LocalDate idBeginDate;
    private LocalDate idEndDate;
    private String image;
    private LocalDate birthDate;
    private String gender;
    private String maritalStatus;
    private String workPlace;
    private String position;
}
