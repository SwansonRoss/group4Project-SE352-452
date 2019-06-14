package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.AccountRepository;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    ManagerRepository mr;

    private AccountRepository repo;

    @Autowired
    public AccountController(AccountRepository repo) { this.repo = repo; }

    @GetMapping
    public Iterable<Account> getAllAccounts(){
        return repo.findAll();
    }

    @PostMapping("/registerForm")
    public String createAccount(@ModelAttribute Account account, Model model){
        model.addAttribute("account", new Account());
        while(getAccountById(account.getAccount_Id()).isPresent()) {
            account.setAccount_Id(account.getAccount_Id()+1);
        }

        repo.save(account);
        return "index";
    }

    @GetMapping("user/accountId/{accountId}")
    public Optional<Account> getAccountById (@PathVariable int accountId){
        return repo.findById(accountId);
    }


    @PutMapping("user/accountId/{accountId}")
    public Account changeAccountPassword (@PathVariable int accountId, String newPassword){
        Account account = repo.findById(accountId).orElseThrow(
                ()-> new IllegalArgumentException("Account ID: " + accountId + " does not exist")
        );

        if(account.getPassword() == newPassword) { throw new IllegalArgumentException("Must be a password!"); }
        else account.setPassword(newPassword);

        return account;
    }

    @PostMapping("/loginForm")
    public String login (String email, String password) {
        Account a = new Account();
        a.setEmail(email);
        a.setPassword(password);

        if(repo.findByEmail(a.getEmail()) == null && repo.findByPassword(a.getPassword()) == null) {
            return "login failed";
        }

        if(repo.findByEmail(a.getEmail()) == null && repo.findByPassword(a.getPassword()) == null) {
            return "login failed";
        }

        if(mr.findByEmail(email) != null) {
            return "/main";
        }
        return "login success!";
    }

    @GetMapping("/user/{accountId}/delete")
    public void deleteAccount(@PathVariable int accountId) {
        Account account = repo.findById(accountId).orElseThrow(
                ()-> new IllegalArgumentException("Account ID: " + accountId + " does not exist")
        );

       repo.delete(account);
    }
}
