package com.kcc.rich.mapper;

import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;
import com.kcc.rich.util.won.RestaurantRankDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantsMapper {
    List<RestaurantRankDTO> selectRestaurantsWithPage(Criteria cri);
    int selectRestaurantAll(Criteria cri);
    int insertRestaurants(RestaurantJsonDTO.ResInfo restaurantJsonDTO);
    int insertResDetail(RestaurantJsonDTO.ResInfo restaurantJsonDTO);
    int insertMenus(Long restaurantId);
}
