package growlab.customer.mapper;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.domain.Customer;
import growlab.customer.dto.CreatedShareholder;
import growlab.customer.dto.UpdatedShareholder;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.IndividualCustomerResponse;
import growlab.customer.dto.response.ShareHolderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShareHolderMapper {

    CorporateCustomerShareholder toEntity(CreatedShareholder createdShareholder);
    void updateEntity(@MappingTarget CorporateCustomerShareholder entity, UpdatedShareholder dto);

    ShareHolderResponse toResponse(CorporateCustomerShareholder entity);
}
