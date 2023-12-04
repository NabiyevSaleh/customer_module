package growlab.customer.service.impl;

import growlab.customer.domain.City;
import growlab.customer.dto.request.CreatedCity;
import growlab.customer.dto.response.CityResponse;
import growlab.customer.exception.IncompatibleCityException;
import growlab.customer.mapper.CityMapper;
import growlab.customer.repository.CityRepository;
import growlab.customer.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public Integer create(Integer countryId, CreatedCity request) {
        City city = cityMapper.toEntity(request);
        return cityRepository.create(countryId, city);
    }

    @Override
    public CityResponse getById(Integer id) {
        City city = cityRepository.getById(id);
        return cityMapper.toResponse(city);
    }

    @Override
    public List<CityResponse> getAllByCountryId(Integer countryId) {
        List<City> cities = cityRepository.getAllByCountryId(countryId);
        return cities.stream()
                .map(cityMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        cityRepository.delete(id);
    }

    @Override
    public void deleteAllByCountryId(Integer countryId) {
        cityRepository.deleteAllByCountryId(countryId);
    }

    @Override
    public void checkCompatibilityWithCountry(Integer cityId, Integer countryId) {
        City city = cityRepository.getById(cityId);
        if (!Objects.equals(city.getCountryId(), countryId)) {
            throw new IncompatibleCityException(
                    "The city with the given id: " + cityId +
                            " does not belong to the country with the given id: " + countryId);
        }
    }

}
