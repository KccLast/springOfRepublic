package com.kcc.rich.mapper;

import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantsMapper {
    List<RestaurantVO> selectRestaurantsWithPage(Criteria cri);
    int selectRestaurantAll(Criteria cri);
    int insertRestaurants(RestaurantJsonDTO.ResInfo restaurantJsonDTO);
    int insertResDetail(RestaurantJsonDTO.ResInfo restaurantJsonDTO);
    int insertMenus(Long restaurantId);
}
