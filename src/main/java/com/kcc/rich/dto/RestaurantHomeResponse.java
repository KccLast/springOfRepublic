package com.kcc.rich.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantHomeResponse {
	private Long restaurant_id;
	private String restaurant_name;
	private String restaurant_type;
	private String restaurant_phone;
	private String restaurant_address;
	private String rest_oneline;
	private Double review_avg;
	private Integer review_total;
	private String cur_day;
	private String start_time;
	private String end_time;
}
