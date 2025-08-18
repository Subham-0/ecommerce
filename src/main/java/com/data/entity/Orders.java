package com.data.entity;


import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", shippingAddress=" + shippingAddress.toString() +
                '}';
    }
}
