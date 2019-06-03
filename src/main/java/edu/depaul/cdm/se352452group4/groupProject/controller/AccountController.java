package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    @Autowired
    private AccountRepository repo;

    public AccountController(AccountRepository repo) { this.repo = repo; }

    @GetMapping
    public Iterable<Account> getAllAccounts(){
        System.out.println("all account ");
        return repo.findAll();
    }

    @PostMapping("user/createAccount")
    public @Valid Account createAccount(@RequestBody Account account){

        Account a = account;
        a.setAccount_Id(99);
        a.setFirstName("Bo");
        a.setLastName("Jackson");
        a.setEmail("bjackson@gmail.com");
        a.setPassword("pw324");
        System.out.println("create account ");
        return repo.save(a);
    }

    @GetMapping("user/accountId/{accountId}")
    public Optional<Account> getAccountById (@PathVariable int accountId){
        return repo.findById(accountId);
    }

    @GetMapping("/email/{email}")
    public Account getAccountByEmail (@PathVariable String email) {
        if(!email.endsWith(".com")) { email += ".com";}
        return repo.findByEmail(email);
    }
}
