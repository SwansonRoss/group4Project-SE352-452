package edu.depaul.cdm.se352452group4.groupProject.controller;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.InventoryItems;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class StoreController implements WebMvcConfigurer {

    @PostMapping("/women")
    public String addWomensToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
        Long id = i.getId();
        updateCookies(response, request, id);

        return "redirect:/women";
    }

    @PostMapping("/men")
    public String addMensToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
        Long id = i.getId();
        updateCookies(response, request, id);
        return "redirect:/men";
    }

    @PostMapping("/accessories")
    public String addAccessoriesToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
        Long id = i.getId();
        updateCookies(response, request, id);
        return "redirect:/accessories";
    }

    @PostMapping("/sale")
    public String addSaleToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
        Long id = i.getId();
        updateCookies(response, request, id);
        return "redirect:/sale";
    }

    private void updateCookies(HttpServletResponse response, HttpServletRequest request, Long id){
        Cookie[] checkCookies = request.getCookies();

        String cookieString = null;
        if(checkCookies != null) {
            for (Cookie c : checkCookies) {
                //If "cart_items" cookie exists, append new itemId to the end.
                if (c.getName().equals("cart_items")) {
                    System.out.println(c.getValue());

                    StringBuilder cookieBuilder = new StringBuilder();
                    cookieBuilder.append(c.getValue());
                    cookieBuilder.append(id);
                    cookieBuilder.append("-");

                    cookieString = cookieBuilder.toString();

                }
            }
        }
        else{
            StringBuilder cookieBuilder = new StringBuilder();
            cookieBuilder.append(id);
            cookieBuilder.append("-");

            cookieString = cookieBuilder.toString();
        }

        Cookie cartCookie = new Cookie("cart_items", cookieString);
        //cartCookie.setMaxAge(172800);
        response.addCookie(cartCookie);
    }



//    @Controller
//    public class StartController{
//
//        private InventoryItemsRepository repo;
//
//        @Autowired
//        public StartController(InventoryItemsRepository repo) { this.repo = repo; }
//
//        @GetMapping("/")
//        public String homepageRoute(){
//            return "../static/index";
//        }
//
//        @GetMapping("/login")
//        public String loginRoute(Account account){
//            return "/account/loginForm";
//        }
//
//        @GetMapping("/sign-up")
//        public String registrationRoute(Account account){
//            return "/account/registerForm";
//        }
//
//        @GetMapping("/women")
//        public String womenRoute(Model model){
//
//            List<InventoryItems> womenList = repo.findByInventoryCategory("women");
//
//            model.addAttribute("pageTitle", "Women's");
//            model.addAttribute("itemCategory1", "Dresses");
//            model.addAttribute("itemCategory2", "Shirts");
//            model.addAttribute("itemCategory3", "Pants");
//
//            model.addAttribute("items", womenList);
//
//            return "shopping-page/index";
//        }
//        @PostMapping("/women")
//        public String addWomensToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
//            Long id = i.getId();
//            updateCookies(response, request, id);
//            return "redirect:/women";
//        }
//
//        @GetMapping("/men")
//        public String menRoute(Model model){
//
//            List<InventoryItems> menList = repo.findByInventoryCategory("men");
//
//            model.addAttribute("pageTitle", "Men's");
//            model.addAttribute("itemCategory1", "Suits");
//            model.addAttribute("itemCategory2", "Shirts");
//            model.addAttribute("itemCategory3", "Pants");
//
//            model.addAttribute("items", menList);
//
//
//            return "shopping-page/index";
//        }
//
//        @PostMapping("/men")
//        public String addMensToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
//            Long id = i.getId();
//            updateCookies(response, request, id);
//            return "redirect:/men";
//        }
//
//        @GetMapping("/accessories")
//        public String accessoriesRoute(Model model){
//
//            List<InventoryItems> accessoriesList = repo.findByInventoryCategory("accessory");
//
//            model.addAttribute("pageTitle", "Accessories");
//            model.addAttribute("itemCategory1", "Purses");
//            model.addAttribute("itemCategory2", "Shoes");
//            model.addAttribute("itemCategory3", "Belts");
//
//            model.addAttribute("items", accessoriesList);
//
//            return "shopping-page/index";
//        }
//        @PostMapping("/accessories")
//        public String addAccessoriesToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
//            Long id = i.getId();
//            updateCookies(response, request, id);
//            return "redirect:/accessories";
//        }
//
//        @GetMapping("/sale")
//        public String saleRoute(Model model){
//
//            List<InventoryItems> saleList = repo.findByInventoryCategory("sale");
//
//            model.addAttribute("pageTitle", "Accessories");
//            model.addAttribute("itemCategory1", "Purses");
//            model.addAttribute("itemCategory2", "Shoes");
//            model.addAttribute("itemCategory3", "Belts");
//            model.addAttribute("items", saleList);
//
//            return "shopping-page/index";
//        }
//        @PostMapping("/sale")
//        public String addSaleToCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("AddToCart") InventoryItems i){
//            Long id = i.getId();
//            updateCookies(response, request, id);
//            return "redirect:/sale";
//        }
//
//
//        //TODO: make this only accessible for managers
//        @GetMapping("/manage")
//        public String managerRoute(){
//            return "manager/index";
//        }
//    }




}
