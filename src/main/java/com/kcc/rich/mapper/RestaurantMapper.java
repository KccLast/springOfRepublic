package com.kcc.rich.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kcc.rich.domain.MenuVO;
import com.kcc.rich.domain.ReviewCount;
import com.kcc.rich.domain.ReviewVO;
import com.kcc.rich.dto.RestaurantHomeResponse;
import com.kcc.rich.dto.RestaurantReviewResponse;

@Mapper
public interface RestaurantMapper {
	RestaurantHomeResponse selectRestaurant(Long restaurant_id);
	List<MenuVO> selectMenuList(Long restaurant_id);
	String selectRestaurantMenuBoard(Long restaurant_id);
	List<ReviewCount> selectRestaurantReviewCount(Long restaurant_id);
	RestaurantReviewResponse selectRestaurantReviewAvg(Long restaurant_id);
	List<ReviewVO> selectRestaurantReview(Long restaurant_id);
}
