package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.InventoryItems;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.InventoryItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("manager/update")
public class InventoryItemsController {

    private InventoryItemsRepository repo;

    @Autowired
    public InventoryItemsController(InventoryItemsRepository repo){
        this.repo = repo;
    }

    @GetMapping("/item_page")
    public Optional<InventoryItems> findById(@PathVariable long id){
        if(!repo.findById(id).isPresent()){
            throw new IllegalArgumentException("Item does not exist");
        } else
            return repo.findById(id);
    }

}
