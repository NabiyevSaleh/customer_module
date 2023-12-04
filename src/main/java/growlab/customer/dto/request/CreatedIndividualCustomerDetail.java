package growlab.customer.dto.request;

import growlab.customer.enums.Gender;
import growlab.customer.enums.MaritalStatus;
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
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String workPlace;
    private String position;

}
