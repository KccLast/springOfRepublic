package com.kcc.rich.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TossPayDTO {
    private Integer amount;
    private String orderId;
    private String orderName;
    private String successUrl;
    private String failUrl;
}
