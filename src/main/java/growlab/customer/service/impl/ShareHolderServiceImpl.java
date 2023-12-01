package growlab.customer.service.impl;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.dto.CreatedShareholder;
import growlab.customer.dto.UpdatedShareholder;
import growlab.customer.dto.response.ShareHolderResponse;
import growlab.customer.mapper.ShareHolderMapper;
import growlab.customer.repository.CorporateCustomerShareholderRepository;
import growlab.customer.service.ShareHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShareHolderServiceImpl implements ShareHolderService {

    private final CorporateCustomerShareholderRepository shareholderRepository;
    private final ShareHolderMapper shareHolderMapper;

    @Override
    public Integer addShareholder(CreatedShareholder createdShareholder) {
        CorporateCustomerShareholder corporateCustomerShareholder = shareHolderMapper.toEntity(createdShareholder);
        return shareholderRepository.create(corporateCustomerShareholder);
    }

    @Override
    public void updatedShareholder(Integer shareholderId, UpdatedShareholder updatedShareholder) {
        CorporateCustomerShareholder corporateCustomerShareholder
                = shareholderRepository.getById(shareholderId);
        shareHolderMapper.updateEntity(corporateCustomerShareholder, updatedShareholder);
        shareholderRepository.update(shareholderId, corporateCustomerShareholder);
    }

    @Override
    public List<ShareHolderResponse> shareHolderResponses(Integer customerId) {

        List<CorporateCustomerShareholder> shareholders
                = shareholderRepository.getByCustomerId(customerId);

        List<ShareHolderResponse> shareHolderResponseList =
                shareholders.stream()
                        .map(shareHolderMapper::toResponse)
                        .collect(Collectors.toList());

        return shareHolderResponseList;
    }
}
