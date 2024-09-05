package com.kcc.rich.mapper;

import com.kcc.rich.dto.ReviewDTO;
import com.kcc.rich.dto.ReviewInsertDTO;
import com.kcc.rich.dto.ReviewUpdateDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReviewMapper {

    // 리뷰 삭제
    void deleteReview(int reservation_id);

    // 리뷰 수정
    void updateReview(ReviewUpdateDTO reviewUpdateDTO);

    // 모든 리뷰 가져오기
    List<ReviewDTO> getAllReviews(Long user_id);



    void insertReview(ReviewInsertDTO reviewInsertDTO);






}
