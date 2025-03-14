package com.payroll.startup.Services;

import com.payroll.startup.Models.Employee;
import com.payroll.startup.Models.Identity;
import com.payroll.startup.Repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityService {
    private final IdentityRepository identityRepository;

    @Autowired
    public IdentityService(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    public List<Identity> getAllIdentities() {
        return identityRepository.findAll();
    }

    public Identity getIdentityById(Integer id) {
        return identityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Identity with ID " + id + " not found"));
    }

    public void addIdentity(Identity identity) {
        identityRepository.save(identity);
    }

    public void updateIdentity(Integer id, String idType, String idValue) {
        Identity identity = identityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Identity with ID " + id + " not found"));

        if (idType != null && !idType.isEmpty()) identity.setIdType(idType);
        if (idValue != null && !idValue.isEmpty()) identity.setIdValue(idValue);

        identityRepository.save(identity);
    }

    public void deleteIdentity(Integer id) {
        if (!identityRepository.existsById(id)) {
            throw new IllegalArgumentException("Identity with ID " + id + " not found");
        }
        identityRepository.deleteById(id);
    }
}