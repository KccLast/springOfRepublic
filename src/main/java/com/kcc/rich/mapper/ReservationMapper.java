package com.kcc.rich.mapper;

import com.kcc.rich.dto.ReservationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReservationMapper {
    List<ReservationDTO> getReservationsByMemberId(int member_Id);

    ReservationDTO getReservationById(int reservationId);
    void deleteReservation(int reservationId);

    //모든예약
//    List<ReservationDTO> getReservation();
    

    // 예약일과 실제 방문일이 동일한 예약 조회

    List<ReservationDTO> getCompletedReservationsByMemberId(int status);


    List<ReservationDTO> getCancelByMemberId(int member_Id);

    // 작성된 리뷰 목록 조회
    @Select("SELECT r.*, rv.review_score FROM RESERVATIONS r " +
            "JOIN REVIEWS rv ON r.reservation_id = rv.reservation_id " +
            "WHERE r.member_id = #{member_Id}")
    List<ReservationDTO> getReviewedReservationsByMemberId(int member_Id);

    void insertCancel(ReservationDTO res);


}
