package growlab.customer.mapper;

import growlab.customer.domain.IndividualCustomerDetail;
import growlab.customer.dto.CreatedIndividualCustomerDetail;
import growlab.customer.dto.UpdatedIndividualCustomerDetail;
import growlab.customer.dto.response.IndividualCustomerDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IndividualCustomerDetailMapper {

    IndividualCustomerDetail toEntity(CreatedIndividualCustomerDetail dto);

    IndividualCustomerDetail toEntity(UpdatedIndividualCustomerDetail dto);

    IndividualCustomerDetailResponse toResponse(growlab.customer.domain.IndividualCustomerDetail entity);

}
