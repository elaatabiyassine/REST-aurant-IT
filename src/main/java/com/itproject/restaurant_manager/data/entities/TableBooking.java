package com.itproject.restaurant_manager.data.entities;


import javax.persistence.*;
import java.util.Date;


@Entity

@Table(name = "/TableBookings/")
public class TableBooking extends BaseEntity{

    @OneToOne
    private RestaurantTable t;

    @OneToOne
    protected User user;


    @OneToOne
    Restaurant restaurant;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;


    private Date date;

    private String time;

    public TableBooking(RestaurantTable t, User user, Restaurant restaurant, Date date, String time) {
        this.t = t;
        this.user = user;
        this.restaurant = restaurant;
        this.date = date;
        this.time = time;
    }





    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public RestaurantTable getT() {
        return t;
    }

    public void setT(RestaurantTable t) {
        this.t = t;
    }
}
