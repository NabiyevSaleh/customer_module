package growlab.customer.service.impl;

import growlab.customer.domain.Customer;
import growlab.customer.domain.CustomerContactDetail;
import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.CreatedShareholder;
import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import growlab.customer.dto.response.ContactDetailResponse;
import growlab.customer.dto.response.CorporateCustomerResponse;
import growlab.customer.dto.response.ShareHolderResponse;
import growlab.customer.enums.CustomerType;
import growlab.customer.mapper.CorporateCustomerMapper;
import growlab.customer.mapper.CustomerContactDetailMapper;
import growlab.customer.mapper.ShareHolderMapper;
import growlab.customer.repository.CorporateCustomerShareholderRepository;
import growlab.customer.repository.CustomerContactDetailRepository;
import growlab.customer.repository.CustomerRepository;
import growlab.customer.service.ContactDetailService;
import growlab.customer.service.CorporateCustomerService;
import growlab.customer.service.ShareHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {

    private final CustomerRepository customerRepository;
    private final CorporateCustomerMapper customerMapper;
    private final ContactDetailService contactDetailService;
    private final ShareHolderService shareHolderService;

    @Override
    public Integer create(CreatedCorporateCustomer request) {
        Customer customer = customerMapper.toEntity(request);
        customer.setCustomerType(CustomerType.CORPORATE);
        customer.setCreatedAt(LocalDateTime.now());
        Integer corporateCustomerId = customerRepository.create(customer);

        for (CreatedContactDetail createdContactDetail : request.getContactDetails()) {
            contactDetailService.addContactDetail(createdContactDetail);
        }

        for (CreatedShareholder createdShareholder : request.getShareholders()) {
            shareHolderService.addShareholder(createdShareholder);
        }

        return corporateCustomerId;
    }

    @Override
    public CorporateCustomerResponse getById(Integer id) {

        Customer customer = customerRepository.getById(id);
        CorporateCustomerResponse customerResponse = customerMapper.toResponse(customer);

        List<ShareHolderResponse> shareHolderResponseList = shareHolderService.shareHolderResponses(customer.getId());
        List<ContactDetailResponse> contactDetailResponseList = contactDetailService.contactDetailResponses(customer.getId());

        customerResponse.setShareHolderResponses(shareHolderResponseList);
        customerResponse.setContactDetailResponses(contactDetailResponseList);

        return customerResponse;
    }

    @Override
    public List<CorporateCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.getAllByType(CustomerType.CORPORATE);
        return customers.stream()
                .map(customer -> getById(customer.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, UpdatedCorporateCustomer request) {

        Customer customer = customerRepository.getById(id);
        customerMapper.updateEntity(customer, request);
        customerRepository.update(id, customer);
    }

}
