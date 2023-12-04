package growlab.customer.service;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.dto.request.CreatedShareholder;
import growlab.customer.dto.request.UpdatedShareholder;
import growlab.customer.dto.response.ShareHolderResponse;
import growlab.customer.mapper.ShareHolderMapper;
import growlab.customer.repository.CorporateCustomerShareholderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShareHolderService {

    private final CorporateCustomerShareholderRepository shareholderRepository;
    private final ShareHolderMapper shareHolderMapper;

    public Integer addShareholder(Integer customerId, CreatedShareholder createdShareholder) {
        CorporateCustomerShareholder corporateCustomerShareholder =
                shareHolderMapper.toEntity(createdShareholder);
        corporateCustomerShareholder.setCustomerId(customerId);
        return shareholderRepository.create(corporateCustomerShareholder);
    }

    public void updatedShareholder(Integer shareholderId, UpdatedShareholder updatedShareholder) {
        CorporateCustomerShareholder corporateCustomerShareholder
                = shareholderRepository.getById(shareholderId);
        shareHolderMapper.updateEntity(corporateCustomerShareholder, updatedShareholder);
        shareholderRepository.update(shareholderId, corporateCustomerShareholder);
    }

    public List<ShareHolderResponse> getAllByCustomerId(Integer customerId) {
        return shareholderRepository.getAllByCustomerId(customerId).stream()
                .map(shareHolderMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        shareholderRepository.delete(id);
    }

    public void deleteAllByCustomerId(Integer customerId) {
        shareholderRepository.deleteAllByCustomerId(customerId);
    }

}
