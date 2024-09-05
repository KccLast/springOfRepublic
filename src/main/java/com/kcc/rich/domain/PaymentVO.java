package com.kcc.rich.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PaymentVO {
	private Long id; // DB에서 자동 생성 (Auto Increment)
	private String paymentKey;
	private String orderId;
	private Long amount;
	private String customerName;
	private String status; // 결제 상태 (예: DONE, FAILED 등)
}
