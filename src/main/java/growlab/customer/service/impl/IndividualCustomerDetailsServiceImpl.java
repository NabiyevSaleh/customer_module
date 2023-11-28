package growlab.customer.service.impl;

import growlab.customer.domain.IndividualCustomerDetails;
import growlab.customer.dto.IndividualCustomerDetailsRequest;
import growlab.customer.repository.IndividualCustomerDetailsRepository;
import growlab.customer.service.IndividualCustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualCustomerDetailsServiceImpl implements IndividualCustomerDetailsService {

    private final IndividualCustomerDetailsRepository individualCustomerDetailsRepository;
    private final ModelMapper modelMapper;

    @Override
    public Integer create(IndividualCustomerDetailsRequest individualCustomerDetailsRequest) {
        IndividualCustomerDetails individualCustomerDetails = modelMapper
                .map(individualCustomerDetailsRequest, IndividualCustomerDetails.class);

        return individualCustomerDetailsRepository.create(individualCustomerDetails);
    }
}
