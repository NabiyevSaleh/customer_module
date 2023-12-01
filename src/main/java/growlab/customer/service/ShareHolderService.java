package growlab.customer.service;

import growlab.customer.dto.CreatedShareholder;
import growlab.customer.dto.UpdatedShareholder;
import growlab.customer.dto.response.ShareHolderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShareHolderService {

    Integer addShareholder(CreatedShareholder createdShareholder);

    void updatedShareholder(Integer shareholderId, UpdatedShareholder updatedShareholder);

    List<ShareHolderResponse> shareHolderResponses (Integer customerId);
}
