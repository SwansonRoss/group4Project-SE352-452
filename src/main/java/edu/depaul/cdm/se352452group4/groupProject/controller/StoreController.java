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
    }


}
