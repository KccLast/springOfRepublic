package com.kcc.rich.service;

import org.springframework.stereotype.Service;

import com.kcc.rich.domain.PaymentVO;
import com.kcc.rich.dto.TossPaymentResponse;
import com.kcc.rich.mapper.PaymentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentMapper paymentMapper;

	// 결제 정보를 DB에 저장하는 메서드
	public void savePaymentInfo(TossPaymentResponse paymentResult) {
		PaymentVO payment = PaymentVO.builder()
			.paymentKey(paymentResult.getPaymentKey())
			.orderId(paymentResult.getOrderId())
			// .amount(paymentResult.getAmount())
			// .customerName(paymentResult.getCustomerName())
			.status(paymentResult.getStatus())
			.build();

		paymentMapper.insertPayment(payment);
	}
}
