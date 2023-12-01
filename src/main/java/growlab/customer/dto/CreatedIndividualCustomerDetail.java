package growlab.customer.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatedIndividualCustomerDetail {

    private String pin;
    private String uniqueIdName;
    private String uniqueIdValue;
    private Integer birthCountryId;
    private Integer birthCityId;
    private LocalDate idBeginDate;
    private LocalDate idEndDate;
    private String image;
    private LocalDate birthdate;
    private String gender;
    private String maritalStatus;
    private String workPlace;
    private String position;

}
