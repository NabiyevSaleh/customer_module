package growlab.customer.service;

import growlab.customer.dto.request.CreatedContactDetail;
import growlab.customer.dto.request.UpdatedContactDetail;
import growlab.customer.dto.response.ContactDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactDetailService {

    Integer addContactDetail(Integer customerId, CreatedContactDetail createdContactDetail);

    void updateContactDetail(Integer contactDetailId, UpdatedContactDetail updatedContactDetail);
    List<ContactDetailResponse> contactDetailResponses (Integer customerId);

    void delete(Integer id);

    void deleteAllByCustomerId(Integer id);

}
