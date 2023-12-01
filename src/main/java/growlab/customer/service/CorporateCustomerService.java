package growlab.customer.service;

import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import growlab.customer.dto.response.CorporateCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CorporateCustomerService {

    Integer create(CreatedCorporateCustomer createdCorporateCustomer);

    CorporateCustomerResponse getById(Integer id);

    List<CorporateCustomerResponse> getAll();

    void update(Integer id, UpdatedCorporateCustomer updatedCorporateCustomer);

    public void delete(Integer id);

}
