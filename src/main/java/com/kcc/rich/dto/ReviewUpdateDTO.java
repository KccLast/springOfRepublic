package com.kcc.rich.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewUpdateDTO {
    private Long reservation_id;
    private String review_content;
}
