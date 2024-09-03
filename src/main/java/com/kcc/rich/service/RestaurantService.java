package com.kcc.rich.service;


import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;
import com.kcc.rich.util.won.RestaurantRankDTO;
import com.kcc.rich.dto.RestaurantInfoResponse;
import com.kcc.rich.dto.RestaurantHomeResponse;
import com.kcc.rich.dto.RestaurantMenuResponse;
import com.kcc.rich.dto.RestaurantReviewResponse;
import java.util.List;

public interface RestaurantService {
    public List<RestaurantRankDTO> getRestaurantList(Criteria criteria);
    public int getRestaurantCount(Criteria criteria);
    int addRestaurant(RestaurantJsonDTO.ResInfo resInfo);
   	RestaurantHomeResponse getRestaurantHome(Long restaurant_id);
	  RestaurantMenuResponse getRestaurantMenu(Long restaurant_id);
   	RestaurantReviewResponse getRestaurantReview(Long restaurant_id);
	  RestaurantInfoResponse getRestaurantInfo(Long restaurant_id);
}
