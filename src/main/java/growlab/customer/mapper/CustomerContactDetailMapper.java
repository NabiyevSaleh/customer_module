package growlab.customer.mapper;

import growlab.customer.domain.CustomerContactDetail;
import growlab.customer.dto.request.CreatedContactDetail;
import growlab.customer.dto.request.UpdatedContactDetail;
import growlab.customer.dto.response.ContactDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerContactDetailMapper {

    CustomerContactDetail toEntity(CreatedContactDetail dto);

    void updateEntity(@MappingTarget CustomerContactDetail entity, UpdatedContactDetail dto);

    ContactDetailResponse toResponse(CustomerContactDetail entity);
}
