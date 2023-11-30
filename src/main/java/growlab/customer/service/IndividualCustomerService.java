package growlab.customer.service;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.IndividualCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndividualCustomerService {

    Integer create(CreatedIndividualCustomer createdIndividualCustomer);

    IndividualCustomerResponse getById(Integer id);

    List<IndividualCustomerResponse> getAll();

    void update(Integer id, UpdatedIndividualCustomer updatedIndividualCustomer);

    Integer addContactDetail(CreatedContactDetail createdContactDetail);

    void updateContactDetail(Integer contactDetailId, UpdatedContactDetail updatedContactDetail);
}
