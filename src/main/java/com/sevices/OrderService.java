package com.sevices;

import com.data.entity.Orders;
import com.data.entity.ShippingAddress;
import com.data.repo.OrdersRepository;

public class OrderService {
    private final OrdersRepository ordersRepository = new OrdersRepository();

    public void createOrder() {
        Orders orders = new Orders();
        orders.setPrice(100);
        orders.setQuantity(5);

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCity("Bhubaneswar");
        shippingAddress.setArea("Jharpada");
        shippingAddress.setPin_code(7650065);
        shippingAddress.setType("Office");

        orders.setShippingAddress(shippingAddress);

        ordersRepository.createOrder(orders);

    }
    public void findOrderById(int i) {
        if(!ordersRepository.findOrderById(i)){
            System.out.println("Please enter a valid order id");
        }
    }

    public void updateOrderById(int i) {
        if(!ordersRepository.updateOrderById(i)){
            System.out.println("Please enter a valid order id");
        }else{
            System.out.println("order data updated successfully");
        }
    }
    public void updateShippingById(int i) {
        if(!ordersRepository.updateShippingById(i)){
            System.out.println("Please enter a valid order id");
        }else{
            System.out.println("shipping data updated successfully");
        }
    }

    public void deleteOrderById(int i) {
        if(!ordersRepository.deleteOrderById(i)){
            System.out.println("Please enter a valid order id");
        }else{
            System.out.println("shipping data updated successfully");
        }
    }
    public void disconnect() {
        ordersRepository.disConnect();
    }


}
