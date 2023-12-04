package growlab.customer.mapper;

import growlab.customer.domain.CorporateCustomerShareholder;
import growlab.customer.dto.request.CreatedShareholder;
import growlab.customer.dto.request.UpdatedShareholder;
import growlab.customer.dto.response.ShareholderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShareholderMapper {

    CorporateCustomerShareholder toEntity(CreatedShareholder createdShareholder);
    void updateEntity(@MappingTarget CorporateCustomerShareholder entity, UpdatedShareholder dto);

    ShareholderResponse toResponse(CorporateCustomerShareholder entity);
}
