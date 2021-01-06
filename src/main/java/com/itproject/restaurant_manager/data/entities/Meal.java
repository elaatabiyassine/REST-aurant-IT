package com.itproject.restaurant_manager.data.entities;


import javax.persistence.*;

@Entity
@Table(name = "Meal")
public class Meal extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;


    private String name;


    private float price;

    public Meal(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
