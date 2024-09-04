package com.kcc.rich.service;

import org.springframework.scheduling.annotation.Scheduled;

public class ReservationServiceImpl implements ReservationService {

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void setReservationToVisited() {
    }
}
