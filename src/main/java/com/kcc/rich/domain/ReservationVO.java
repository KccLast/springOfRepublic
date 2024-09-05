package com.kcc.rich.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationVO {
	private Long reservation_id;
	private Long member_id;
	private Long restaurant_id;
	private Integer reservation_per;
	private Integer reservation_price;
	private Date reservation_date;
	private Date reservation_reg_date;
}
