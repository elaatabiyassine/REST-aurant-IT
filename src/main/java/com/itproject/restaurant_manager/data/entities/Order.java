package com.itproject.restaurant_manager.data.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "/Order/")
public class Order extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @ManyToOne
    protected Restaurant r;




    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<OrderLine> orderLines;



    protected float total_price;

    public Order(List<OrderLine> orderLines) {
        this.orderLines = orderLines;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }
}
