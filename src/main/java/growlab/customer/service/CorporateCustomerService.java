package growlab.customer.service;

import growlab.customer.domain.Customer;
import growlab.customer.dto.request.CreatedContactDetail;
import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.CreatedShareholder;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import growlab.customer.dto.response.*;
import growlab.customer.enums.CustomerType;
import growlab.customer.mapper.CorporateCustomerMapper;
import growlab.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorporateCustomerService {

    private final CustomerRepository customerRepository;
    private final CorporateCustomerMapper customerMapper;
    private final ContactDetailService contactDetailService;
    private final ShareHolderService shareHolderService;
    private final CountryService countryService;
    private final CityService cityService;

    @Transactional
    public Integer create(CreatedCorporateCustomer request) {
        cityService.checkCompatibilityWithCountry(request.getLegalCityId(), request.getLegalCountryId());

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

    public CorporateCustomerResponse getById(Integer id) {
        Customer customer = customerRepository.getCorporateCustomerById(id);
        return mapToResponse(customer);
    }

    public List<CorporateCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.getAllByType(CustomerType.CORPORATE);
        return customers.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }

    public void update(Integer id, UpdatedCorporateCustomer request) {
        cityService.checkCompatibilityWithCountry(request.getLegalCityId(), request.getLegalCountryId());

        Customer customer = customerRepository.getCorporateCustomerById(id);
        customerMapper.updateEntity(customer, request);
        customerRepository.update(id, customer);
    }

    public void delete(Integer id) {
        contactDetailService.deleteAllByCustomerId(id);
        shareHolderService.deleteAllByCustomerId(id);
        customerRepository.delete(id);
    }

    private CorporateCustomerResponse mapToResponse(Customer customer) {
        CorporateCustomerResponse response = customerMapper.toResponse(customer);

        CountryResponse country = countryService.getById(customer.getLegalCountryId());
        response.setLegalCountry(country.getName());

        CityResponse city = cityService.getById(customer.getLegalCityId());
        response.setLegalCity(city.getName());

        List<ShareHolderResponse> shareHolderResponses =
                shareHolderService.getAllByCustomerId(customer.getId());
        response.setShareHolderResponses(shareHolderResponses);

        List<ContactDetailResponse> contactDetailResponses =
                contactDetailService.getAllByCustomerId(customer.getId());
        response.setContactDetailResponses(contactDetailResponses);

        return response;
    }

}
