package edu.depaul.cdm.se352452group4.groupProject.controller;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.InventoryItems;
import edu.depaul.cdm.se352452group4.groupProject.model.entity.Transactions;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.InventoryItemsRepository;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Controller
public class TransactionController implements WebMvcConfigurer {

    private TransactionsRepository transRepo;
    private InventoryItemsRepository IIrepo;

    @Autowired
    public TransactionController(TransactionsRepository tRepo, InventoryItemsRepository iRepo){
        this.transRepo = tRepo;
        this.IIrepo =iRepo;
    }

    @PostMapping("/clear")
    private String clearCart(HttpServletRequest request, HttpServletResponse response){
        Cookie[] checkCookies = request.getCookies();
        if(checkCookies != null) {
            for (Cookie c : checkCookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }
        }
        return "checkout/index";
    }

    @GetMapping("/checkout")
    public String checkoutRoute(Model model, HttpServletRequest request){
        List<Long> itemIds = getShoppingCartIds(request);
        Double subtotal = 0.0;
        if(itemIds == null){return  "checkout/index";}

        try {
            List<InventoryItems> cartItems = new ArrayList<>();
            for (Long itemId : itemIds) {
                InventoryItems item = IIrepo.findById(itemId).get();
                subtotal += item.getPrice();
                cartItems.add(item);
            }

            model.addAttribute("subtotal", subtotal);
            model.addAttribute("items", cartItems);

        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        } finally {
            itemIds.clear();
        }

        return  "checkout/index";
    }

    @PostMapping("/checkout")
    public String processTransaction(HttpServletRequest request){
        if (validateCard()) {
            List<Long> itemIds = getShoppingCartIds(request);
            Double subtotal = 0.0;
            int quantity = 0;
            if (itemIds == null) {
                return null;
            }

            List<InventoryItems> cartItems = new ArrayList<>();
            for (Long itemId : itemIds) {
                InventoryItems item = IIrepo.findById(itemId).get();
                item.setQuantity(item.getQuantity() - 1);
                subtotal += item.getPrice();
                cartItems.add(item);
                quantity++;
                IIrepo.save(item);

            }
            for (InventoryItems i : cartItems) {
                System.out.println(i.getItemName());
            }

//            while (getTransactionsById(t.getTransaction_Id()).isPresent()) {
//                t.setTransaction_Id(t.getTransaction_Id() + 1);
//            }

            int i = 0;

            while(transRepo.findById(i).isPresent()){
                i++;
            }

            Transactions t = new Transactions();

            Date date = new Date();

            t.setTransaction_Id(i);
            t.setOrder_Date(date);
            t.setTotal_Items(quantity);
            t.setTransactions_Total(subtotal);

            transRepo.save(t);
            return "redirect:/confirmation";
        }
        return "redirect:/checkout";
    }

    @GetMapping("user/accountId/{accountId}")
    public Optional<Transactions> getTransactionById (@PathVariable int accountId){

        return transRepo.findById(accountId);
    }

    @GetMapping("/confirmation")
    public String checkoutRoute(Model model){
        return "success";
    }

    private List<Long> getShoppingCartIds(HttpServletRequest request){
        Cookie[] checkCookies = request.getCookies();
        List<Long> itemIds = new ArrayList<>();
        if(checkCookies != null) {
            for (Cookie c : checkCookies) {
                //If "cart_items" cookie exists, splits to create a list
                if (c.getName().equals("cart_items")) {
                    String cartString = c.getValue();
                    String[] cartIds = cartString.split("-");
                    for(String cartId : cartIds){
                        itemIds.add(Long.parseLong(cartId));
                    }
                }
            }
        }
        return itemIds;

    }

    private boolean validateCard(){
        return true;
    }


//    public Transactions createTransaction(HttpServletResponse response, @RequestBody Transactions t){
//        while(getTransactionsById(t.getTransaction_Id()).isPresent()){
//            t.setTransaction_Id(t.getTransaction_Id() + 1);
//        }
//        Cookie transactionCookie = new Cookie("transaction_Id", t.getTransaction_Id().toString());
//        transactionCookie.setMaxAge(172800); //stores cookie for 2 days
//        response.addCookie(transactionCookie);
//
//        return repo.save(t);
//
//    }

    @GetMapping("men/{tId}")
    public Optional<Transactions> getTransactionsById (@PathVariable Integer tId){
        return transRepo.findById(tId);
    }

}

