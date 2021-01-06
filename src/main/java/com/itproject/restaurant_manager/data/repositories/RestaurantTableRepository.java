package com.itproject.restaurant_manager.data.repositories;

import com.itproject.restaurant_manager.data.entities.RestaurantTable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantTableRepository extends BaseRepository {

    @Query("select t from RestaurantTable where t.r.id = ?1 and t.status = true")
      List<RestaurantTable> findFreeTablesbyRestaurantID(Long RestaurantId);

}
