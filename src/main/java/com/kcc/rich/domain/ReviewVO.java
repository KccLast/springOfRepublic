package com.kcc.rich.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {
	private Date review_date;
	private Double review_score;
	private Date review_create;
	private String review_img;
	private String review_content;
	// member
	private Long member_id;
	private String member_nick;
	private String member_img;
}
