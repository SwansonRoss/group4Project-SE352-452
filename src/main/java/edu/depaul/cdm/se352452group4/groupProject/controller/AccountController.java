package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private AccountRepository repo;

    @Autowired
    public AccountController(AccountRepository repo) { this.repo = repo; }

    @GetMapping
    public Iterable<Account> getAllAccounts(){
        return repo.findAll();
    }

    @PostMapping("user/createAccount")
    public Account createAccount(@RequestBody Account account){
//        while(getAccountById(account.getAccount_Id()).isPresent()) {
//            account.setAccount_Id(account.getAccount_Id()+1);
//        }

        return repo.save(account);
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

    @GetMapping("/user/{accountId}/delete")
    public void deleteAccount(@PathVariable int accountId) {
        Account account = repo.findById(accountId).orElseThrow(
                ()-> new IllegalArgumentException("Account ID: " + accountId + " does not exist")
        );

       repo.delete(account);

    }
}
