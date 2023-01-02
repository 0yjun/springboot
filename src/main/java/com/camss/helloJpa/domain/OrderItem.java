package com.camss.helloJpa.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    private int orderPrice;

}