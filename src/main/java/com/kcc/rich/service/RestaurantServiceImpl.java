package com.kcc.rich.service;

import com.kcc.rich.domain.RestaurantVO;
import com.kcc.rich.mapper.RestaurantsMapper;
import com.kcc.rich.util.Criteria;
import com.kcc.rich.util.won.RestaurantJsonDTO;
import com.kcc.rich.util.won.RestaurantRankDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantsMapper restaurantsMapper;

    @Override
    public List<RestaurantRankDTO> getRestaurantList(Criteria criteria){
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
        restaurantsMapper.insertMenus(resInfo.getRestaurant_id());
        return 0;
    }
}
