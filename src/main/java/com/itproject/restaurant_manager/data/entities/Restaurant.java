package com.itproject.restaurant_manager.data.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity

@Table(name = "/Restaurant/")

public class Restaurant extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @OneToOne
    @NotNull
    private Menu menu;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> order;

    @OneToMany(mappedBy = "TableBooking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TableBooking> tableBookings;

    @OneToMany(mappedBy = "Table", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RestaurantTable> restaurantTables;




    private String name;

    private String location;

    private int number_of_tables;

    public Restaurant(Menu menu, String name, String location, int number_of_tables) {
        this.menu = menu;
        this.name = name;
        this.location = location;
        this.number_of_tables = number_of_tables;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<TableBooking> getTableBookings() {
        return tableBookings;
    }

    public void setTableBookings(List<TableBooking> tableBookings) {
        this.tableBookings = tableBookings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber_of_tables() {
        return number_of_tables;
    }

    public void setNumber_of_tables(int number_of_tables) {
        this.number_of_tables = number_of_tables;
    }

}
