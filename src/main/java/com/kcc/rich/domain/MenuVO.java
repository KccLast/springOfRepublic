package com.kcc.rich.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuVO {
	private Long restaurant_id;
	private String menu_name;
	private String menu_img;
	private Integer menu_price;
	private String menu_detail;
}