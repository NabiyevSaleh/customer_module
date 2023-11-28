package growlab.customer.service;

import growlab.customer.dto.IndividualCustomerDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface IndividualCustomerDetailsService {
    Integer create(IndividualCustomerDetailsRequest individualCustomerDetailsRequest);


}
