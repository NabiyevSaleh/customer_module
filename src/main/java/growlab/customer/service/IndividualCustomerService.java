package growlab.customer.service;

import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.IndividualCustomerDetailResponse;
import growlab.customer.dto.response.IndividualCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndividualCustomerService {

    Integer create(CreatedIndividualCustomer createdIndividualCustomer);

    IndividualCustomerResponse getById(Integer id);

    List<IndividualCustomerResponse> getAll();

    void update(Integer id, UpdatedIndividualCustomer updatedIndividualCustomer);

    IndividualCustomerDetailResponse getIndividualCustomerDetail(Integer customerId);

    public void delete(Integer id);
}
