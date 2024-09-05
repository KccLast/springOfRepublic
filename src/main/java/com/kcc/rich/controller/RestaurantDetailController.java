package com.kcc.rich.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kcc.rich.dto.ReservationDateRequest;
import com.kcc.rich.service.RestReservationCacheService;
import com.kcc.rich.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantDetailController {

    private final RestaurantService restaurantService;
    private final RestReservationCacheService restReservationCacheService;

    @GetMapping("/home/{restaurant_id}")
    public ModelAndView getHome(@PathVariable Long restaurant_id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("restaurantHomeResponse", restaurantService.getRestaurantHome(restaurant_id));
        mav.setViewName("restaurantDetail/restaurantHome");

        return mav;
    }

    @PostMapping("/reservation")
    public ResponseEntity getReservationDate(@RequestBody ReservationDateRequest reservationDateRequest){
        return ResponseEntity.ok(restReservationCacheService.readFromCache(reservationDateRequest.getRestaurant_id(), reservationDateRequest.getCur_date()));
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

    @GetMapping("/info/{restaurant_id}")
    public ModelAndView getInfo(@PathVariable Long restaurant_id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("RestaurantInfoResponse", restaurantService.getRestaurantInfo(restaurant_id));
        mav.setViewName("restaurantDetail/restaurantInfo");

        return mav;
    }
}
