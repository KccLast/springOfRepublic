package com.kcc.rich.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kcc.rich.dto.RestaurantHomeResponse;

@Mapper
public interface RestaurantMapper {
	RestaurantHomeResponse selectRestaurant(Long restaurant_id);
}
