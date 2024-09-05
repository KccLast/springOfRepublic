package com.kcc.rich.controller;

import java.util.HashMap;
import java.util.Map;

import com.kcc.rich.auth.PrincipalDetail;
import com.kcc.rich.domain.member.MemberVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcc.rich.config.TossPaymentConfig;
import com.kcc.rich.dto.ReservationRequest;
import com.kcc.rich.dto.TossPayDTO;
import com.kcc.rich.dto.TossPaymentResponse;
import com.kcc.rich.service.PaymentService;
import com.kcc.rich.service.ReservationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/payments/toss")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {
	private final TossPaymentConfig tossPaymentConfig;
	private final PaymentService paymentService;
	private final ReservationService reservationService;

	@PostMapping("")
	public String payment(TossPayDTO tossPayDTO, Model model) {
		System.out.println(tossPayDTO);
		log.info(String.valueOf(tossPayDTO.getReservation_price()));
		model.addAttribute("tossPayDTO", tossPayDTO);
		System.out.println(tossPayDTO.getReservation_date());

		return "restaurantDetail/tossPay";
	}

	@GetMapping("/success")
	public String handlePaymentSuccess(
		@RequestParam String paymentKey,
		@RequestParam String orderId,
		@RequestParam Long amount,
		Model model,@AuthenticationPrincipal PrincipalDetail principalDetail,
		@RequestParam Long restaurant_id,
		@RequestParam Integer reservation_per,
		@RequestParam Long reservation_date) {
		MemberVO loginMember = principalDetail.getMember();
		System.out.println("성공한 로그인 유저 : "+loginMember.toString());
		try {
			// 1. 결제 승인 요청 보내기
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setBasicAuth(tossPaymentConfig.getTestSecretKey(), ""); // Basic 인증 (secretKey)
			headers.set("Content-Type", "application/json");

			String confirmUrl = "https://api.tosspayments.com/v1/payments/confirm";

			// JSON 요청 바디 생성
			Map<String, Object> requestBody = new HashMap<>();
			requestBody.put("paymentKey", paymentKey);
			requestBody.put("orderId", orderId);
			requestBody.put("amount", amount);

			HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);


			System.out.println("paymentKey: " + paymentKey);
			System.out.println("orderId: " + orderId);
			System.out.println("amount: " + amount);

			// 승인 요청
			ResponseEntity<TossPaymentResponse> response = restTemplate.postForEntity(
				"https://api.tosspayments.com/v1/payments/confirm",
				entity, TossPaymentResponse.class);

			System.out.println("Response: " + response);
			System.out.println("Response Body: " + response.getBody());
			System.out.println("Response paymentKey: " + response.getBody().getPaymentKey());
			System.out.println("Response orderId: " + response.getBody().getOrderId());
			// System.out.println("Response amount: " + response.getBody().getAmount());
			// System.out.println("Response customerName: " + response.getBody().getCustomerName());
			System.out.println("Response Status: " + response.getBody().getStatus());

			TossPaymentResponse paymentResult = response.getBody();

			if (paymentResult != null && paymentResult.getStatus().equals("DONE")) {
				// 결제 성공 시 DB에 결제 정보 저장
				paymentService.savePaymentInfo(paymentResult);
				// 결제 완료 후 예약 데이터 추가
				ReservationRequest reservationRequest = ReservationRequest.builder()
					.member_id((long)loginMember.getMember_id())
					.restaurant_id(restaurant_id)
					.reservation_per(reservation_per)
					.reservation_price(Math.toIntExact(amount))
					.build();
				reservationService.addReservaton(reservationRequest);

				// 결제 완료 페이지로 이동
				model.addAttribute("message", "결제가 성공적으로 완료되었습니다.");

				// 내 예약 페이지로 이동
				return "redirect:/reservation/list/"+loginMember.getMember_id();
			} else {
				// 결제 실패 시
				model.addAttribute("message", "결제 승인 실패: " + paymentResult.getMessage());
				return "payment/paymentFail";
			}

		} catch (Exception e) {
			// 오류 처리
			model.addAttribute("message", "결제 처리 중 오류 발생: " + e.getMessage());
			return "payment/paymentFail";
		}
	}

	@GetMapping("/payments/toss/fail")
	public String handlePaymentFail(Model model) {
		model.addAttribute("message", "결제가 실패했습니다.");
		return "payment/paymentFail";
	}

	// @GetMapping("/success")
	// public String paymentSuccess(@RequestParam Map<String, String> paramMap, Model model) {
	//    // 결제 성공 처리 로직
	//    model.addAttribute("orderId", paramMap.get("orderId"));
	//    model.addAttribute("amount", paramMap.get("amount"));
	//    model.addAttribute("paymentKey", paramMap.get("paymentKey"));
	//
	//    // 예: DB에 결제 정보 저장, 사용자에게 알림 전송 등
	//    return "paymentSuccess"; // 성공 페이지로 이동
	// }
	//
	// @GetMapping("/fail")
	// public String paymentFail(@RequestParam Map<String, String> paramMap, Model model) {
	//    // 결제 실패 처리 로직
	//    model.addAttribute("message", paramMap.get("message"));
	//    model.addAttribute("code", paramMap.get("code"));
	//
	//    // 예: 로그 남기기, 사용자에게 실패 메시지 전달 등
	//    return "paymentFail"; // 실패 페이지로 이동
	// }
}
