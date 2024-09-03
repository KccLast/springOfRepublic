package com.kcc.rich.dto;

import java.util.List;

import com.kcc.rich.domain.ReviewCount;
import com.kcc.rich.domain.ReviewVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReviewResponse {
	private Long restaurant_id;
	private Integer review_total;
	private Double review_avg;
	private List<ReviewCount> review_count_list;
	private List<ReviewVO> review_list;
}
