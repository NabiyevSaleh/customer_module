package growlab.customer.service;


import growlab.customer.domain.CustomerContactDetail;
import growlab.customer.dto.request.CreatedContactDetail;
import growlab.customer.dto.request.UpdatedContactDetail;
import growlab.customer.dto.response.ContactDetailResponse;
import growlab.customer.mapper.CustomerContactDetailMapper;
import growlab.customer.repository.CustomerContactDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactDetailService {

    private final CustomerContactDetailMapper contactDetailMapper;
    private final CustomerContactDetailRepository contactDetailRepository;

    public void addContactDetail(Integer customerId, CreatedContactDetail createdContactDetail) {
        CustomerContactDetail contactDetail = contactDetailMapper.toEntity(createdContactDetail);
        contactDetail.setCustomerId(customerId);
        contactDetail.setIsActive(1);
        contactDetailRepository.create(contactDetail);
    }

    public void createContactDetails(Integer customerId, List<CreatedContactDetail> createdContactDetails) {
        List<CustomerContactDetail> contactDetails = createdContactDetails.stream()
                .map(createdContactDetail -> {
                    CustomerContactDetail contactDetail = contactDetailMapper.toEntity(createdContactDetail);
                    contactDetail.setCustomerId(customerId);
                    contactDetail.setIsActive(1);
                    return contactDetail;
                })
                .collect(Collectors.toList());
        contactDetailRepository.createAll(contactDetails);
    }

    public void updateContactDetail(Integer contactDetailId, UpdatedContactDetail updatedContactDetail) {
        CustomerContactDetail contactDetail = contactDetailRepository.getById(contactDetailId);
        contactDetailMapper.updateEntity(contactDetail, updatedContactDetail);
        contactDetailRepository.update(contactDetailId, contactDetail);
    }

    public List<ContactDetailResponse> getAllByCustomerId(Integer customerId) {
        return contactDetailRepository.getAllByCustomerId(customerId).stream()
                .map(contactDetailMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        contactDetailRepository.delete(id);
    }

    public void deleteAllByCustomerId(Integer customerId) {
        contactDetailRepository.deleteAllByCustomerId(customerId);
    }

}
