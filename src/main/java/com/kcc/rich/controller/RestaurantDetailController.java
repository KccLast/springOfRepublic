package com.kcc.rich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kcc.rich.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantDetailController {

    private final RestaurantService restaurantService;

    @GetMapping("/home/{restaurant_id}")
    public ModelAndView getHome(@PathVariable Long restaurant_id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("restaurantHomeResponse", restaurantService.getRestaurantHome(restaurant_id));
        mav.setViewName("restaurantDetail/restaurantHome");

        return mav;
    }

    @GetMapping("/menu/{restaurant_id}")
    public ModelAndView getMenu(@PathVariable Long restaurant_id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("RestaurantMenuResponse", restaurantService.getRestaurantMenu(restaurant_id));
        mav.setViewName("restaurantDetail/restaurantMenu");

        return mav;
    }

    @GetMapping("/review/{restaurant_id}")
    public ModelAndView getReview(@PathVariable Long restaurant_id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("RestaurantReviewResponse", restaurantService.getRestaurantReview(restaurant_id));
        mav.setViewName("restaurantDetail/restaurantReview");

        return mav;
    }

    @GetMapping("/info")
    public ModelAndView getInfo() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("test", "test");
        mav.setViewName("restaurantDetail/restaurantInfo");

        return mav;
    }
}
