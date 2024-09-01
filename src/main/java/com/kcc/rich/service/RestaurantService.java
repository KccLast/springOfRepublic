package com.kcc.rich.service;

import com.kcc.rich.dto.RestaurantHomeResponse;
import com.kcc.rich.dto.RestaurantMenuResponse;

public interface RestaurantService {
	RestaurantHomeResponse getRestaurantHome(Long restaurant_id);
	RestaurantMenuResponse getRestaurantMenu(Long restaurant_id);
}
