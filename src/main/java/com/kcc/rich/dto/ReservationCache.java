package com.kcc.rich.dto;

import java.io.Serializable;
import java.util.List;

import com.kcc.rich.domain.ReservationTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ReservationCache implements Serializable {
	// private Long restaurant_id;
	private List<ReservationTime> reservationTimeList;
}
