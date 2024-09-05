package com.kcc.rich.util.won;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.cache.CacheManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource("classpath:api.properties")
class RestTimeCacheServiceTest {

//    @Autowired
//    private RestTimeCacheService restTimeCacheService;
//    @Autowired
//    private CacheManager cacheManager;
//
//    //테스트용 ID
//    private static final Long TEST_SUCCESS_REST_ID = 1L;
//    private static final Long TEST_FAIL_REST_ID = 0L;
//    private static final String TEST_DATE = "2024-09-04";
//
//    //version이 0L인 데이터 추가
//    @BeforeEach
//    void setUp() {
//        // 초기화 메서드 호출하여 캐시 설정
//        restTimeCacheService.init();
//    }
//
//    @Test
//    @DisplayName("데이터 잘 ")
//    void getRestDateTimeSuccessTest() {
//        RestDateTime restDateTime = restTimeCacheService.getRestDateTime(1L, TEST_DATE);
//        assertNotNull(restDateTime);
//        assertEquals(TEST_DATE, restDateTime.getDate());
//        assertFalse(restDateTime.getTime().isEmpty());
//    }
//
//    @Test
//    void updateRestTimeDataSuccessTest() throws OptimisticLockException {
//        //given
//        //클라이언트에서 아래 데이터를 요청했다고 가정
//        RestDateTime clientRestDateTime = new RestDateTime();
//        clientRestDateTime.setDate(TEST_DATE);
//        clientRestDateTime.setTime(List.of("10:00"));  // 예약된 시간을 삭제 요청
//        clientRestDateTime.setVersion(0L);  // 캐시 버전과 맞춰서 요청
//
//        // 업데이트가 성공했는지 확인
//        //when
//        boolean result = restTimeCacheService.updateRestTimeData(TEST_SUCCESS_REST_ID, clientRestDateTime);
//
//        //then
//        assertTrue(result);
//
//        // 진짜 삭제 된건지 확인
//        RestDateTime updatedRestDateTime = restTimeCacheService.getRestDateTime(TEST_SUCCESS_REST_ID, TEST_DATE);
//        assertFalse(updatedRestDateTime.getTime().contains("10:00"));
//        assertEquals(1, updatedRestDateTime.getVersion());
//    }
//
//
//    @Test
//    void updateRestTimeDataConflictTest() {
//        // 버전 충돌 테스트 (클라이언트 버전이 낮음)
//        RestDateTime clientRestDateTime = new RestDateTime();
//        clientRestDateTime.setDate(TEST_DATE);
//        clientRestDateTime.setTime(List.of("9:00"));  // 삭제할 시간
//        clientRestDateTime.setVersion(1L);  // 캐시 버전이 0이므로, 충돌이 발생할 것
//
//        // 버전 충돌 발생을 기대
//        Exception exception = assertThrows(OptimisticLockException.class, () -> {
//            restTimeCacheService.updateRestTimeData(TEST_SUCCESS_REST_ID, clientRestDateTime);
//        });
//
//        assertTrue(exception.getMessage().contains("트랜젝션 충돌 발생"));
//    }
//
//    @Test
//    void raceConditionWithSameVersion() throws InterruptedException {
//        // 동시 요청을 위한 스레드 풀 생성
//        ExecutorService executorService = Executors.newFixedThreadPool(10);  // 10개의 스레드로 동시 실행
//        List<Callable<Boolean>> tasks = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            tasks.add(() -> {
//                RestDateTime clientRestDateTime = new RestDateTime();
//                clientRestDateTime.setDate(TEST_DATE);
//                clientRestDateTime.setTime(List.of("10:00"));
//                clientRestDateTime.setVersion(0L);
//
//
//                try {
//                    return restTimeCacheService.updateRestTimeData(TEST_SUCCESS_REST_ID, clientRestDateTime);
//                } catch (RestTimeDataNotFoundException | OptimisticLockException exc) {
//                    System.out.println("에러발생: " + exc.getMessage());
//                    return false;
//                }
//            });
//        }
//
//       // 모든 작업 실행 후  대기
//        List<Future<Boolean>> results = executorService.invokeAll(tasks);
//
//      // Race Condition 발생 여부를 확인 (충돌로 인해 일부 작업은 실패할 수 있음)
//        long successCount = results.stream().filter(result -> {
//            try {
//                return result.get();  // 성공 여부 확인
//            } catch (InterruptedException | ExecutionException e) {
//                return false;
//            }
//        }).count();
//
//        // 여러 스레드가 실행되었지만 성공한 작업이 1개여야 함
//        assertEquals(1, successCount);
//
//        executorService.shutdown();
//    }
//


}