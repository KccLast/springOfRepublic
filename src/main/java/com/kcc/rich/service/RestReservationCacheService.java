package com.kcc.rich.service;

import java.util.List;

import com.kcc.rich.domain.ReservationTime;
import com.kcc.rich.dto.ReservationCache;

public interface RestReservationCacheService {
	public void saveToCache(Long key, ReservationCache value);
	public List<String> readFromCache(Long key, String curDate);
}
