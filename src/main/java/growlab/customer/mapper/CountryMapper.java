package growlab.customer.mapper;

import growlab.customer.domain.Country;
import growlab.customer.dto.request.CreatedCountry;
import growlab.customer.dto.request.UpdatedCountry;
import growlab.customer.dto.response.CountryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    Country toEntity(CreatedCountry dto);

    CountryResponse toResponse (Country entity);

    void updateEntity(@MappingTarget Country entity, UpdatedCountry dto);

}
