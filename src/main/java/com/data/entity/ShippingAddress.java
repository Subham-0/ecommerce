package com.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ship_address")
public class ShippingAddress {
    @Id
    @Column(name = "ship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shippingId;
    private String type;
    private String area;
    private String city;
    private int pin_code;

    @OneToOne(mappedBy = "shippingAddress" , fetch = FetchType.LAZY)
    private  Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public long getShippingId() {
        return shippingId;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPin_code() {
        return pin_code;
    }

    public void setPin_code(int pin_code) {
        this.pin_code = pin_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "shippingId=" + shippingId +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", pin_code=" + pin_code +
                '}';
    }
}
