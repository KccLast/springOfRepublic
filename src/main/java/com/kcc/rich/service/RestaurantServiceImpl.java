package com.kcc.rich.service;
import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.mapper.RestaurantsMapper;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;
import com.kcc.rich.util.won.RestaurantRankDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import com.kcc.rich.domain.MenuVO;
import com.kcc.rich.dto.RestaurantInfoResponse;
import com.kcc.rich.domain.ReviewCount;
import com.kcc.rich.dto.RestaurantHomeResponse;
import com.kcc.rich.dto.RestaurantMenuResponse;
import com.kcc.rich.dto.RestaurantReviewResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {
	private final RestaurantsMapper restaurantsMapper;

	@Override
	public List<RestaurantRankDTO> getRestaurantList(Criteria criteria) {
		return restaurantsMapper.selectRestaurantsWithPage(criteria);
	}

	@Override
	public int getRestaurantCount(Criteria criteria) {
		return restaurantsMapper.selectRestaurantAll(criteria);
	}

	@Override
	@Transactional
	public int addRestaurant(RestaurantJsonDTO.ResInfo resInfo) {
		int restaurantsInsertResult = restaurantsMapper.insertRestaurants(resInfo);
		int resDetailInsertResult = restaurantsMapper.insertResDetail(resInfo);
		//restaurantsMapper.insertMenus(resInfo.getRestaurant_id());
		return 0;
	}


	@Override
	public RestaurantHomeResponse getRestaurantHome(Long restaurant_id) {
		RestaurantHomeResponse restaurantHomeResponse = restaurantsMapper.selectRestaurant(restaurant_id);
		restaurantHomeResponse.setReview_avg(Math.round(restaurantHomeResponse.getReview_avg() * 10) / 10.0);
		return restaurantHomeResponse;
	}

	@Override
	public RestaurantMenuResponse getRestaurantMenu(Long restaurant_id) {
		// menu list 받아와서
		// 메뉴판 이미지랑 menu list 같이 response에 넣어 내보내기
		List<MenuVO> menuList = restaurantsMapper.selectMenuList(restaurant_id);
		String menu_board = restaurantsMapper.selectRestaurantMenuBoard(restaurant_id);

		RestaurantMenuResponse restaurantMenuResponse = new RestaurantMenuResponse(restaurant_id, menu_board, menuList);

		return restaurantMenuResponse;
	}

	@Override
	public RestaurantReviewResponse getRestaurantReview(Long restaurant_id) {
		RestaurantReviewResponse restaurantReviewResponse = new RestaurantReviewResponse();

		// review 별점 평균, 갯수
		RestaurantReviewResponse tmp = restaurantsMapper.selectRestaurantReviewAvg(restaurant_id);
		restaurantReviewResponse.setReview_avg(Math.round(tmp.getReview_avg() * 10) / 10.0);
		restaurantReviewResponse.setReview_total(tmp.getReview_total());

		// review 평점 별 총 개수
		restaurantReviewResponse.setReview_count_list(restaurantsMapper.selectRestaurantReviewCount(restaurant_id));

		int reviewTotal = restaurantReviewResponse.getReview_total().intValue();


		List<ReviewCount> reviewCountList = restaurantReviewResponse.getReview_count_list();
		for (int i = 0; i < reviewCountList.size(); i++) {
			double avg = ((double) reviewCountList.get(i).getReview_cnt() / reviewTotal) * 100;
			reviewCountList.get(i).setReview_percent(Math.round(avg * 100) / 100.0);
		}
		restaurantReviewResponse.setReview_count_list(reviewCountList);

		// review 리스트
		restaurantReviewResponse.setReview_list(restaurantsMapper.selectRestaurantReview(restaurant_id));
		restaurantReviewResponse.setRestaurant_id(restaurant_id);

		return restaurantReviewResponse;
	}

	@Override
	public RestaurantInfoResponse getRestaurantInfo(Long restaurant_id) {
		return restaurantsMapper.selectRestaurantInfo(restaurant_id);
	}

}







