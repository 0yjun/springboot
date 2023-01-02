package com.camss.helloJpa.domain;

import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderitems = new ArrayList<>();

    public void setOrderItem(OrderItem orderItem){
        orderitems.add(orderItem);
        orderItem.setOrder(this);
    }
}
