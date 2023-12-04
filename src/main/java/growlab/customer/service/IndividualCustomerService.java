package growlab.customer.service;

import growlab.customer.domain.Customer;
import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.IndividualCustomerResponse;
import growlab.customer.enums.CustomerType;
import growlab.customer.mapper.IndividualCustomerMapper;
import growlab.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerService {

    private final CustomerRepository customerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;
    private final IndividualCustomerDetailService detailService;
    private final ContactDetailService contactDetailService;
    private final CityService cityService;

    @Transactional
    public Integer create(CreatedIndividualCustomer request) {
        cityService.checkCompatibilityWithCountry(
                request.getDetail().getBirthCityId(),
                request.getDetail().getBirthCountryId());

        Customer customer = individualCustomerMapper.toEntity(request);
        customer.setCustomerType(CustomerType.INDIVIDUAL);
        Integer customerId = customerRepository.create(customer);

        detailService.create(customerId, request.getDetail());
        contactDetailService.createContactDetails(customerId, request.getContactDetails());

        return customerId;
    }

    public IndividualCustomerResponse getById(Integer id) {
        Customer customer = customerRepository.getIndividualCustomerById(id);
        return mapToResponse(customer);
    }

    public List<IndividualCustomerResponse> getAll() {
        return customerRepository.getAllByType(CustomerType.INDIVIDUAL).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public void update(Integer id, UpdatedIndividualCustomer request) {
        cityService.checkCompatibilityWithCountry(
                request.getDetail().getBirthCityId(),
                request.getDetail().getBirthCountryId());

        Customer customer = customerRepository.getIndividualCustomerById(id);
        individualCustomerMapper.updateEntity(customer, request);
        customerRepository.update(id, customer);

        detailService.update(id, request.getDetail());
    }

    public void delete(Integer id) {
        contactDetailService.deleteAllByCustomerId(id);
        customerRepository.delete(id);
    }

    private IndividualCustomerResponse mapToResponse(Customer customer) {
        IndividualCustomerResponse response = individualCustomerMapper.toResponse(customer);

        Integer id = customer.getId();
        response.setIndividualCustomerDetailResponse(detailService.getByCustomerId(id));
        response.setContactDetailResponses(contactDetailService.getAllByCustomerId(id));

        return response;
    }

}

