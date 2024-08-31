package com.kcc.rich.mapper;

import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.util.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantsMapper {
    List<RestaurantVO> selectRestaurantsWithPage(Criteria cri);
    int selectRestaurantAll(Criteria cri);
}
