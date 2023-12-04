package growlab.customer.mapper;

import growlab.customer.domain.City;
import growlab.customer.dto.request.CreatedCity;
import growlab.customer.dto.response.CityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {

    City toEntity(CreatedCity dto);

    CityResponse toResponse(City entity);

}
