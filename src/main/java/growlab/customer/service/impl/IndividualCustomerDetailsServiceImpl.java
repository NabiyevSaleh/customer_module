package growlab.customer.service.impl;

import growlab.customer.domain.IndividualCustomerDetails;
import growlab.customer.dto.request.IndividualCustomerDetailsRequest;
import growlab.customer.dto.response.IndividualCustomerDetailsResponse;
import growlab.customer.repository.IndividualCustomerDetailsRepository;
import growlab.customer.service.IndividualCustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public IndividualCustomerDetailsResponse getById(Integer id) {
        IndividualCustomerDetails individualCustomerDetails = individualCustomerDetailsRepository.getById(id);
        IndividualCustomerDetailsResponse individualCustomerDetailsResponse = modelMapper
                .map(individualCustomerDetails, IndividualCustomerDetailsResponse.class);
        return individualCustomerDetailsResponse;
    }

    @Override
    public List<IndividualCustomerDetailsResponse> getAll() {
        List<IndividualCustomerDetailsResponse> individualCustomerDetailsResponses =
                individualCustomerDetailsRepository.findAll().stream()
                        .map(customerDetails -> modelMapper.map(customerDetails, IndividualCustomerDetailsResponse.class))
                        .collect(Collectors.toList());
        return individualCustomerDetailsResponses;
    }

    @Override
    public void update(Integer id, IndividualCustomerDetailsRequest individualCustomerDetailsRequest) {
        IndividualCustomerDetails individualCustomerDetails = modelMapper
                .map(individualCustomerDetailsRequest, IndividualCustomerDetails.class);

        individualCustomerDetailsRepository.update(id, individualCustomerDetails);
    }

    @Override
    public void delete(Integer id) {
        individualCustomerDetailsRepository.delete(id);
    }
}
