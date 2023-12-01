package growlab.customer.controller;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.dto.request.CreatedIndividualCustomer;
import growlab.customer.dto.request.UpdatedIndividualCustomer;
import growlab.customer.dto.response.IndividualCustomerResponse;
import growlab.customer.service.ContactDetailService;
import growlab.customer.service.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/individual-customer")
public class IndividualCustomerController {

    private final IndividualCustomerService individualCustomerService;
    private final ContactDetailService contactDetailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreatedIndividualCustomer createdIndividualCustomer) {
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
    public void update(@PathVariable("id") Integer id, @RequestBody UpdatedIndividualCustomer customer) {
        individualCustomerService.update(id, customer);
    }

    @PostMapping("/contact-detail")
    @ResponseStatus(HttpStatus.CREATED)
    public void addContactDetail(@RequestBody CreatedContactDetail createdContactDetail) {
        contactDetailService.addContactDetail(createdContactDetail);
    }

    @PutMapping("/{id}/contact-detail")
    public void updateContactDetail(@RequestBody UpdatedContactDetail updatedContactDetail, @PathVariable("id") Integer id) {
        contactDetailService.updateContactDetail(id, updatedContactDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        individualCustomerService.delete(id);
    }

    @DeleteMapping("/contact-detail/{id}")
    public void deleteContactDetail(@PathVariable("id") Integer id) {
        contactDetailService.delete(id);
    }
}
