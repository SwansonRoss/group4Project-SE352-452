package edu.depaul.cdm.se352452group4.groupProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class StoreController implements WebMvcConfigurer {

    @Controller
    public class StartController{

        @GetMapping("/test-mapping") //Give URL to start mapping
        public String basicMapping(){

            return "home"; //give name of html file in templates to serve up
        }

        @GetMapping("/")
        public String homepageRoute(){
            return "../static/index";
        }

        @GetMapping("/login")
        public String loginRoute(){
            return "../static/account/account";
        }

        @GetMapping("/sign-up")
        public String registrationRoute(){
            return "../static/account/register";
        }

        @GetMapping("/women")
        public String womenRoute(){
            return "../static/womens/womens";
        }

        @GetMapping("/men")
        public String menRoute(){
            return "../static/men/index";
        }

        @GetMapping("/accessories")
        public String accessoriesRoute(){
            return "../static/accessories/accessories";
        }

        @GetMapping("/sale")
        public String saleRoute(){
            return "../static/sale/sale";
        }


        @GetMapping("/checkout")
        public String checkoutRoute(){

            return  "checkout/index";
        }

        //TODO: make this only accessible for managers
        @GetMapping("/manage-inventory")
        public String managerRoute(){
            return "manager/index";
        }
    }


}
