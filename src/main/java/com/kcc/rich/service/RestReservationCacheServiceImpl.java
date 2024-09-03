package com.kcc.rich.service;

import java.util.ArrayList;
import java.util.List;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.springframework.stereotype.Service;

import com.kcc.rich.domain.ReservationTime;
import com.kcc.rich.dto.ReservationCache;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestReservationCacheServiceImpl implements RestReservationCacheService {

	private final CacheManager cacheManager;

	// 캐시에 데이터 쓰기
	public void saveToCache(Long key, ReservationCache value) {
		Cache<Long, ReservationCache> cache = cacheManager.getCache("restaurantCache", Long.class, ReservationCache.class);
		cache.put(key, value);
		System.out.println("Data saved to cache: Key = " + key + ", Value = " + value);
	}

	// 캐시에서 데이터 읽기
	public List<String> readFromCache(Long key, String curDate) {
		Cache<Long, ReservationCache> cache = cacheManager.getCache("restaurantCache", Long.class, ReservationCache.class);
		ReservationCache value = cache.get(key);
		System.out.println("Data read from cache: Key = " + key + ", Value = " + value);

		// 원하는 날짜의 시간 리스트만 리턴
		List<String> result = new ArrayList<>();

		for (ReservationTime rt : value.getReservationTimeList()) {
			if(rt.getReservation_date().equals(curDate)){
				result = rt.getReservation_time();
			}
		}

		return result;
	}
}

