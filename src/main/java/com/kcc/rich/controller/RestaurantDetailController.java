package com.kcc.rich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RestaurantDetailController {

    @GetMapping("/restaurant/home")
    public ModelAndView getHome() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("restaurantId", 1);
        mav.setViewName("restaurantDetail/restaurantHome");

        return mav;
    }

    @GetMapping("/restaurant/menu")
    public ModelAndView getMenu() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("test", "test");
        mav.setViewName("restaurantDetail/restaurantMenu");

        return mav;
    }

    @GetMapping("/restaurant/review")
    public ModelAndView getReview() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("test", "test");
        mav.setViewName("restaurantDetail/restaurantReview");

        return mav;
    }

    @GetMapping("/restaurant/info")
    public ModelAndView getInfo() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("test", "test");
        mav.setViewName("restaurantDetail/restaurantInfo");

        return mav;
    }
}
