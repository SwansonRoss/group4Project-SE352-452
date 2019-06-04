package edu.depaul.cdm.se352452group4.groupProject.controller;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.InventoryItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;


@Controller
public class StoreController implements WebMvcConfigurer {

    public class storeItem{
        private double price;
        private String name;
        private String description;
        private String imagePath;

        public storeItem(Double p, String n, String d, String iP){
            this.price = p;
            this.name = n;
            this.description = d;
            this.imagePath = iP;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }
    };


    storeItem mensItem = new storeItem(75.00, "Addidas Pullover", "A very nice sweatshirt", "http://3.bp.blogspot.com/-c_xcQb-uG44/VazuWruXvGI/AAAAAAAAB-I/MojGhTH4CvQ/s1600/AB9577_01_laydown.jpg");
    storeItem womensItem = new storeItem(495.00,"Gucci Shirt, white","It's a Gucci shirt. You know you want this Gucci shirt","https://images.neimanmarcus.com/ca/5/product_assets/T/Q/1/P/Z/NMTQ1PZ_mz.jpg");
    storeItem accessoriesItem = new storeItem(395.00,"Nike Air Fear of God","Nice shoes","https://stockx.imgix.net/Nike-Air-Fear-Of-God-Strap-Light-Bone-Product.jpg");
    storeItem saleItem = new storeItem(25.00, "Pink Hoodie","Don't miss this sweet deal","https://lp2.hm.com/hmgoepprod?set=source[/16/cb/16cb1b9d193f4a95c267444a265b7efa33f56495.jpg],origin[dam],category[men_hoodiessweatshirts],type[DESCRIPTIVESTILLLIFE],res[s],hmver[1]&call=url[file:/product/main]");



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
        public String womenRoute(Model model){

            model.addAttribute("pageTitle", "Women's");
            model.addAttribute("itemCategory1", "Dresses");
            model.addAttribute("itemCategory2", "Shirts");
            model.addAttribute("itemCategory3", "Pants");

            model.addAttribute("items", womensItem);

            return "shopping-page/index";
        }

        @GetMapping("/men")
        public String menRoute(Model model){


            model.addAttribute("pageTitle", "Men's");
            model.addAttribute("itemCategory1", "Suits");
            model.addAttribute("itemCategory2", "Shirts");
            model.addAttribute("itemCategory3", "Pants");

//            model.addAttribute("itemName", item.getName());
//            model.addAttribute("itemPrice", item.getPrice());
//            model.addAttribute("itemDescription", item.getName());
//            model.addAttribute("imagePath", item.getImagePath());

            ArrayList<storeItem> itemArrayList = new ArrayList<>();
            itemArrayList.add(mensItem);
            itemArrayList.add(accessoriesItem);
            itemArrayList.add(saleItem);

            model.addAttribute("items", itemArrayList);


            return "shopping-page/index";
        }

        @GetMapping("/accessories")
        public String accessoriesRoute(Model model){

            model.addAttribute("pageTitle", "Accessories");
            model.addAttribute("itemCategory1", "Purses");
            model.addAttribute("itemCategory2", "Shoes");
            model.addAttribute("itemCategory3", "Belts");

            ArrayList<storeItem> itemArrayList = new ArrayList<>();
            itemArrayList.add(accessoriesItem);
            itemArrayList.add(saleItem);

            model.addAttribute("items", itemArrayList);

            return "shopping-page/index";
        }

        @GetMapping("/sale")
        public String saleRoute(Model model){

            model.addAttribute("pageTitle", "Accessories");
            model.addAttribute("itemCategory1", "Purses");
            model.addAttribute("itemCategory2", "Shoes");
            model.addAttribute("itemCategory3", "Belts");

            ArrayList<storeItem> itemArrayList = new ArrayList<>();
            itemArrayList.add(saleItem);
            itemArrayList.add(mensItem);
            itemArrayList.add(saleItem);

            model.addAttribute("items", itemArrayList);

            return "shopping-page/index";
        }

        @GetMapping("/checkout")
        public String checkoutRoute(Model model){
            model.addAttribute("itemName", "Addidas Pullover");
            return  "checkout/index";
        }

        //TODO: make this only accessible for managers
        @GetMapping("/manage-inventory")
        public String managerRoute(){
            return "manager/index";
        }
    }


}
