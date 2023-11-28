package growlab.customer.service;

import growlab.customer.domain.IndividualCustomerDetails;
import growlab.customer.dto.IndividualCustomerDetailsRequest;
import growlab.customer.dto.IndividualCustomerDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface IndividualCustomerDetailsService {
    Integer create(IndividualCustomerDetailsRequest individualCustomerDetailsRequest);
    IndividualCustomerDetailsResponse getById(Integer id);

}
