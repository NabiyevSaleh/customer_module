package growlab.customer.controller;

import growlab.customer.dto.request.CreatedContactDetail;
import growlab.customer.dto.request.UpdatedContactDetail;
import growlab.customer.service.ContactDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ContactDetailController {

    private final ContactDetailService contactDetailService;

    @PostMapping("/customers/{id}/contact-detail")
    @ResponseStatus(HttpStatus.CREATED)
    public void addContactDetail(@PathVariable("id") Integer customerId,
                                 @RequestBody CreatedContactDetail createdContactDetail) {
        contactDetailService.addContactDetail(customerId, createdContactDetail);
    }

    @PutMapping("/contact-detail/{id}")
    public void updateContactDetail(@PathVariable("id") Integer id,
                                    @RequestBody UpdatedContactDetail updatedContactDetail) {
        contactDetailService.updateContactDetail(id, updatedContactDetail);
    }

    @DeleteMapping("/contact-detail/{id}")
    public void deleteContactDetail(@PathVariable("id") Integer id) {
        contactDetailService.delete(id);
    }
}
