package growlab.customer.mapper;

import growlab.customer.domain.Customer;
import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CorporateCustomerMapper {

    Customer toEntity(CreatedCorporateCustomer dto);

    void updateEntity(@MappingTarget Customer entity, UpdatedCorporateCustomer dto);

//    IndividualCustomerResponse toResponse(Customer entity);

}
