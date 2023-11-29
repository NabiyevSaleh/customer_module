package growlab.customer.mapper;

import growlab.customer.domain.CustomerContactDetail;
import growlab.customer.dto.CreatedCustomerContactDetail;
import growlab.customer.dto.UpdatedCustomerContactDetail;
import growlab.customer.dto.response.CustomerContactDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerContactDetailMapper {

    CustomerContactDetail toEntity(CreatedCustomerContactDetail dto);

    void updateEntity(@MappingTarget CustomerContactDetail entity, UpdatedCustomerContactDetail dto);

    CustomerContactDetailResponse toResponse(CustomerContactDetail entity);
}
