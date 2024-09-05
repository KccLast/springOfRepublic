package com.kcc.rich.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kcc.rich.domain.PaymentVO;

@Mapper
public interface PaymentMapper {
	// 결제 정보를 저장하는 메서드
	void insertPayment(PaymentVO payment);
}
