package com.kcc.rich.mapper;

import com.kcc.rich.domain.MenuVO;
import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.domain.ReviewCount;
import com.kcc.rich.domain.ReviewVO;
import com.kcc.rich.dto.RestaurantHomeResponse;
import com.kcc.rich.dto.RestaurantInfoResponse;
import com.kcc.rich.dto.RestaurantReviewResponse;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;
import com.kcc.rich.util.won.RestaurantRankDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantsMapper {
    List<RestaurantRankDTO> selectRestaurantsWithPage(Criteria cri);
    int selectRestaurantAll(Criteria cri);
    int insertRestaurants(RestaurantJsonDTO.ResInfo restaurantJsonDTO);
    int insertResDetail(RestaurantJsonDTO.ResInfo restaurantJsonDTO);
    int insertMenus(Long restaurantId);

    RestaurantHomeResponse selectRestaurant(Long restaurant_id);
    List<MenuVO> selectMenuList(Long restaurant_id);
    String selectRestaurantMenuBoard(Long restaurant_id);
    List<ReviewCount> selectRestaurantReviewCount(Long restaurant_id);
    RestaurantReviewResponse selectRestaurantReviewAvg(Long restaurant_id);
    List<ReviewVO> selectRestaurantReview(Long restaurant_id);
    RestaurantInfoResponse selectRestaurantInfo(Long restaurant_id);
}
