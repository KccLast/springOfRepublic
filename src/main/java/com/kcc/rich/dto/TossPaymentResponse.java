package com.kcc.rich.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TossPaymentResponse {
	private String paymentKey;
	private String orderId;
	// private Long amount;
	// private String customerName;
	private String status;
	private String message;
}
