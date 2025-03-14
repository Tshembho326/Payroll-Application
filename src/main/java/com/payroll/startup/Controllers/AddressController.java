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

    @GetMapping("{address_id}")
    public Address getAddressById(@PathVariable("address_id") Integer addressId) {
        return addressService.getAddressById(addressId);
    }

    @PostMapping
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @DeleteMapping("{address_id}")
    public void deleteAddress(@PathVariable("address_id") Integer addressId) {
        addressService.deleteAddress(addressId);
    }

    @PutMapping("{address_id}")
    public void updateAddress(
            @PathVariable("address_id") Integer addressId,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer postalCode,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String street
    ) {
        addressService.updateAddress(addressId, city, postalCode, country, street);
    }
}