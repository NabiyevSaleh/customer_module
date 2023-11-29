package growlab.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualCustomerDetails {

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
    private LocalDate birthDate;
    private String gender;
    private String maritalStatus;
    private String workPlace;
    private String position;
    //birtday
    //cins
    //evli/subay
    //ish yeri
    //vezifesi

}
