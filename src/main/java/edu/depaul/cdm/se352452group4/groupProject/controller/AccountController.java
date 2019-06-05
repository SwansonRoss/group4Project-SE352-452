package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts-page")
public class AccountController {

    @Autowired
    private AccountRepository repo;

    public AccountController(AccountRepository repo) { this.repo = repo; }

    @GetMapping("/allAccounts")
    public Iterable<Account> getAllAccounts(){
        System.out.println("all account ");
        return repo.findAll();
    }

    @PostMapping("/createAccount")
    public @Valid Account createAccount(@RequestBody Account account){
        System.out.println("create account ");
        return repo.save(account);
    }

    @GetMapping("/account/{accountId}")
    public Optional<Account> getAccountById (@PathVariable int accountId){
        return repo.findById(accountId);
    }


}
