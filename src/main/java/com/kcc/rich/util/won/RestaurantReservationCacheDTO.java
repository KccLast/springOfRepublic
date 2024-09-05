package com.kcc.rich.util.won;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@ToString
public class RestaurantReservationCacheDTO implements Serializable {
   private List<RestDateTime> restDateTimeList;
}
