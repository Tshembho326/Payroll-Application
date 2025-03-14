package com.payroll.startup.Controllers;

import com.payroll.startup.Models.Identity;
import com.payroll.startup.Services.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/identity/")
public class IdentityController {
    private final IdentityService identityService;

    @Autowired
    public IdentityController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @GetMapping("all")
    public List<Identity> getAllIdentities() {
        return identityService.getAllIdentities();
    }

    @GetMapping("{identity_id}")
    public Identity getIdentityById(@PathVariable("identity_id") Integer id) {
        return identityService.getIdentityById(id);
    }

    @PostMapping
    public void addIdentity(@RequestBody Identity identity) {
        identityService.addIdentity(identity);
    }

    @DeleteMapping("{identity_id}")
    public void deleteIdentity(@PathVariable("identity_id") Integer id) {
        identityService.deleteIdentity(id);
    }

    @PutMapping("{identity_id}")
    public void updateIdentity(
            @PathVariable("identity_id") Integer id,
            @RequestParam(required = false) String idType,
            @RequestParam(required = false) String idValue
    ) {
        identityService.updateIdentity(id, idType, idValue);
    }
}
