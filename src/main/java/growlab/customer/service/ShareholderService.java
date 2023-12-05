package growlab.customer.service;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.dto.request.CreatedShareholder;
import growlab.customer.dto.request.UpdatedShareholder;
import growlab.customer.dto.response.ShareholderResponse;
import growlab.customer.exception.NotFoundException;
import growlab.customer.mapper.ShareholderMapper;
import growlab.customer.repository.CorporateCustomerShareholderRepository;
import growlab.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShareholderService {

    private final CorporateCustomerShareholderRepository shareholderRepository;
    private final ShareholderMapper shareholderMapper;
    private final CustomerRepository customerRepository;

    public void addShareholder(Integer customerId, CreatedShareholder createdShareholder) {
        if (customerRepository.checkCustomerExist(customerId)) {
            CorporateCustomerShareholder corporateCustomerShareholder =
                    shareholderMapper.toEntity(createdShareholder);
            corporateCustomerShareholder.setCustomerId(customerId);
            shareholderRepository.create(corporateCustomerShareholder);
        } else {
            throw new NotFoundException("Customer not found");
        }
    }

    public void createShareholders(Integer customerId, List<CreatedShareholder> createdShareholders) {
        List<CorporateCustomerShareholder> shareholders = createdShareholders.stream()
                .map(createdShareholder -> {
                    CorporateCustomerShareholder corporateCustomerShareholder =
                            shareholderMapper.toEntity(createdShareholder);
                    corporateCustomerShareholder.setCustomerId(customerId);
                    return corporateCustomerShareholder;
                })
                .collect(Collectors.toList());

        shareholderRepository.createAll(shareholders);
    }

    public void updatedShareholder(Integer shareholderId, UpdatedShareholder updatedShareholder) {
        CorporateCustomerShareholder corporateCustomerShareholder
                = shareholderRepository.getById(shareholderId);
        shareholderMapper.updateEntity(corporateCustomerShareholder, updatedShareholder);
        shareholderRepository.update(shareholderId, corporateCustomerShareholder);
    }

    public List<ShareholderResponse> getAllByCustomerId(Integer customerId) {
        return shareholderRepository.getAllByCustomerId(customerId).stream()
                .map(shareholderMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        shareholderRepository.delete(id);
    }

    public void deleteAllByCustomerId(Integer customerId) {
        shareholderRepository.deleteAllByCustomerId(customerId);
    }

}
