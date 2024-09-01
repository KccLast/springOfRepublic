package com.kcc.rich.service;

import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;

import java.util.List;

public interface RestaurantService {
    public List<RestaurantVO> getRestaurantList(Criteria criteria);
    public int getRestaurantCount(Criteria criteria);
    int addRestaurant(RestaurantJsonDTO.ResInfo resInfo);
}
