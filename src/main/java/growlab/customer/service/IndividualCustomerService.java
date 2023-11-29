package growlab.customer.service;

import growlab.customer.dto.CreatedCustomerContactDetail;
import growlab.customer.dto.UpdatedCustomerContactDetail;
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

    Integer addContactDetail(CreatedCustomerContactDetail createdCustomerContactDetail);

    void updateContactDetail(Integer contactDetailId, UpdatedCustomerContactDetail updatedCustomerContactDetail);
}
