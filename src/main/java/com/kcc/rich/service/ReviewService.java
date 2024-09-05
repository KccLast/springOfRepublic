package com.kcc.rich.service;

import com.kcc.rich.dto.ReviewDTO;
import com.kcc.rich.dto.ReviewInsertDTO;
import com.kcc.rich.dto.ReviewUpdateDTO;
import com.kcc.rich.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    // 리뷰 삭제 기능
//    public List<ReviewDTO> deleteReview(int rese) {
//        return reviewMapper.deleteReview(reservation_id);
//    }
    public void deleteReview(Integer reservationId) {
        reviewMapper.deleteReview(reservationId);

    }

    // 리뷰 수정 기능
//    public boolean updateReview(ReviewUpdateDTO reviewUpdateDTO) {
//        reviewMapper.updateReview(reviewUpdateDTO);
//        return true;  // 성공 시 true 반환
//    }
    public boolean updateReview(ReviewUpdateDTO reviewUpdateDTO) {
        try {
            reviewMapper.updateReview(reviewUpdateDTO);
            return true;
        } catch (Exception e) {

            System.out.println("Error updating review: " + e.getMessage());
            return false;
        }
    }


    // 리뷰 목록 가져오기
    public List<ReviewDTO> getAllReviews(Integer userId) {  // ReviewDTO 대신 int 타입으로 수정
        return reviewMapper.getAllReviews(userId);
    }

    // 리뷰 작성
    public void saveReview(ReviewInsertDTO reviewInsertDTO) {
        reviewMapper.insertReview(reviewInsertDTO);  // 리뷰 저장 로직 수정
    }


}
