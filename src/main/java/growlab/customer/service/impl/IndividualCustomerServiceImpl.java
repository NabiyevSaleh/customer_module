package growlab.customer.service.impl;

import growlab.customer.domain.Customer;
import growlab.customer.domain.CustomerContactDetail;
import growlab.customer.domain.IndividualCustomerDetail;
import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.ContactDetailResponse;
import growlab.customer.dto.response.IndividualCustomerDetailResponse;
import growlab.customer.dto.response.IndividualCustomerResponse;
import growlab.customer.enums.CustomerType;
import growlab.customer.mapper.CustomerContactDetailMapper;
import growlab.customer.mapper.IndividualCustomerMapper;
import growlab.customer.mapper.IndividualCustomerDetailMapper;
import growlab.customer.repository.CustomerContactDetailRepository;
import growlab.customer.repository.CustomerRepository;
import growlab.customer.repository.IndividualCustomerDetailRepository;
import growlab.customer.service.ContactDetailService;
import growlab.customer.service.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {

    private final CustomerRepository customerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;
    private final IndividualCustomerDetailRepository detailRepository;
    private final IndividualCustomerDetailMapper detailMapper;
    private final CustomerContactDetailRepository contactDetailRepository;
    private final CustomerContactDetailMapper contactDetailMapper;
    private final ContactDetailService contactDetailService;

    @Override
    public Integer create(CreatedIndividualCustomer request) {

        Customer customer = individualCustomerMapper.toEntity(request);
        customer.setCustomerType(CustomerType.INDIVIDUAL);
        customer.setCreatedAt(LocalDateTime.now());
        Integer individualCustomerId = customerRepository.create(customer);

        IndividualCustomerDetail detail = detailMapper.toEntity(request.getDetail());
        detailRepository.create(individualCustomerId, detail);

        for (CreatedContactDetail createdContactDetail : request.getContactDetails()) {
            contactDetailService.addContactDetail(createdContactDetail);
        }

        return individualCustomerId;
    }

    @Override
    public IndividualCustomerResponse getById(Integer id) {
        Customer customer = customerRepository.getById(id);
        IndividualCustomerDetail detail = detailRepository.getByCustomerId(id);
        List<CustomerContactDetail> contactDetails = contactDetailRepository.getAllByCustomerId(id);

        IndividualCustomerResponse customerResponse = individualCustomerMapper.toResponse(customer);
        IndividualCustomerDetailResponse detailResponse = detailMapper.toResponse(detail);
        List<ContactDetailResponse> contactDetailResponseList = contactDetails.stream()
                .map(contactDetailMapper::toResponse)
                .collect(Collectors.toList());

        customerResponse.setIndividualCustomerDetailResponse(detailResponse);
        customerResponse.setContactDetailRespons(contactDetailResponseList);

        return customerResponse;
    }

    @Override
    public List<IndividualCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.getAllByType(CustomerType.INDIVIDUAL);
        return customers.stream()
                .map(customer -> getById(customer.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, UpdatedIndividualCustomer request) {
        Customer customer = customerRepository.getById(id);
        individualCustomerMapper.updateEntity(customer, request);
        customerRepository.update(id, customer);

        IndividualCustomerDetail detail = detailMapper.toEntity(request.getDetail());
        Integer detailId = detailRepository.getByCustomerId(id).getId();
        detailRepository.update(detailId, detail);
    }

}
