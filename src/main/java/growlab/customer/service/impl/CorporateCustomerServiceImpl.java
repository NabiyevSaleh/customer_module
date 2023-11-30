package growlab.customer.service.impl;

import growlab.customer.domain.Customer;
import growlab.customer.dto.CreatedShareholder;
import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.dto.UpdatedShareholder;
import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import growlab.customer.enums.CustomerType;
import growlab.customer.mapper.CorporateCustomerMapper;
import growlab.customer.repository.CorporateCustomerShareholderRepository;
import growlab.customer.repository.CustomerContactDetailRepository;
import growlab.customer.repository.CustomerRepository;
import growlab.customer.service.CorporateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {

    private final CustomerRepository customerRepository;
    private final CorporateCustomerMapper customerMapper;
    private final CustomerContactDetailRepository customerContactDetailRepository;
    private final CorporateCustomerShareholderRepository corporateCustomerShareholderRepository;

    @Override
    public Integer create(CreatedCorporateCustomer request) {
        Customer customer = customerMapper.toEntity(request);
        customer.setCustomerType(CustomerType.CORPORATE);
        customer.setCreatedAt(LocalDateTime.now());
        Integer corporateCustomerId = customerRepository.create(customer);


//        List<CreatedCustomerContactDetail> createdCustomerContactDetails
//                = createdCorporateCustomer.getCreatedCustomerContactDetails();
//
//        for (CreatedCustomerContactDetail createdCustomerContactDetail : createdCustomerContactDetails) {
//            CustomerContactDetail customerContactDetail = modelMapper
//                    .map(createdCustomerContactDetail, CustomerContactDetail.class);
//            customerContactDetailRepository.create(customerContactDetail);
//        }
//
//        List<CreatedCorporateCustomerShareholder> createdCorporateCustomerShareholders
//                = createdCorporateCustomer.getCreatedCorporateCustomerShareholders();
//
//        for (CreatedCorporateCustomerShareholder createdCorporateCustomerShareholder : createdCorporateCustomerShareholders) {
//            CorporateCustomerShareholder corporateCustomerShareholder = modelMapper
//                    .map(createdCorporateCustomerShareholder, CorporateCustomerShareholder.class);
//            corporateCustomerShareholderRepository.create(corporateCustomerShareholder);
//        }
        return corporateCustomerId;
    }

//    @Override
//    public CorporateCustomerResponse getById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public List<CorporateCustomerResponse> getAll() {
//        return null;
//    }

    @Override
    public void update(Integer id, UpdatedCorporateCustomer updatedCorporateCustomer) {

    }

    @Override
    public Integer addShareholder(CreatedShareholder createdShareholder) {
        return null;
    }

    @Override
    public void updatedShareholder(Integer shareholderId, UpdatedShareholder updatedShareholder) {

    }

    @Override
    public Integer addContactDetail(CreatedContactDetail createdContactDetail) {
        return null;
    }

    @Override
    public void updateContactDetail(Integer contactDetailId, UpdatedContactDetail updatedContactDetail) {

    }
}
