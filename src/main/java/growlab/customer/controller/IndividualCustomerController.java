package growlab.customer.controller;

import growlab.customer.dto.request.CreateIndividualCustomerRequest;
import growlab.customer.dto.request.IndividualCustomerDetailsRequest;
import growlab.customer.service.IndividualCustomerDetailsService;
import growlab.customer.service.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/individual-customer")
public class IndividualCustomerController {

    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerService.create(createIndividualCustomerRequest);
    }
}
