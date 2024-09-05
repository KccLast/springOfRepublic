package com.kcc.rich.service;


import com.kcc.rich.dto.ReservationDTO;
import com.kcc.rich.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;

//    public List<ReservationDTO> getReservation() {
//        return reservationMapper.getReservation();
//    }

      // public void setReservationToVisited();

    public List<ReservationDTO> getReservationsByMemberId(int member_Id) {
        return reservationMapper.getReservationsByMemberId(member_Id);
    }


//    public List<ReservationDTO> getAllRestaurants(Integer reservation_id) {
//        return reservationMapper.getReservation(reservation_id);
//    }
    // 예약 ID로 예약 조회
    public ReservationDTO getReservationById(int reservation_Id) {
        return reservationMapper.getReservationById(reservation_Id);
    }

    // 예약 취소 목록
    public List<ReservationDTO> getCancelByMemberId(int member_Id) {
        return reservationMapper.getCancelByMemberId(member_Id);
    }

    // 예약 취소 처리
    public void cancelReservation(ReservationDTO res) {
        reservationMapper.insertCancel(res);
         //reservationMapper.deleteReservation(reservation_Id);
    }

    // 예약일과 실제 방문일이 동일한 예약 목록 조회
    public List<ReservationDTO> getCompletedReservations(int memberId) {
        return reservationMapper.getCompletedReservationsByMemberId(memberId);
    }

    // 작성된 리뷰 목록 조회
    public List<ReservationDTO> getReviewedReservations(int member_Id) {
        return reservationMapper.getReviewedReservationsByMemberId(member_Id);
    }
}
