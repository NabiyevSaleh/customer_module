package growlab.customer.service.impl;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.domain.Customer;
import growlab.customer.domain.CustomerContactDetails;
import growlab.customer.dto.request.CreateCorporateCustomerRequest;
import growlab.customer.dto.request.CreatedCorporateCustomerShareholder;
import growlab.customer.dto.request.CreatedCustomerContactDetail;
import growlab.customer.repository.CorporateCustomerShareholderRepository;
import growlab.customer.repository.CustomerContactDetailRepository;
import growlab.customer.repository.CustomerRepository;
import growlab.customer.service.CorporateCustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerContactDetailRepository customerContactDetailRepository;
    private final CorporateCustomerShareholderRepository corporateCustomerShareholderRepository;
    private final ModelMapper modelMapper;

    @Override
    public Integer create(CreateCorporateCustomerRequest createCorporateCustomerRequest) {

        Customer customer = modelMapper
                .map(createCorporateCustomerRequest, Customer.class);
        Integer corporateCustomerId = customerRepository.create(customer);

        List<CreatedCustomerContactDetail> createdCustomerContactDetails
                = createCorporateCustomerRequest.getCreatedCustomerContactDetails();

        for (CreatedCustomerContactDetail createdCustomerContactDetail : createdCustomerContactDetails) {
            CustomerContactDetails customerContactDetails = modelMapper
                    .map(createdCustomerContactDetail, CustomerContactDetails.class);
            customerContactDetailRepository.create(customerContactDetails);
        }

        List<CreatedCorporateCustomerShareholder> createdCorporateCustomerShareholders
                = createCorporateCustomerRequest.getCreatedCorporateCustomerShareholders();

        for (CreatedCorporateCustomerShareholder createdCorporateCustomerShareholder : createdCorporateCustomerShareholders) {
            CorporateCustomerShareholder corporateCustomerShareholder = modelMapper
                    .map(createdCorporateCustomerShareholder, CorporateCustomerShareholder.class);
            corporateCustomerShareholderRepository.create(corporateCustomerShareholder);
        }
        return corporateCustomerId;
    }
}
