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
        } else {

            StringBuilder cookieBuilder = new StringBuilder();
            cookieBuilder.append(id);
            cookieBuilder.append("-");

            cookieString = cookieBuilder.toString();
        }

        Cookie cartCookie = new Cookie("cart_items", cookieString);
        //cartCookie.setMaxAge(172800);
        response.addCookie(cartCookie);
    }
}
