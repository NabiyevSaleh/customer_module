package growlab.customer.controller;

import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.IndividualCustomerResponse;
import growlab.customer.service.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/individual-customers")
public class IndividualCustomerController {

    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreatedIndividualCustomer createdIndividualCustomer) {
        individualCustomerService.create(createdIndividualCustomer);
    }

    @GetMapping("/{id}")
    public IndividualCustomerResponse getById(@PathVariable("id") Integer id) {
        return individualCustomerService.getById(id);
    }

    @GetMapping
    public List<IndividualCustomerResponse> getAll() {
        return individualCustomerService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestBody @Valid UpdatedIndividualCustomer customer) {
        individualCustomerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        individualCustomerService.delete(id);
    }

}
