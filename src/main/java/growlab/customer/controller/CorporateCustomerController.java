package growlab.customer.controller;

import growlab.customer.dto.CreatedContactDetail;
import growlab.customer.dto.CreatedShareholder;
import growlab.customer.dto.UpdatedContactDetail;
import growlab.customer.dto.UpdatedShareholder;
import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import growlab.customer.dto.response.CorporateCustomerResponse;
import growlab.customer.service.ContactDetailService;
import growlab.customer.service.CorporateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/corporate-customer")
public class CorporateCustomerController {

    private final CorporateCustomerService corporateCustomerService;
    private final ContactDetailService contactDetailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreatedCorporateCustomer createdCorporateCustomer) {
        corporateCustomerService.create(createdCorporateCustomer);
    }

    @GetMapping("/{id}")
    public CorporateCustomerResponse getById(@PathVariable("id") Integer id) {
        return corporateCustomerService.getById(id);
    }

    @GetMapping
    public List<CorporateCustomerResponse> getAll() {
        return corporateCustomerService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody UpdatedCorporateCustomer customer) {
        corporateCustomerService.update(id, customer);
    }

    @PostMapping("/shareholder")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShareHolder(@RequestBody CreatedShareholder createdShareholder) {
        corporateCustomerService.addShareholder(createdShareholder);
    }

    @PutMapping("/{id}/shareholder")
    public void updateShareholder(@PathVariable("id") Integer id, @RequestBody UpdatedShareholder shareholder) {
        corporateCustomerService.updatedShareholder(id, shareholder);
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
}
