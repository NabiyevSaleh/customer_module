package growlab.customer.service;

import growlab.customer.dto.request.CreateIndividualCustomerRequest;
import growlab.customer.dto.request.CreatedCustomerContactDetail;
import growlab.customer.dto.request.IndividualCustomerDetailsRequest;
import org.springframework.stereotype.Service;

@Service
public interface IndividualCustomerService {

    Integer create(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    Integer addContactDetail(CreatedCustomerContactDetail createdCustomerContactDetail);
}
