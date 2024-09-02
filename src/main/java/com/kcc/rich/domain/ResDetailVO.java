package com.kcc.rich.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResDetailVO {
    private Long restaurant_id;
    private Double restaurant_y;
    private Double restaurant_x;
    private String week_end;
    private String week_start;
    private String weekend_start;
    private String weekend_end;
    private String dayoff;
}
