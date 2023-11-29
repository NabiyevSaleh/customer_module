package growlab.customer.service.impl;

import growlab.customer.domain.Customer;
import growlab.customer.domain.CustomerContactDetails;
import growlab.customer.domain.IndividualCustomerDetails;
import growlab.customer.dto.request.CreateIndividualCustomerRequest;
import growlab.customer.dto.request.CreatedCustomer;
import growlab.customer.dto.request.CreatedCustomerContactDetail;
import growlab.customer.repository.CustomerContactDetailRepository;
import growlab.customer.repository.CustomerRepository;
import growlab.customer.repository.IndividualCustomerDetailsRepository;
import growlab.customer.service.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {

    private final CustomerRepository customerRepository;
    private final IndividualCustomerDetailsRepository individualCustomerDetailsRepository;
    private final CustomerContactDetailRepository customerContactDetailRepository;
    private final ModelMapper modelMapper;

    @Override
    public Integer create(CreateIndividualCustomerRequest createIndividualCustomerRequest) {

        Customer customer = modelMapper
                .map(createIndividualCustomerRequest, Customer.class);
        Integer individualCustomerId = customerRepository.create(customer);

        IndividualCustomerDetails individualCustomerDetails = modelMapper
                .map(createIndividualCustomerRequest.getIndividualCustomerDetailsRequest(), IndividualCustomerDetails.class);
        individualCustomerDetailsRepository.create(individualCustomerId, individualCustomerDetails);

        List<CreatedCustomerContactDetail> createdCustomerContactDetails
                = createIndividualCustomerRequest.getCreatedCustomerContactDetails();

        for (CreatedCustomerContactDetail createdCustomerContactDetail : createdCustomerContactDetails) {
            CustomerContactDetails customerContactDetails = modelMapper
                    .map(createdCustomerContactDetail, CustomerContactDetails.class);
            customerContactDetailRepository.create(customerContactDetails);
        }

        return individualCustomerId;
    }

    @Override
    public Integer addContactDetail(CreatedCustomerContactDetail createdCustomerContactDetail) {
        CustomerContactDetails customerContactDetails = modelMapper
                .map(createdCustomerContactDetail, CustomerContactDetails.class);

        Integer contactId = customerContactDetailRepository.create(customerContactDetails);
        return contactId;
    }
}
