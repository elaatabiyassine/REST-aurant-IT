package com.itproject.restaurant_manager.data.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity


public class OrderLine extends BaseEntity{

    @ManyToOne
    private Meal meal;

    private int quantity;
    private float unitPrice;
    private float price;



    @ManyToOne
    private Order order;


    public OrderLine(Meal meal, int quantity, Order order) {
        this.meal = meal;
        this.quantity = quantity;
        this.order = order;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
