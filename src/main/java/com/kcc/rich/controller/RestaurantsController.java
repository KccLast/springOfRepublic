package com.kcc.rich.controller;

import com.kcc.rich.domain.ReservationTime;
import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.dto.ReservationCache;
import com.kcc.rich.service.RestReservationCacheService;
import com.kcc.rich.service.RestaurantService;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.PageDTO;
import com.kcc.rich.util.SearchKeyword;
import com.kcc.rich.util.won.RestaurantRankDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RestaurantsController {

    private final RestaurantService restaurantService;
    private final RestReservationCacheService restReservationCacheService;

    @GetMapping({"/","/{page}"})
    public String showMainPage(Criteria cri, Model model, SearchKeyword searchKeyword) {

        if(searchKeyword != null) {
            if(searchKeyword.getRestaurant_district() != null
                    && searchKeyword.getRestaurant_district().equals("전체")) {
                searchKeyword.setRestaurant_district(null);
            }
            cri.setSearchKeyword(searchKeyword);
        }
        List<RestaurantRankDTO> restaurantList = restaurantService.getRestaurantList(cri);

        int total = restaurantService.getRestaurantCount(cri);
        PageDTO pageDTO  = new PageDTO(cri,total);
        model.addAttribute("pageDTO",pageDTO);
        model.addAttribute("resList",restaurantList);

        // Cache Save
        List<String> timeList = new ArrayList<>();
        for (int i = 10; i <= 18; i+=2) {
            timeList.add(Integer.toString(i) + ":00");
        }

        List<ReservationTime> reservationTimeList = new ArrayList<>();
        for (int i = 4; i <= 30; i++) {
            reservationTimeList.add(
                ReservationTime.builder()
                    .reservation_date("2024-09-" + String.format("%02d", i))
                    .reservation_time(timeList)
                    .version(1L)
                    .build()
            );
        }

        ReservationCache reservationCache = ReservationCache.builder()
            // .restaurant_id(1L)
            .reservationTimeList(reservationTimeList)
            .build();

        restReservationCacheService.saveToCache(1L, reservationCache);

        return "main";
    }
}
