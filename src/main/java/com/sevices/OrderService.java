package com.sevices;

import com.data.entity.OrderItems;
import com.data.entity.Orders;
import com.data.entity.ShippingAddress;
import com.data.repo.OrdersRepository;

import java.util.List;

public class OrderService {
    private final OrdersRepository ordersRepository = new OrdersRepository();

    public void createOrder() {
        Orders orders = new Orders();


        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCity("Bhubaneswar");
        shippingAddress.setArea("Jharpada");
        shippingAddress.setPin_code(7650065);
        shippingAddress.setType("Office");

        orders.setShippingAddress(shippingAddress);

        OrderItems orderItems1 = new OrderItems();
        orderItems1.setName("item1");
        orderItems1.setPrice(300);
        OrderItems orderItems2 = new OrderItems();
        orderItems2.setName("item2");
        orderItems2.setPrice(500);
        orders.addOrderItem(orderItems1);
        orders.addOrderItem(orderItems2);

        List<OrderItems> orderItemsList = orders.getOrderItems();
        double totalPrice = 0;
        for (OrderItems orderItems : orderItemsList) {
            totalPrice += orderItems.getPrice();
        }

        orders.setPrice(totalPrice);
        int totalQnt = orders.getOrderItems().size();
        orders.setQuantity(totalQnt);

        ordersRepository.createOrder(orders);

    }

    public void findOrderById(int i) {
        if (!ordersRepository.findOrderById(i)) {
            System.out.println("Please enter a valid order id");
        }
    }

    public void updateOrderById(int i) {
        if (!ordersRepository.updateOrderById(i)) {
            System.out.println("Please enter a valid order id");
        } else {
            System.out.println("order data updated successfully");
        }
    }

    public void updateShippingById(int i) {
        if (!ordersRepository.updateShippingById(i)) {
            System.out.println("Please enter a valid order id");
        } else {
            System.out.println("shipping data updated successfully");
        }
    }

    public void deleteOrderById(int i) {
        if (!ordersRepository.deleteOrderById(i)) {
            System.out.println("Please enter a valid order id");
        } else {
            System.out.println("shipping data updated successfully");
        }
    }

    public void disconnect() {
        ordersRepository.disConnect();
    }


}
