package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class AccountController {

    @Autowired
    private AccountRepository repo;

    @GetMapping("/getAccounts")
    public Iterable<Account> getAllAccounts(){
        return repo.findAll();
    }

    @PostMapping("/createAccounts")
    public @Valid Account createAccount(@RequestBody Account account) {
        return repo.save(account);
    }
}
