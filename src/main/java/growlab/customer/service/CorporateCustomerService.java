package growlab.customer.service;

import growlab.customer.dto.CreatedShareholder;
import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.dto.UpdatedShareholder;
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

    Integer addShareholder(CreatedShareholder createdShareholder);

    void updatedShareholder(Integer shareholderId, UpdatedShareholder updatedShareholder);


}
