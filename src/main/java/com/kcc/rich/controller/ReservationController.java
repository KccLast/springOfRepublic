package com.kcc.rich.controller;

import com.kcc.rich.auth.PrincipalDetail;
import com.kcc.rich.domain.member.MemberVO;
import com.kcc.rich.dto.ReservationDTO;
import com.kcc.rich.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

//예약 모두 조회
//    @GetMapping("/list")
//    public String listReservations(Model model) {
//        List<ReservationDTO> reservations = reservationService.getReservation();
//        model.addAttribute("reservations", reservations);
//        return "mypage/reservation1/reservation_list";  // 예약 목록을 보여주는 JSP 페이지
//    }
    
    //member_id로 조회(완)
//    @GetMapping("/list/{member_id}")
//    public String listReservations(Model model, @PathVariable(required = false) Integer member_id, @AuthenticationPrincipal PrincipalDetail principalDetail) {
//
//        MemberVO loginMember = principalDetail.getMember();
//        List<ReservationDTO> reservations = reservationService.getReservationsByMemberId(loginMember.getMember_id());
//        System.out.println(reservations);
//        System.out.println(member_id);
//        model.addAttribute("reservations", reservations);
//        model.addAttribute("member_id", member_id);
//        return "mypage/reservation1/reservation_list";
//    }
    @GetMapping("/list")
    public String listReservations(Model model, @AuthenticationPrincipal PrincipalDetail principalDetail) {

        MemberVO loginMember = principalDetail.getMember();

        List<ReservationDTO> reservations = reservationService.getReservationsByMemberId(loginMember.getMember_id());

        System.out.println(reservations);
        System.out.println(loginMember.getMember_id());
        model.addAttribute("reservations", reservations);
        model.addAttribute("member_id", loginMember.getMember_id());
        return "mypage/reservation1/reservation_list";
    }


//    // 예약 취소 확인 페이지로 이동
//    @GetMapping("/cancel/{member_Id}")
//    public String confirmCancel(@PathVariable(required = true) Integer member_Id, Model model) {
//        // ReservationDTO reservation = reservationService.getReservationById(reservation_Id);
//        List<ReservationDTO> cancelByMemberId = reservationService.getCancelByMemberId(member_Id);
//        System.out.println(cancelByMemberId);
//        model.addAttribute("cancelledReservations", cancelByMemberId);
//        return "mypage/reservation1/reservation_confirm_delete";
//    }

    // 예약 취소 확인 페이지로 이동
    @GetMapping("/cancel")
    public String confirmCancel( Model model,@AuthenticationPrincipal PrincipalDetail principalDetail) {
        MemberVO loginMember = principalDetail.getMember();
        List<ReservationDTO> cancelByMemberId = reservationService.getCancelByMemberId(loginMember.getMember_id());
        System.out.println(cancelByMemberId);
        model.addAttribute("cancelledReservations", cancelByMemberId);
        return "mypage/reservation1/reservation_confirm_delete";
    }


    // 실제 예약 취소를 처리
//    @GetMapping("/cancel/confirm/{reservation_Id}")
//    public String cancelReservation(@PathVariable Integer reservation_Id) {
//        reservationService.cancelReservation(reservation_Id);
//        return "redirect:/mypage/reservation1/reservation_list?memberId=1";  // 예약 목록으로 리다이렉트
//    }

    @PostMapping("/cancel/confirm")
    @ResponseBody
    public String cancelReservation(@RequestBody ReservationDTO reservationDTO) {
        System.out.println(reservationDTO);
        reservationService.cancelReservation(reservationDTO);
        return "예약 취소에 성공했습니다.";  // 예약 목록으로 리다이렉트
    }

    //방문완료페이지
//    @GetMapping("/completed/{memberId}")
//    public String listCompletedReservations(@PathVariable(required = false) Integer memberId, Model model) {
////        if(reservation_status == null) {
////            reservation_status = 2;
////        }
//
//        List<ReservationDTO> completedReservations = reservationService.getCompletedReservations(memberId);
//        System.out.println(completedReservations);
//        model.addAttribute("completedReservations", completedReservations);
//        return "mypage/reservation1/reservation_completed";
//    }

    //방문완료페이지
    @GetMapping("/completed")
    public String listCompletedReservations(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
//        if(reservation_status == null) {
//            reservation_status = 2;
//        }
        MemberVO loginMember = principalDetail.getMember();
        List<ReservationDTO> completedReservations = reservationService.getCompletedReservations(loginMember.getMember_id());
        System.out.println(completedReservations);
        model.addAttribute("completedReservations", completedReservations);
        return "mypage/reservation1/reservation_completed";
    }


    /*보류해두는것



    // 작성된 리뷰 목록 페이지로 이동
    @GetMapping("/reviewed")
    public String listReviewedReservations(Model model, @RequestParam("member_Id") int member_Id) {
        List<ReservationDTO> reviewedReservations = reservationService.getReviewedReservations(member_Id);
        model.addAttribute("reviewedReservations", reviewedReservations);
        return "mypage/review1/reviewed_reservations";
    }

     */

//    리뷰작성
//    /*@PostMapping("/submitReview")
//    public ResponseEntity<?> submitReview(@RequestParam String reviewText, @RequestParam int reviewScore) {
//        // Logic to save the review content and score to the database
//        // Example:
//        Review review = new Review();
//        review.setReviewText(reviewText);
//        review.setReviewScore(reviewScore);
//        reviewService.save(review);
//
//        return ResponseEntity.ok().body("Review submitted successfully");
//    }*/



       



}

