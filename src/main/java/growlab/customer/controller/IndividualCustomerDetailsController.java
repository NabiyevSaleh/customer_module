package growlab.customer.controller;

import growlab.customer.dto.IndividualCustomerDetailsRequest;
import growlab.customer.service.IndividualCustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/individualCustomer")
public class IndividualCustomerDetailsController {

    private final IndividualCustomerDetailsService individualCustomerDetailsService;

    @PostMapping
    public void create(@RequestBody IndividualCustomerDetailsRequest individualCustomerDetailsRequest) {
        individualCustomerDetailsService.create(individualCustomerDetailsRequest);
    }


}
