package growlab.customer.service.impl;

import growlab.customer.domain.Customer;
import growlab.customer.domain.CustomerContactDetail;
import growlab.customer.domain.IndividualCustomerDetail;
import growlab.customer.dto.CreatedCustomerContactDetail;
import growlab.customer.dto.UpdatedCustomerContactDetail;
import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.CustomerContactDetailResponse;
import growlab.customer.dto.response.IndividualCustomerDetailResponse;
import growlab.customer.dto.response.IndividualCustomerResponse;
import growlab.customer.enums.CustomerType;
import growlab.customer.mapper.CustomerContactDetailMapper;
import growlab.customer.mapper.IndividualCustomerMapper;
import growlab.customer.mapper.IndividualCustomerDetailMapper;
import growlab.customer.repository.CustomerContactDetailRepository;
import growlab.customer.repository.CustomerRepository;
import growlab.customer.repository.IndividualCustomerDetailRepository;
import growlab.customer.service.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {

    private final CustomerRepository customerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;
    private final IndividualCustomerDetailRepository detailRepository;
    private final IndividualCustomerDetailMapper detailMapper;
    private final CustomerContactDetailRepository contactDetailRepository;
    private final CustomerContactDetailMapper contactDetailMapper;

    @Override
    public Integer create(CreatedIndividualCustomer request) {

        Customer customer = individualCustomerMapper.toEntity(request);
        customer.setCustomerType(CustomerType.INDIVIDUAL);
        customer.setCreatedAt(LocalDateTime.now());
        Integer individualCustomerId = customerRepository.create(customer);

        IndividualCustomerDetail detail = detailMapper.toEntity(request.getDetail());
        detailRepository.create(individualCustomerId, detail);

        for (CreatedCustomerContactDetail createdContactDetail : request.getContactDetails()) {
            addContactDetail(createdContactDetail);
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
        List<CustomerContactDetailResponse> contactDetailResponseList = contactDetails.stream()
                .map(contactDetailMapper::toResponse)
                .toList();

        customerResponse.setIndividualCustomerDetailResponse(detailResponse);
        customerResponse.setCustomerContactDetailResponses(contactDetailResponseList);

        return customerResponse;
    }

    @Override
    public List<IndividualCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.getAllByType(CustomerType.INDIVIDUAL);
        return customers.stream()
                .map(customer -> getById(customer.getId()))
                .toList();
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

    @Override
    public Integer addContactDetail(CreatedCustomerContactDetail createdContactDetail) {
        CustomerContactDetail contactDetail = contactDetailMapper.toEntity(createdContactDetail);
        return contactDetailRepository.create(contactDetail);
    }

    @Override
    public void updateContactDetail(Integer contactDetailId, UpdatedCustomerContactDetail updatedCustomerContactDetail) {
        CustomerContactDetail contactDetail = contactDetailRepository.getById(contactDetailId);
        contactDetailMapper.updateEntity(contactDetail, updatedCustomerContactDetail);
        contactDetailRepository.update(contactDetailId, contactDetail);
    }

}
