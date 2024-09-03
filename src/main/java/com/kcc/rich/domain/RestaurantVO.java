package com.kcc.rich.domain;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class RestaurantVO {
	private Long restaurant_id;
	private String restaurant_name;
	private String restaurant_phone;
	private String restaurant_type;
	private String restaurant_address;
	private String restaurant_district;
	private String restaurant_img;
	private String restaurant_menu_board;


	//메뉴와의 관계
	private List<MenuVO> menus;

	//식당상세와의 관계
	private ResDetailVO res_detail;
}

