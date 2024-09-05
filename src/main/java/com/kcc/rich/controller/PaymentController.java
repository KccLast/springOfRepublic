package com.kcc.rich.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcc.rich.config.TossPaymentConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/payments/toss")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {
	private final TossPaymentConfig tossPaymentConfig;

	@PostMapping("/request")
	public ResponseEntity<Map<String, String>> requestPayment(@RequestBody Map<String, Object> paymentData) {
		try {
			String paymentUrl = createTossPayment(paymentData);
			Map<String, String> response = new HashMap<>();
			response.put("paymentUrl", paymentUrl);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}

	private String createTossPayment(Map<String, Object> paymentData) throws Exception {
		// 토스페이먼츠 API 호출을 위한 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth(tossPaymentConfig.getTestClientApiKey(), ""); // 클라이언트 API 키 사용

		// API 요청 바디 설정
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("amount", paymentData.get("amount"));
		requestBody.put("orderId", paymentData.get("orderId"));
		requestBody.put("orderName", paymentData.get("orderName"));
		requestBody.put("successUrl", paymentData.get("successUrl"));
		requestBody.put("failUrl", paymentData.get("failUrl"));

		log.info("amount : " + paymentData.get("amount"));
		log.info("orderId : " + paymentData.get("orderId"));
		log.info("orderName : " + paymentData.get("orderName"));
		log.info("successUrl : " + paymentData.get("successUrl"));
		log.info("failUrl : " + paymentData.get("failUrl"));

		// API 요청 전송
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

		log.info(entity.getBody().toString());

		ResponseEntity<String> response = restTemplate.postForEntity(
			"https://api.tosspayments.com/v1/payments", entity, String.class);

		// 응답 처리
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonResponse = objectMapper.readTree(response.getBody());
		log.info(jsonResponse.get("paymentPageUrl").asText());
		return jsonResponse.get("paymentPageUrl").asText(); // 결제 페이지 URL 반환
	}

	@PostMapping("/success")
	public String paymentSuccess(@RequestParam Map<String, String> paramMap, Model model) {
		// 결제 성공 처리 로직
		model.addAttribute("orderId", paramMap.get("orderId"));
		model.addAttribute("amount", paramMap.get("amount"));
		model.addAttribute("paymentKey", paramMap.get("paymentKey"));

		// 예: DB에 결제 정보 저장, 사용자에게 알림 전송 등
		return "paymentSuccess"; // 성공 페이지로 이동
	}

	@PostMapping("/fail")
	public String paymentFail(@RequestParam Map<String, String> paramMap, Model model) {
		// 결제 실패 처리 로직
		model.addAttribute("message", paramMap.get("message"));
		model.addAttribute("code", paramMap.get("code"));

		// 예: 로그 남기기, 사용자에게 실패 메시지 전달 등
		return "paymentFail"; // 실패 페이지로 이동
	}
}
