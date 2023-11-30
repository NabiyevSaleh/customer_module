package growlab.customer.mapper;

import growlab.customer.domain.City;
import growlab.customer.dto.CreatedCity;
import growlab.customer.dto.UpdatedCity;
import growlab.customer.dto.response.CityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {

    City toEntity(CreatedCity dto);

    CityResponse toResponse(City entity);

    void updateEntity(@MappingTarget City entity, UpdatedCity dto);

}
