package growlab.customer.mapper;

import growlab.customer.domain.IndividualCustomerDetail;
import growlab.customer.dto.CreatedIndividualCustomerDetailDto;
import growlab.customer.dto.UpdatedIndividualCustomerDetailDto;
import growlab.customer.dto.response.IndividualCustomerDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IndividualCustomerDetailMapper {

    IndividualCustomerDetail toEntity(CreatedIndividualCustomerDetailDto dto);

    IndividualCustomerDetail toEntity(UpdatedIndividualCustomerDetailDto dto);

    IndividualCustomerDetailResponse toResponse(growlab.customer.domain.IndividualCustomerDetail entity);

}
