package com.itproject.restaurant_manager.data.repositories;

import com.itproject.restaurant_manager.data.entities.Menu;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends BaseRepository {

    @Query("select m from Menu p where m.r.id = ?1")
    Menu findByRestaurantId(Long restaurantID);
    Void addByRestaurantId(Long restaurantID);

}
