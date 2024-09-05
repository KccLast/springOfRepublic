package com.kcc.rich.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.cache.Cache;
import javax.cache.CacheManager;

import com.kcc.rich.util.won.OptimisticLockException;
import com.kcc.rich.util.won.RestDateTime;
import com.kcc.rich.util.won.RestTimeDataNotFoundException;
import com.kcc.rich.util.won.RestaurantReservationCacheDTO;
import org.springframework.stereotype.Service;

import com.kcc.rich.domain.ReservationTime;
import com.kcc.rich.dto.ReservationCache;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestReservationCacheServiceImpl implements RestReservationCacheService {

	private final CacheManager cacheManager;
	private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
	private final ReentrantReadWriteLock.WriteLock writeLock = cacheLock.writeLock();
	private final ReentrantReadWriteLock.ReadLock readLock = cacheLock.readLock();

	// 캐시에 데이터 쓰기
	public void saveToCache(Long key, ReservationCache value) {
		Cache<Long, ReservationCache> cache = getRestCache();
		cache.put(key, value);
		System.out.println("Data saved to cache: Key = " + key + ", Value = " + value);
	}

	// 캐시에서 데이터 읽기
	public List<String> readFromCache(Long key, String curDate) {
		Cache<Long, ReservationCache> cache = getRestCache();
				//cacheManager.getCache("restaurantCache", Long.class, ReservationCache.class);
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

	public boolean updateRestTimeData(Long restId, RestDateTime clientRestDateTime) throws OptimisticLockException {
		ReservationTime cacheRestDateTime=null;
		// 데이터 조회와 업데이트 전 과정에 대해 락을 건다
		try{
			writeLock.lock();
			cacheRestDateTime = getRestDateTime(restId, clientRestDateTime.getDate());
			System.out.println(cacheRestDateTime);
			// 버전 확인 후 업데이트 진행
			if (clientRestDateTime.getVersion().equals(cacheRestDateTime.getVersion())) {
				cacheRestDateTime.setVersion(clientRestDateTime.getVersion() + 1);
				// "10:00" 시간 삭제 로직



				int idx = cacheRestDateTime.getReservation_time().indexOf(clientRestDateTime.getTime().get(0));
				if (idx != -1) {
					cacheRestDateTime.getReservation_time().remove(idx);
					System.out.println("여기 등장");
				}
				return true;  // 업데이트 성공
			}else {

				// 버전이 다르면 예외 발생
				throw new OptimisticLockException("트랜젝션 충돌 발생. 최신 데이터를 사용해 다시 시도해주세요.");

			}
		}finally {
			writeLock.unlock();
		}

	}


	public ReservationTime getRestDateTime(Long restId, String date) {


		Cache<Long, ReservationCache> restCache = getRestCache();
		ReservationCache reservationCache = restCache.get(restId);

		if (reservationCache == null) {
			throw new RestTimeDataNotFoundException("데이터를 찾을 수 없습니다.");
		}

		return reservationCache
				.getReservationTimeList().stream()
				.filter(restDateTime -> restDateTime.getReservation_date().equals(date))
				.findFirst()
				.orElseThrow(() -> new RestTimeDataNotFoundException("데이터를 찾을 수 없습니다."));


	}


	private Cache<Long, ReservationCache> getRestCache() {
		return cacheManager.getCache("restaurantCache", Long.class, ReservationCache.class);
	}
}

