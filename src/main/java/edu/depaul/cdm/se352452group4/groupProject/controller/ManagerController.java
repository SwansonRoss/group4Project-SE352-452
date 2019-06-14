package edu.depaul.cdm.se352452group4.groupProject.controller;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.InventoryItems;
import edu.depaul.cdm.se352452group4.groupProject.model.entity.Manager;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.InventoryItemsRepository;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private ManagerRepository repo;
    private InventoryItemsRepository item_repo;

    @Autowired
    public ManagerController(ManagerRepository repo, InventoryItemsRepository item_repo) {
        this.repo = repo;
        this.item_repo = item_repo;
    }

    @GetMapping("/manager")
    public Iterable<Manager> getAllAccounts(){
        return repo.findAll();
    }

    @PostMapping("manager/createAccount")
    public Manager createAccount(@RequestBody Manager manager){
        while(getManagerById(manager.getId()).isPresent()) {
            manager.setId(manager.getId()
                    +1);
        }

        return repo.save(manager);
    }

    @GetMapping("manager/{managerId}")
    public Optional<Manager> getManagerById (@PathVariable long managerId){
        return repo.findById(managerId);
    }


    @PutMapping("manager/{managerId}")
    public Manager changeManagerPassword (@PathVariable long managerId, String newPassword){
        Manager account = repo.findById(managerId).orElseThrow(
                ()-> new IllegalArgumentException("Manager ID: " + managerId + " does not exist")
        );

        if(account.getPassword() == newPassword) { throw new IllegalArgumentException("Must be a password!"); }
        else account.setPassword(newPassword);

        return account;
    }

    @GetMapping("/email/{email}")
    public Manager getAccountByEmail (@PathVariable String email) {
        if(!email.endsWith(".com")) { email += ".com";}
        return repo.findByEmail(email);
    }

    @GetMapping("/manager/{managerId}/delete")
    public void deleteAccount(@PathVariable long managerId) {
        Manager account = repo.findById(managerId).orElseThrow(
                ()-> new IllegalArgumentException("Account ID: " + managerId + " does not exist")
        );

        repo.delete(account);

    }

    @PutMapping("/manager/inv/price/{id}")
    public void updatePrice(@PathVariable long id, double newPrice){
        InventoryItems item = item_repo.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Does not exist")
        );
        item.setPrice(newPrice);
    }

    @PutMapping("/manager/inv/quantity/{id}")
    public void updateQuantity(@PathVariable long id, int quantity){
        InventoryItems item = item_repo.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Does not exist")
        );
        item.setQuantity(quantity);
    }

    @PostMapping("/manager/inv/add_item")
    public InventoryItems addItem(@RequestBody InventoryItems item){
        return item_repo.save(item);
    }
}
