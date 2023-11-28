package growlab.customer.service;

import growlab.customer.dto.request.IndividualCustomerDetailsRequest;
import growlab.customer.dto.response.IndividualCustomerDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndividualCustomerDetailsService {
    Integer create(IndividualCustomerDetailsRequest individualCustomerDetailsRequest);
    IndividualCustomerDetailsResponse getById(Integer id);
    List<IndividualCustomerDetailsResponse> getAll();

}
