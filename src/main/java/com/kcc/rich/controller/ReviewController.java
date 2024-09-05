package com.kcc.rich.controller;

import com.kcc.rich.dto.ReviewInsertDTO;
import com.kcc.rich.dto.ReviewUpdateDTO;
import com.kcc.rich.service.ReservationService;
import com.kcc.rich.service.ReviewService;
import com.kcc.rich.dto.ReviewDTO;
import com.kcc.rich.util.jina.FileStore;
import com.kcc.rich.util.jina.UploadImage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {


    private final ReviewService reviewService;

    private final ReservationService reservationService;

    private final FileStore fileStore;

//    // 리뷰 조회
    @GetMapping("/list/{user_id}")
    public String list(Model model, @PathVariable Long user_id) {
        List<ReviewDTO> reviews = reviewService.getAllReviews(user_id);

        if (reviews.isEmpty()) {
            model.addAttribute("message", "No reviews found");
        }

        model.addAttribute("reviews", reviews);
        return "mypage/review1/review_list";
    }



    // 리뷰 삭제 처리
//    @PostMapping("/deleteReview")
//    @ResponseBody
//    public String deleteReview(@RequestParam Long reservation_id) {
//        reviewService.deleteReview(reservation_id);
//        return "redirect:/review1/review_list";  // 삭제 후 리스트 페이지로 리다이렉트
//    }

    //아까 되던 것
//    @PostMapping("/deleteReview")
//    @ResponseBody
//    public String deleteReview(@RequestBody ReviewDTO reviewDTO) {
//        System.out.println(reviewDTO);
//        reviewService.deleteReview(reviewDTO.getReservation_id());
//        return "리뷰 삭제 완료.";
//    }

    //리뷰 삭제
    @GetMapping("/deleteReview/{reviewId}")
    @ResponseBody
    public String deleteReview(@PathVariable Integer reviewId) {
        System.out.println(reviewId);
        reviewService.deleteReview(reviewId);
        return "리뷰 삭제 완료.";
    }

    // 리뷰 수정 처리
//    @PostMapping("/updateReview")
//    @ResponseBody
//    public String updateReview(@RequestBody ReviewUpdateDTO reviewUpdateDTO) {
//
//        // 리뷰 업데이트 로직 실행
//        // boolean success = reviewService.updateReview(reservation_id, review_score, review_content);
//
//        // 응답 데이터 준비
//        boolean success = reviewService.updateReview(reviewUpdateDTO);
//
//        System.out.println(success);
//
//        return "업데이트 성공";  // JSON 형태로 클라이언트에 반환
//    }
    @PostMapping("/updateReview")
    @ResponseBody
    public Map<String, Object> updateReview(@RequestBody ReviewUpdateDTO reviewUpdateDTO) {
        System.out.println(reviewUpdateDTO);
        boolean success = reviewService.updateReview(reviewUpdateDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", success ? "Update successful" : "Update failed");
        return response;
    }

    // 리뷰 삽입 (AJAX로 처리된다고 가정)
    @PostMapping("/insert")
    public String insertReview(ReviewInsertDTO reviewInsertDTO) {
        System.out.println(reviewInsertDTO);
        if(reviewInsertDTO.getReview_img() != null) {
            UploadImage uploadImage = fileStore.storeFile(reviewInsertDTO.getReview_img());
            reviewInsertDTO.setFullPath(uploadImage.getFullPath());
        }else{
            reviewInsertDTO.setFullPath("/resources/img/logo.png");
        }
        reviewService.saveReview(reviewInsertDTO);
        return "redirect:/review/list/"+reviewInsertDTO.getMember_id();
    }



}














