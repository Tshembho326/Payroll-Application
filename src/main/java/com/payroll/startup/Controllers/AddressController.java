package com.payroll.startup.Controllers;

import com.payroll.startup.Models.Address;
import com.payroll.startup.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address/")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("all")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("{id}")
    public Address getAddressById(@PathVariable("id") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @DeleteMapping("{id}")
    public void deleteAddress(@PathVariable("id") Integer id) {
        addressService.deleteAddress(id);
    }

    @PutMapping("{id}")
    public void updateAddress(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer postalCode,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String street
    ) {
        addressService.updateAddress(id, city, postalCode, country, street);
    }
}