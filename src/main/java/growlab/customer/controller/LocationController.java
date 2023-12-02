package growlab.customer.controller;

import growlab.customer.dto.request.CreatedCity;
import growlab.customer.dto.request.CreatedCountry;
import growlab.customer.dto.response.CityResponse;
import growlab.customer.dto.response.CountryResponse;
import growlab.customer.service.CityService;
import growlab.customer.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/locations")
public class LocationController {

    private final CountryService countryService;
    private final CityService cityService;

    @PostMapping("/countries")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCountry(@RequestBody CreatedCountry request) {
        countryService.create(request);
    }

    @GetMapping("/countries/{id}")
    public CountryResponse getCountryById(@PathVariable("id") Integer id) {
        return countryService.getById(id);
    }

    @GetMapping("/countries")
    public List<CountryResponse> getAllCountries() {
        return countryService.getAll();
    }

    @DeleteMapping("/countries/{id}")
    public void deleteCountry(@PathVariable("id") Integer id) {
        countryService.delete(id);
    }

    @PostMapping("/countries/{id}/cities")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCity(@PathVariable("id") Integer countryId,
                           @RequestBody CreatedCity request) {
        cityService.create(countryId, request);
    }

    @GetMapping("/cities/{id}")
    public CityResponse getCityById(@PathVariable("id") Integer id) {
        return cityService.getById(id);
    }

    @GetMapping("/countries/{id}/cities")
    public List<CityResponse> getAllCities(@PathVariable("id") Integer countryId) {
        return cityService.getAllByCountryId(countryId);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable("id") Integer id) {
        cityService.delete(id);
    }

}
