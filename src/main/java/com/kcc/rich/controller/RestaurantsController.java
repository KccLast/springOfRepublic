package com.kcc.rich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantsController {



    @GetMapping({"/","/{page}"})
    public String showMainPage(@PathVariable(required = false) Integer page, Model model ) {
        if(page == null) {page=1;}

        return "main";
    }
}
