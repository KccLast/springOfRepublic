package com.kcc.rich.dto;

import java.util.List;

import com.kcc.rich.domain.MenuVO;

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
public class RestaurantMenuResponse {
	private Long restaurant_id;
	private String menu_board;
	private List<MenuVO> menuList;
}
