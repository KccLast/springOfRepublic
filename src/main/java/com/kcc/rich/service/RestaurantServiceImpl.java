package com.kcc.rich.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kcc.rich.domain.MenuVO;
import com.kcc.rich.domain.ReviewCount;
import com.kcc.rich.dto.RestaurantHomeResponse;
import com.kcc.rich.dto.RestaurantMenuResponse;
import com.kcc.rich.dto.RestaurantReviewResponse;
import com.kcc.rich.mapper.RestaurantMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RestaurantServiceImpl implements RestaurantService{

	private final RestaurantMapper restaurantMapper;

	@Override
	public RestaurantHomeResponse getRestaurantHome(Long restaurant_id) {
		return restaurantMapper.selectRestaurant(restaurant_id);
	}

	@Override
	public RestaurantMenuResponse getRestaurantMenu(Long restaurant_id) {
		// menu list 받아와서
		// 메뉴판 이미지랑 menu list 같이 response에 넣어 내보내기
		List<MenuVO> menuList = restaurantMapper.selectMenuList(restaurant_id);
		String menu_board = restaurantMapper.selectRestaurantMenuBoard(restaurant_id);

		RestaurantMenuResponse restaurantMenuResponse = new RestaurantMenuResponse(restaurant_id, menu_board, menuList);

		return restaurantMenuResponse;
	}

	@Override
	public RestaurantReviewResponse getRestaurantReview(Long restaurant_id) {
		RestaurantReviewResponse restaurantReviewResponse = new RestaurantReviewResponse();

		// review 별점 평균, 갯수
		RestaurantReviewResponse tmp = restaurantMapper.selectRestaurantReviewAvg(restaurant_id);
		restaurantReviewResponse.setReview_avg(Math.round(tmp.getReview_avg() * 10) / 10.0);
		restaurantReviewResponse.setReview_total(tmp.getReview_total());

		// review 평점 별 총 개수
		restaurantReviewResponse.setReview_count_list(restaurantMapper.selectRestaurantReviewCount(restaurant_id));

		int reviewTotal = restaurantReviewResponse.getReview_total().intValue();
		log.info("reviewtTotal : " + reviewTotal);

		List<ReviewCount> reviewCountList = restaurantReviewResponse.getReview_count_list();
		for (int i = 0; i < reviewCountList.size(); i++) {
			double avg = ((double)reviewCountList.get(i).getReview_cnt() / reviewTotal) * 100;
			reviewCountList.get(i).setReview_percent(Math.round(avg * 100) / 100.0);
			log.info(i + " : " + reviewCountList.get(i).getReview_percent());
			log.info("cur : " + reviewCountList.get(i).getReview_cnt());
		}
		restaurantReviewResponse.setReview_count_list(reviewCountList);

		// review 리스트
		restaurantReviewResponse.setReview_list(restaurantMapper.selectRestaurantReview(restaurant_id));
		
		return restaurantReviewResponse;
	}

}
