package growlab.customer.service;

import growlab.customer.domain.Country;
import growlab.customer.dto.request.CreatedCountry;
import growlab.customer.dto.response.CountryResponse;
import growlab.customer.mapper.CountryMapper;
import growlab.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    private final CityService cityService;

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
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        cityService.deleteAllByCountryId(id);
        countryRepository.delete(id);
    }

}
