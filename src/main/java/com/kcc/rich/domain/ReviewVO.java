package com.kcc.rich.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {
	private Long reservation_id;
	private Date review_date;
	private Double review_score;
	private Date review_create;
	private Date review_update;
}
