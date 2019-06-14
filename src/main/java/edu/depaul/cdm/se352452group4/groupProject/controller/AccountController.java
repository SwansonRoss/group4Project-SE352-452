package edu.depaul.cdm.se352452group4.groupProject.controller;


import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.AccountRepository;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @GetMapping("/")
    public String welcome() {
        return "/manage";
    }

    @PostMapping("/loginForm")
    public String login (String email, String password, HttpServletResponse response, HttpServletRequest request) throws IOException  {
        Account a = new Account();
        a.setEmail(email);
        a.setPassword(password);

        if(mr.findByEmail(email) != null) {
           response.sendRedirect(request.getContextPath() + "/manage");
           return "yes manager";
        }

        if(repo.findByEmail(a.getEmail()) != null && repo.findByPassword(a.getPassword()) != null) {
            response.sendRedirect(request.getContextPath() + "/");
            return "found account";
        }

        if(repo.findByEmail(a.getEmail()) != null && repo.findByPassword(a.getPassword()) == null) {
            return "fail by 80";
        }

        if(repo.findByEmail(a.getEmail()) == null && repo.findByPassword(a.getPassword()) == null) {
            return "fail by 85";
        }

        return "ERROR 911";

    }

    @GetMapping("/user/{accountId}/delete")
    public void deleteAccount(@PathVariable int accountId) {
        Account account = repo.findById(accountId).orElseThrow(
                ()-> new IllegalArgumentException("Account ID: " + accountId + " does not exist")
        );

       repo.delete(account);
    }
}
