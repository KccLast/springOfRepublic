package com.kcc.rich.util.won;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import javax.cache.CacheManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;


@RequiredArgsConstructor
public class RestTimeCacheService {
    private final CacheManager cacheManager;
//    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
//    private final ReentrantReadWriteLock.WriteLock writeLock = cacheLock.writeLock();
//    private final ReentrantReadWriteLock.ReadLock readLock = cacheLock.readLock();
//    @PostConstruct
//    public void init() {
//        Cache<Long, RestaurantReservationCacheDTO> restCache = getRestCache();
//        List<String> times = new ArrayList<>(Arrays.asList("9:00", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00"));
//        RestDateTime restDateTime = new RestDateTime("2024-09-04", times, 0L);
//        List<RestDateTime> restDateTimes = new ArrayList<>();
//        restDateTimes.add(restDateTime);
//
//        RestaurantReservationCacheDTO dto = new RestaurantReservationCacheDTO();
//        dto.setRestDateTimeList(restDateTimes);
//
//        restCache.put(1L, dto);
//
//    }

    public RestDateTime getRestDateTime(Long restId, String date) {


                Cache<Long, RestaurantReservationCacheDTO> restCache = getRestCache();
                RestaurantReservationCacheDTO restaurantReservationCacheDTO = restCache.get(restId);

                if (restaurantReservationCacheDTO == null) {
                    throw new RestTimeDataNotFoundException("데이터를 찾을 수 없습니다.");
                }

                return restaurantReservationCacheDTO
                        .getRestDateTimeList().stream()
                        .filter(restDateTime -> restDateTime.getDate().equals(date))
                        .findFirst()
                        .orElseThrow(() -> new RestTimeDataNotFoundException("데이터를 찾을 수 없습니다."));


    }

//    public boolean updateRestTimeData(Long restId, RestDateTime clientRestDateTime) throws OptimisticLockException {
//        RestDateTime cacheRestDateTime=null;
//           // 데이터 조회와 업데이트 전 과정에 대해 락을 건다
//        try{
//            writeLock.lock();
//            cacheRestDateTime = getRestDateTime(restId, clientRestDateTime.getDate());
//            System.out.println(cacheRestDateTime);
//            // 버전 확인 후 업데이트 진행
//            if (clientRestDateTime.getVersion().equals(cacheRestDateTime.getVersion())) {
//                cacheRestDateTime.setVersion(clientRestDateTime.getVersion() + 1);
//                // "10:00" 시간 삭제 로직
//
//
//
//                int idx = cacheRestDateTime.getTime().indexOf(clientRestDateTime.getTime().get(0));
//                if (idx != -1) {
//                    cacheRestDateTime.getTime().remove(idx);
//                    System.out.println("여기 등장");
//                }
//                return true;  // 업데이트 성공
//            }else {
//
//                // 버전이 다르면 예외 발생
//                throw new OptimisticLockException("트랜젝션 충돌 발생. 최신 데이터를 사용해 다시 시도해주세요.");
//
//            }
//        }finally {
//            writeLock.unlock();
//        }
//
//    }


    private Cache<Long, RestaurantReservationCacheDTO> getRestCache() {
        return cacheManager.getCache("restCache", Long.class, RestaurantReservationCacheDTO.class);
    }
}