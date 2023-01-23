package ua.com.shop.course_shop_np_371_372_2023.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String getPageHome(Model model){

        model.addAttribute("hello", "Hello world!");

        return "home";
    }


}
