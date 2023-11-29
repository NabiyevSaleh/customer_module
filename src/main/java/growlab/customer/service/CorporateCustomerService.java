package growlab.customer.service;

import growlab.customer.dto.request.CreateCorporateCustomerRequest;
import growlab.customer.dto.request.CreateIndividualCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CorporateCustomerService {

    Integer create(CreateCorporateCustomerRequest createCorporateCustomerRequest);
}
