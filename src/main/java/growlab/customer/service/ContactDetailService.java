package growlab.customer.service;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.dto.response.ContactDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactDetailService {

    Integer addContactDetail(CreatedContactDetail createdContactDetail);

    void updateContactDetail(Integer contactDetailId, UpdatedContactDetail updatedContactDetail);
    List<ContactDetailResponse> contactDetailResponses (Integer customerId);

    void deleteAllByCustomerId(Integer id);

}
