package com.itproject.restaurant_manager.controllers;

import com.itproject.restaurant_manager.data.entities.RestaurantTable;
import com.itproject.restaurant_manager.data.entities.TableBooking;
import com.itproject.restaurant_manager.data.entities.User;
import com.itproject.restaurant_manager.services.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TableBookingController {
    @Autowired
    private TableBookingService tableBookingService;

    @RequestMapping("/AvailableTables")
    public List<RestaurantTable> getAllavaliableTables(@RequestParam Long restaurantID, @RequestParam String time){
        return tableBookingService.listAvailableTables(restaurantID);
    }

    @RequestMapping(method = RequestMethod.POST, value="/MakeAbooking")
    public void makeAbooking(@RequestParam RestaurantTable t, @RequestParam User user, @RequestParam Date date, @RequestParam String time){
        tableBookingService.makeaTableBooking(t,user,date,time);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/CancelBooking")
    public void cancelBooking(@RequestParam TableBooking booking){
        tableBookingService.cancelTableBooking(booking);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/CancelBooking")
    public void updateBooking(@RequestParam TableBooking booking, @RequestParam Date date, @RequestParam String time){
        tableBookingService.updateTableBooking(booking,date, time);
    }
}
