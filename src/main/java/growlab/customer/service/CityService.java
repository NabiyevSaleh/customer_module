package growlab.customer.service;

import growlab.customer.dto.CreatedCity;
import growlab.customer.dto.response.CityResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    public Integer create(Integer countryId, CreatedCity request);

    public CityResponse getById(Integer id);

    public List<CityResponse> getAll();

    public void delete(Integer id);

    public void deleteAllByCountryId(Integer countryId);
}
