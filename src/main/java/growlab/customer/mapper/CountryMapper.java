package growlab.customer.mapper;

import growlab.customer.domain.Country;
import growlab.customer.dto.request.CreatedCountry;
import growlab.customer.dto.response.CountryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    Country toEntity(CreatedCountry dto);

    CountryResponse toResponse (Country entity);

}
