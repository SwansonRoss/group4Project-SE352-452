package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class AccountController {

    @Autowired
    private edu.depaul.cdm.se352452group4.groupProject.model.repository.iAccount iAccount;

    @GetMapping("/getAccounts")
    public Iterable<Account> getAllAccounts(){
        return iAccount.findAll();
    }

    @PostMapping("/createAccounts")
    public @Valid Account createAccount(@RequestBody Account account) {
        return iAccount.save(account);
    }
}
