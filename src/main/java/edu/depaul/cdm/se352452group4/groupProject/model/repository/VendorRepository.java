package edu.depaul.cdm.se352452group4.groupProject.model.repository;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendorRepository extends CrudRepository<Vendor,Long> {
    Vendor findByCountry (String country);
    Vendor findByState (String state);
    Vendor findByCity (String city);
}
