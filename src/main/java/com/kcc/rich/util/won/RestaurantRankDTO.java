package com.kcc.rich.util.won;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestaurantRankDTO {
    private Long restaurant_id;
    private String restaurant_name;
    private String restaurant_phone;
    private String restaurant_type;
    private String restaurant_address;
    private String restaurant_district;
    private String restaurant_img;
    private String restaurant_menu_board;
    private Double res_avg;
}


