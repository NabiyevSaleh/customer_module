package growlab.customer.mapper;

import growlab.customer.domain.Customer;
import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.IndividualCustomerResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IndividualCustomerMapper {

    Customer toEntity(CreatedIndividualCustomer dto);

    void updateEntity(@MappingTarget Customer entity, UpdatedIndividualCustomer dto);

    IndividualCustomerResponse toResponse(Customer entity);

}
