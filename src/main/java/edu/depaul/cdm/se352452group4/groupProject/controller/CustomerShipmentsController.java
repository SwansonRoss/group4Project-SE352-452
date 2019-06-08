package edu.depaul.cdm.se352452group4.groupProject.controller;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.CustomerShipments;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.CustomerShipmentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerShipmentsController {
    private CustomerShipmentsRepository repo;

    @Autowired
    public CustomerShipmentsController(CustomerShipmentsRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public Iterable<CustomerShipments> getAllCustomerShipments(){
        return repo.findAll();
    }

    @PostMapping
    public CustomerShipments createCustomerShipment(@RequestBody CustomerShipments cs) {
        return repo.save(cs);
    }
    @GetMapping("/{shippingId}")
    public Optional<CustomerShipments> getCustomerShippingId(@PathVariable long shippingId){
        return repo.findById(shippingId);
    }

}
