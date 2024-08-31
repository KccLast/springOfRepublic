package com.kcc.rich.service;

import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.mapper.RestaurantsMapper;
import com.kcc.rich.util.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantsMapper restaurantsMapper;

    @Override
    public List<RestaurantVO> getRestaurantList(Criteria criteria){
        return restaurantsMapper.selectRestaurantsWithPage(criteria);
    }

    @Override
    public int getRestaurantCount(Criteria criteria) {
        return restaurantsMapper.selectRestaurantAll(criteria);
    }
}
