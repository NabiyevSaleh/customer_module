package growlab.customer.service.impl;

import growlab.customer.domain.Customer;
import growlab.customer.dto.request.CreatedContactDetail;
import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.CreatedShareholder;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import growlab.customer.dto.response.*;
import growlab.customer.enums.CustomerType;
import growlab.customer.mapper.CorporateCustomerMapper;
import growlab.customer.repository.CustomerRepository;
import growlab.customer.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {

    private final CustomerRepository customerRepository;
    private final CorporateCustomerMapper customerMapper;
    private final ContactDetailService contactDetailService;
    private final ShareHolderService shareHolderService;
    private final CountryService countryService;
    private final CityService cityService;

    @Override
    public Integer create(CreatedCorporateCustomer request) {
        Customer customer = customerMapper.toEntity(request);
        customer.setCustomerType(CustomerType.CORPORATE);
        Integer corporateCustomerId = customerRepository.create(customer);

        for (CreatedContactDetail createdContactDetail : request.getContactDetails()) {
            contactDetailService.addContactDetail(corporateCustomerId, createdContactDetail);
        }

        for (CreatedShareholder createdShareholder : request.getShareholders()) {
            shareHolderService.addShareholder(corporateCustomerId, createdShareholder);
        }

        return corporateCustomerId;
    }

    @Override
    public CorporateCustomerResponse getById(Integer id) {
        Customer customer = customerRepository.getCorporateCustomerById(id);
        CorporateCustomerResponse customerResponse = customerMapper.toResponse(customer);
        CountryResponse country = countryService.getById(customer.getLegalCountryId());
        CityResponse city = cityService.getById(customer.getLegalCityId());
        customerResponse.setLegalCountry(country.getName());
        customerResponse.setLegalCity(city.getName());

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

        Customer customer = customerRepository.getCorporateCustomerById(id);
        customerMapper.updateEntity(customer, request);
        customerRepository.update(id, customer);
    }

    @Override
    public void delete(Integer id) {
        contactDetailService.deleteAllByCustomerId(id);
        shareHolderService.deleteAllByCustomerId(id);
        customerRepository.delete(id);
    }
}
