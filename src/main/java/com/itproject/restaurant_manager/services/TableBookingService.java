package com.itproject.restaurant_manager.services;

import com.itproject.restaurant_manager.data.entities.Restaurant;
import com.itproject.restaurant_manager.data.entities.RestaurantTable;
import com.itproject.restaurant_manager.data.entities.TableBooking;
import com.itproject.restaurant_manager.data.entities.User;
import com.itproject.restaurant_manager.data.repositories.RestaurantRepository;
import com.itproject.restaurant_manager.data.repositories.RestaurantTableRepository;
import com.itproject.restaurant_manager.data.repositories.TableBookingRepository;
import com.itproject.restaurant_manager.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TableBookingService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TableBookingRepository tableBookingRepository;

    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    @Autowired
    UserRepository userRepository;



     public List<RestaurantTable> listAvailableTables (Long restaurantID){

         return restaurantTableRepository.findFreeTablesbyRestaurantID(restaurantID);

     }

    public Optional<RestaurantTable> findTablebyId(Long tableID){
         return restaurantTableRepository.findById(tableID);
     }

     public void makeaTableBooking(RestaurantTable t, User user,Date date, String time){

         List<RestaurantTable> temp = listAvailableTables(t.getR().getId());
         if(temp.contains(findTablebyId(t.getId()))){
             TableBooking tableBooking = new TableBooking(t,user, t.getR(), date, time);

         }
         else{
             System.out.println("ERROR: CAN'T make table booking");
         }

     }

    public void cancelTableBooking(TableBooking booking){

         RestaurantTable temp = booking.getT();
         temp.setStatus(true);

         tableBookingRepository.delete(booking);

         restaurantTableRepository.save(temp);
    }

    public void updateTableBooking(TableBooking booking, Date date, String time){

        TableBooking temp = booking;
        temp.setDate(date);
        temp.setTime(time);

        tableBookingRepository.save(temp);


    }




}
