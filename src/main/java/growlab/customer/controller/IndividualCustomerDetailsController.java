package growlab.customer.controller;

import growlab.customer.dto.IndividualCustomerDetailsRequest;
import growlab.customer.dto.IndividualCustomerDetailsResponse;
import growlab.customer.service.IndividualCustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/individualCustomer")
public class IndividualCustomerDetailsController {

    private final IndividualCustomerDetailsService individualCustomerDetailsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody IndividualCustomerDetailsRequest individualCustomerDetailsRequest) {
        individualCustomerDetailsService.create(individualCustomerDetailsRequest);
    }

    @GetMapping("/{customer-details-id}")
    public IndividualCustomerDetailsResponse getById(@PathVariable("customer-details-id") Integer id){
        return individualCustomerDetailsService.getById(id);
    }
}
