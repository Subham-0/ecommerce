package com.data.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;
    @Column(name = "qty")
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_add_id", referencedColumnName = "ship_id")
    private ShippingAddress shippingAddress;

    @OneToMany(mappedBy = "orders" , cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItems> list_orderItems = new ArrayList<>();

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public long getId() {
        return id;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<OrderItems> getOrderItems() {
        return list_orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.list_orderItems = orderItems;
    }

    public void addOrderItem(OrderItems orderItems){
        list_orderItems.add(orderItems);
        orderItems.setOrders(this);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", shippingAddress=" + shippingAddress.toString()+
                ", orderItems=" + list_orderItems.toString() +
                '}';
    }
}
