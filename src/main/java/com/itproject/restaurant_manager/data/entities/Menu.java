package com.itproject.restaurant_manager.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "/Menu/")

public class Menu extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;


    @OneToOne
    private Restaurant r;


   @OneToMany(mappedBy = "Menu" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Meal>  meals;

    public Menu(Restaurant r, List<Meal> meals) {
        this.r = r;
        this.meals = meals;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Restaurant getR() {
        return r;
    }

    public void setR(Restaurant r) {
        this.r = r;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
