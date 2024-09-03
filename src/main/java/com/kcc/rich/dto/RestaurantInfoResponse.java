package com.kcc.rich.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestaurantInfoResponse {
	private Long restaurant_id;
	private String rest_detailexpl;
	private Double restaurant_x;
	private Double getRestaurant_y;
	private String week_start;
	private String week_end;
	private String weekend_start;
	private String weekend_end;
	private String dayoff;
	private String restaurant_address;
	private String restaurant_phone;
}