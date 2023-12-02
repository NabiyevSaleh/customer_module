package growlab.customer.service;

import growlab.customer.dto.request.CreatedCountry;
import growlab.customer.dto.response.CountryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    public Integer create(CreatedCountry request);

    public CountryResponse getById(Integer id);

    public List<CountryResponse> getAll();

    public void delete(Integer id);

}
