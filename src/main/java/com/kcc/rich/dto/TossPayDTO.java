package com.kcc.rich.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TossPayDTO {
    private Long member_id;
    private Long restaurant_id;
    private String name;
    private String phone;
    private Integer reservation_per;
    private Integer reservation_price;
    private String reservation_date;
}
