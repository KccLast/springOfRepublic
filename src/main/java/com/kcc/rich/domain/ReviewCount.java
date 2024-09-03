package com.kcc.rich.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewCount {
	private Integer review_score;
	private Integer review_cnt;
	private Double review_percent;
}
