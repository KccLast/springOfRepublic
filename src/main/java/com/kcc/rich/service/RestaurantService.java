package com.kcc.rich.service;

import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;
import com.kcc.rich.util.won.RestaurantRankDTO;

import java.util.List;

public interface RestaurantService {
    public List<RestaurantRankDTO> getRestaurantList(Criteria criteria);
    public int getRestaurantCount(Criteria criteria);
    int addRestaurant(RestaurantJsonDTO.ResInfo resInfo);
}
