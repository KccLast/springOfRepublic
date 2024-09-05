package com.kcc.rich.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class ReviewDTO {
    private String restaurant_name;
    private String restaurant_type;
    private String restaurant_address;
    private int reservation_id;
    private int restaurant_id;
    private int reservation_per;
    private String restaurant_district;
    private Date reservation_reg_date;
    private int review_score;
    private String review_content;
    private String restaurant_img;
    private String review_img;
}
