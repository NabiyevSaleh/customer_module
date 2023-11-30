package growlab.customer.service.impl;

import growlab.customer.domain.Country;
import growlab.customer.dto.CreatedCountry;
import growlab.customer.dto.UpdatedCountry;
import growlab.customer.dto.response.CountryResponse;
import growlab.customer.mapper.CountryMapper;
import growlab.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public Integer create(CreatedCountry request) {
        Country country = countryMapper.toEntity(request);
        return countryRepository.create(country);
    }

    public CountryResponse getById(Integer id) {
        Country country = countryRepository.getById(id);
        return countryMapper.toResponse(country);
    }

    public List<CountryResponse> getAll() {
        List<Country> countries = countryRepository.getAll();
        return countries.stream()
                .map(countryMapper::toResponse)
                .toList();
    }

    public void update(Integer id, UpdatedCountry request) {
        Country country = countryRepository.getById(id);
        countryMapper.updateEntity(country, request);
    }

    public void delete(Integer id) {
        countryRepository.delete(id);
    }

}
