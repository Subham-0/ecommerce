package org.example;

import com.sevices.OrderService;

public class Main {
    private static OrderService orderService;

    public static void main(String[] args) {
        System.out.println("Program start...");

        OrderService orderService = new OrderService();
        orderService.createOrder();
        orderService.findOrderById(2);
        orderService.updateOrderById(1);
        orderService.updateShippingById(1);
        orderService.deleteOrderById(2);
        orderService.disconnect();

        System.out.println("Program end...");

    }


}