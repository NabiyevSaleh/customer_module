package growlab.customer.service;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import org.springframework.stereotype.Service;

@Service
public interface ContactDetailService {
    Integer addContactDetail(CreatedContactDetail createdContactDetail);
    void updateContactDetail(Integer contactDetailId, UpdatedContactDetail updatedContactDetail);
}
