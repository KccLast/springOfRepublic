package com.kcc.rich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kcc.rich.dto.RestaurantHomeResponse;
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
}
