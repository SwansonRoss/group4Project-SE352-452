package edu.depaul.cdm.se352452group4.groupProject.controller;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.entity.InventoryItems;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.InventoryItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class StartController{

    private InventoryItemsRepository repo;

    @Autowired
    public StartController(InventoryItemsRepository repo) { this.repo = repo; }

    @GetMapping("/")
    public String homepageRoute(){
        return "../static/index";
    }

    @GetMapping("/login")
    public String loginRoute(Account account){
        return "/account/loginForm";
    }

    @GetMapping("/success")
    public String confirmLogin(){
        return "/confirmation/success";
    }
    @GetMapping("/fail")
    public String failLogin(){
        return "/confirmation/fail";
    }

    @GetMapping("/sign-up")
    public String registrationRoute(Account account){
        return "/account/registerForm";
    }

    @GetMapping("/manage")
    public String managerRoute(){
        return "manager/main";
    }

    @GetMapping("/update")
    public String updateItemRoute(){
        return "manager/item-update";
    }

    @GetMapping("/add")
    public String addItemRoute(){
        return "manager/item-add-inventory";
    }

    @GetMapping("/women")
    public String womenRoute(Model model){

        List<InventoryItems> womenList = repo.findByInventoryCategory("women");

        model.addAttribute("pageTitle", "Women's");
        model.addAttribute("itemCategory1", "Dresses");
        model.addAttribute("itemCategory2", "Shirts");
        model.addAttribute("itemCategory3", "Pants");
        model.addAttribute("items", womenList);

        return "shopping-page/index";
    }

    @GetMapping("/men")
    public String menRoute(Model model){
        List<InventoryItems> menList = repo.findByInventoryCategory("men");

        model.addAttribute("pageTitle", "Men's");
        model.addAttribute("itemCategory1", "Suits");
        model.addAttribute("itemCategory2", "Shirts");
        model.addAttribute("itemCategory3", "Pants");
        model.addAttribute("items", menList);

        return "shopping-page/index";
    }

    @GetMapping("/accessories")
    public String accessoriesRoute(Model model){

        List<InventoryItems> accessoriesList = repo.findByInventoryCategory("accessory");

        model.addAttribute("pageTitle", "Accessories");
        model.addAttribute("itemCategory1", "Watches");
        model.addAttribute("itemCategory2", "Ties");
        model.addAttribute("itemCategory3", "Jewelry");
        model.addAttribute("items", accessoriesList);

        return "shopping-page/index";
    }

    @GetMapping("/sale")
    public String saleRoute(Model model){

        List<InventoryItems> saleList = repo.findByInventoryCategory("sale");

        model.addAttribute("pageTitle", "Sales");
        model.addAttribute("itemCategory1", "Shirts");
        model.addAttribute("itemCategory2", "Pants");
        model.addAttribute("itemCategory3", "Accessories");
        model.addAttribute("items", saleList);

        return "shopping-page/index";
    }
}
