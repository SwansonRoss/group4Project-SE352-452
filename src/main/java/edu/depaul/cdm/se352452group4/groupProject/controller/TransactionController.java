package edu.depaul.cdm.se352452group4.groupProject.controller;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.entity.Transactions;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.AccountRepository;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/accounts")
public class TransactionController {

    private TransactionsRepository repo;

    @Autowired
    public TransactionController(TransactionsRepository repo){this.repo = repo;}

    @PostMapping("/men")
    public Transactions createTransaction(HttpServletResponse response, @RequestBody Transactions t){
        while(getTransactionsById(t.getTransaction_Id()).isPresent()){
            t.setTransaction_Id(t.getTransaction_Id() + 1);
        }
        Cookie transactionCookie = new Cookie("transaction_Id", t.getTransaction_Id().toString());
        transactionCookie.setMaxAge(172800); //stores cookie for 2 days
        response.addCookie(transactionCookie);

        return repo.save(t);

    }

    @GetMapping("men/{tId}")
    public Optional<Transactions> getTransactionsById (@PathVariable Integer tId){
        return repo.findById(tId);
    }

}

