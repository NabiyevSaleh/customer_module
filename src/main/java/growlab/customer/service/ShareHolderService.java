package growlab.customer.service;

import growlab.customer.dto.request.CreatedShareholder;
import growlab.customer.dto.request.UpdatedShareholder;
import growlab.customer.dto.response.ShareHolderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShareHolderService {

    Integer addShareholder(Integer customerId, CreatedShareholder createdShareholder);

    void updatedShareholder(Integer shareholderId, UpdatedShareholder updatedShareholder);

    List<ShareHolderResponse> shareHolderResponses(Integer customerId);

    public void delete(Integer id);

    void deleteAllByCustomerId(Integer id);
}
