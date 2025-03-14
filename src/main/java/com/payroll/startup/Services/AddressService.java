package com.payroll.startup.Services;

import com.payroll.startup.Models.Address;
import com.payroll.startup.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Address not found")
        );
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        boolean exists = addressRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("Address not found.");
        }
        addressRepository.deleteById(id);
    }

    public void updateAddress(Integer id, String city, Integer postalCode, String country, String street) {
        Address address = addressRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Address not found")
        );

        if (city != null) address.setCity(city);
        if (postalCode != null) address.setPostalCode(postalCode);
        if (country != null) address.setCountry(country);
        if (street != null) address.setStreet(street);

        addressRepository.save(address);
    }
}
