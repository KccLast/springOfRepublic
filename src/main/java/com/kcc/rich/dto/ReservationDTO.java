package com.kcc.rich.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class ReservationDTO {
    private String restaurant_name;
    private String restaurant_type;
    private String restaurant_district;
    private int reservation_Id;
    private int restaurant_Id;
    private int member_Id;
    private int reservation_per;
    private int reservation_price;
    private Date reservation_date;
    private Date reservation_reg_date;
    private String restaurant_address;
    private int reservation_status;
    private String restaurant_img;

}
