package com.kcc.rich.service;

import com.kcc.rich.dto.RestaurantHomeResponse;

public interface RestaurantService {
	RestaurantHomeResponse getRestaurantHome(Long restaurant_id);
}
