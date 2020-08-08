package com.udemy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    private Integer orderStatus;

    public Set<OrderItem> getItems() {
        return items;
    }

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }
    public double getTotal(){
        double sum = 0.0;
        for(OrderItem orderItem: items){
            sum +=orderItem.getSubTotal();
        }
        return sum;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus!=null){
            this.orderStatus = orderStatus.getCode();
        }

    }




    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Order (){

    }
    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }
}
