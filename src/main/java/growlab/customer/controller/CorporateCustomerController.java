package growlab.customer.controller;

import growlab.customer.dto.request.CreatedCorporateCustomer;
import growlab.customer.dto.request.CreatedShareholder;
import growlab.customer.dto.request.UpdatedCorporateCustomer;
import growlab.customer.dto.request.UpdatedShareholder;
import growlab.customer.dto.response.CorporateCustomerResponse;
import growlab.customer.service.CorporateCustomerService;
import growlab.customer.service.ShareholderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/corporate-customer")
public class CorporateCustomerController {

    private final CorporateCustomerService corporateCustomerService;
    private final ShareholderService shareHolderService;

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

    @PostMapping("/{id}/shareholder")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShareHolder(@PathVariable("id") Integer customerId,
                               @RequestBody CreatedShareholder createdShareholder) {
        shareHolderService.addShareholder(customerId, createdShareholder);
    }

    @PutMapping("/shareholders/{id}")
    public void updateShareholder(@PathVariable("id") Integer id, @RequestBody UpdatedShareholder shareholder) {
        shareHolderService.updatedShareholder(id, shareholder);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        corporateCustomerService.delete(id);
    }

    @DeleteMapping("/shareholders/{id}")
    public void deleteShareholder(@PathVariable("id") Integer id) {
        shareHolderService.delete(id);
    }
}
