package growlab.customer.domain;

import growlab.customer.enums.Gender;
import growlab.customer.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualCustomerDetail {

    private Integer id;
    private Integer customerId;
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
