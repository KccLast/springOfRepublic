package com.kcc.rich.controller;

import com.kcc.rich.domain.RestaurantVO;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RestaurantsController {
private final RestaurantService restaurantService;

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
        System.out.println(restaurantList);
        System.out.println(pageDTO);
        model.addAttribute("pageDTO",pageDTO);
        model.addAttribute("resList",restaurantList);
        return "main";
    }
}
