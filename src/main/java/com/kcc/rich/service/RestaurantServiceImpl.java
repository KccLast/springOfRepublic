package com.kcc.rich.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kcc.rich.domain.MenuVO;
import com.kcc.rich.dto.RestaurantHomeResponse;
import com.kcc.rich.dto.RestaurantMenuResponse;
import com.kcc.rich.mapper.RestaurantMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantServiceImpl implements RestaurantService{

	private final RestaurantMapper restaurantMapper;

	@Override
	public RestaurantHomeResponse getRestaurantHome(Long restaurant_id) {
		return restaurantMapper.selectRestaurant(restaurant_id);
	}

	@Override
	public RestaurantMenuResponse getRestaurantMenu(Long restaurant_id) {
		// menu list 받아와서
		// 메뉴판 이미지랑 menu list 같이 response에 넣어 내보내기
		List<MenuVO> menuList = restaurantMapper.selectMenuList(restaurant_id);
		String menu_board = restaurantMapper.selectRestaurantMenuBoard(restaurant_id);

		RestaurantMenuResponse restaurantMenuResponse = new RestaurantMenuResponse(restaurant_id, menu_board, menuList);

		return restaurantMenuResponse;
	}

}
