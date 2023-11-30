package growlab.customer.service.impl;

import growlab.customer.domain.City;
import growlab.customer.dto.CreatedCity;
import growlab.customer.dto.UpdatedCity;
import growlab.customer.dto.response.CityResponse;
import growlab.customer.mapper.CityMapper;
import growlab.customer.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public Integer create(CreatedCity request) {
        City city = cityMapper.toEntity(request);
        return cityRepository.create(city);
    }

    public CityResponse getById(Integer id) {
        City city = cityRepository.getById(id);
        return cityMapper.toResponse(city);
    }

    public List<CityResponse> getAll() {
        List<City> cities = cityRepository.getAll();
        return cities.stream()
                .map(cityMapper::toResponse)
                .toList();
    }

    public void update(Integer id, UpdatedCity request) {
        City city = cityRepository.getById(id);
        cityMapper.updateEntity(city, request);
    }

    public void delete(Integer id) {
        cityRepository.delete(id);
    }

}
