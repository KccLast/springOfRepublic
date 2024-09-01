package com.kcc.rich.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kcc.rich.domain.MenuVO;
import com.kcc.rich.dto.RestaurantHomeResponse;

@Mapper
public interface RestaurantMapper {
	RestaurantHomeResponse selectRestaurant(Long restaurant_id);
	List<MenuVO> selectMenuList(Long restaurant_id);
	String selectRestaurantMenuBoard(Long restaurant_id);
}
