package com.kcc.rich.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ReservationTime implements Serializable {
	private String reservation_date;
	private List<String> reservation_time;
	private Long version;
}
