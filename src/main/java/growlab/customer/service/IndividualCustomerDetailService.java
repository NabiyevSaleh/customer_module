package growlab.customer.service;

import growlab.customer.domain.IndividualCustomerDetail;
import growlab.customer.dto.request.CreatedIndividualCustomerDetail;
import growlab.customer.dto.request.UpdatedIndividualCustomerDetail;
import growlab.customer.dto.response.IndividualCustomerDetailResponse;
import growlab.customer.mapper.IndividualCustomerDetailMapper;
import growlab.customer.repository.IndividualCustomerDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualCustomerDetailService {

    private final IndividualCustomerDetailRepository detailRepository;
    private final IndividualCustomerDetailMapper detailMapper;
    private final CountryService countryService;
    private final CityService cityService;

    public void create(Integer customerId, CreatedIndividualCustomerDetail request) {
        IndividualCustomerDetail detail = detailMapper.toEntity(request);
        detailRepository.create(customerId, detail);
    }

    public void update(Integer customerId, UpdatedIndividualCustomerDetail request) {
        IndividualCustomerDetail detail = detailMapper.toEntity(request);
        Integer detailId = detailRepository.getByCustomerId(customerId).getId();
        detailRepository.update(detailId, detail);
    }

    public IndividualCustomerDetailResponse getByCustomerId(Integer customerId) {
        IndividualCustomerDetail detail = detailRepository.getByCustomerId(customerId);
        IndividualCustomerDetailResponse detailResponse = detailMapper.toResponse(detail);
        detailResponse.setBirthCity(countryService.getById(detail.getBirthCountryId()).getName());
        detailResponse.setBirthCity(cityService.getById(detail.getBirthCityId()).getName());
        return detailResponse;
    }

}
