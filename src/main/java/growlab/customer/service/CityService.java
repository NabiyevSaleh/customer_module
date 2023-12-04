package growlab.customer.service;

import growlab.customer.domain.City;
import growlab.customer.dto.request.CreatedCity;
import growlab.customer.dto.response.CityResponse;
import growlab.customer.exception.IncompatibleCityException;
import growlab.customer.mapper.CityMapper;
import growlab.customer.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public void create(Integer countryId, CreatedCity request) {
        City city = cityMapper.toEntity(request);
        cityRepository.create(countryId, city);
    }

    public CityResponse getById(Integer id) {
        City city = cityRepository.getById(id);
        return cityMapper.toResponse(city);
    }

    public List<CityResponse> getAllByCountryId(Integer countryId) {
        List<City> cities = cityRepository.getAllByCountryId(countryId);
        return cities.stream()
                .map(cityMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        cityRepository.delete(id);
    }

    public void deleteAllByCountryId(Integer countryId) {
        cityRepository.deleteAllByCountryId(countryId);
    }

    public void checkCompatibilityWithCountry(Integer cityId, Integer countryId) {
        City city = cityRepository.getById(cityId);
        if (!Objects.equals(city.getCountryId(), countryId)) {
            throw new IncompatibleCityException(
                    "The city with the given id: " + cityId +
                            " does not belong to the country with the given id: " + countryId);
        }
    }

}
