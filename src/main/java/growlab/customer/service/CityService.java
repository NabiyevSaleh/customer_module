package growlab.customer.service;

import growlab.customer.dto.request.CreatedCity;
import growlab.customer.dto.response.CityResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService{

    Integer create(Integer countryId, CreatedCity request);

    CityResponse getById(Integer id);

    List<CityResponse> getAllByCountryId(Integer countryId);

    void delete(Integer id);

    void deleteAllByCountryId(Integer countryId);

    void checkCompatibilityWithCountry(Integer cityId, Integer countryId);
}
