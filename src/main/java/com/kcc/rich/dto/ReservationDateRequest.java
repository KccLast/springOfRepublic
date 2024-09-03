package com.kcc.rich.dto;

import lombok.Getter;

@Getter
public class ReservationDateRequest {
	private Long restaurant_id;
	private String cur_date;
}
