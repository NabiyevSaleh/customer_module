package growlab.customer.service;

import growlab.customer.dto.request.CreatedCorporateCustomer;
import org.springframework.stereotype.Service;

@Service
public interface CorporateCustomerService {

    Integer create(CreatedCorporateCustomer createdCorporateCustomer);
}
