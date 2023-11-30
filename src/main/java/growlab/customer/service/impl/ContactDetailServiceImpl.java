package growlab.customer.service.impl;


import growlab.customer.domain.CustomerContactDetail;
import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.mapper.CustomerContactDetailMapper;
import growlab.customer.repository.CustomerContactDetailRepository;
import growlab.customer.service.ContactDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactDetailServiceImpl implements ContactDetailService {

    private final CustomerContactDetailMapper contactDetailMapper;
    private final CustomerContactDetailRepository contactDetailRepository;

    @Override
    public Integer addContactDetail(CreatedContactDetail createdContactDetail) {
        CustomerContactDetail contactDetail = contactDetailMapper.toEntity(createdContactDetail);
        return contactDetailRepository.create(contactDetail);
    }

    @Override
    public void updateContactDetail(Integer contactDetailId, UpdatedContactDetail updatedContactDetail) {
        CustomerContactDetail contactDetail = contactDetailRepository.getById(contactDetailId);
        contactDetailMapper.updateEntity(contactDetail, updatedContactDetail);
        contactDetailRepository.update(contactDetailId, contactDetail);
    }
}