package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Vendor;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorRepository repo;

    @GetMapping
    public Iterable<Vendor> allVendors() {
        return repo.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Vendor> findVendorId(@PathVariable long id) {
        return repo.findById(id);
    }

    @GetMapping("/find/{country}")
    public Vendor findVendorCountry(@PathVariable String country) {
        return repo.findByCountry(country);
    }

    @GetMapping("/find/{state}")
    public Vendor findVendorState(@PathVariable String state) {
        return repo.findByState(state);
    }

    @GetMapping("/find/{city}")
    public Vendor findVendorCity(@PathVariable String city) {
        return repo.findByCity(city);
    }
}
