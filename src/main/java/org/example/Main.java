package org.example;

import com.data.entity.Category;
import com.data.entity.Product;
import com.data.utility.HibernateUtility;
import com.sevices.OrderService;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
//    private static OrderService orderService;

    public static void main(String[] args) {
        System.out.println("Program start...");

//        OrderService orderService = new OrderService();
//        orderService.createOrder();
//        orderService.findOrderById(2);
//        orderService.updateOrderById(1);
//        orderService.updateShippingById(1);
//        orderService.deleteOrderById(2);
        Session session = HibernateUtility.getSession();
        Transaction transaction = session.beginTransaction();
        Product product1 = new Product();
        product1.setName("iphone");
        product1.setPrice(100000);
        product1.setRating(3.6);

        Product product2 = new Product();
        product2.setName("samsung");
        product2.setPrice(123451);
        product2.setRating(4.6);

        Category category1 = new Category();
        category1.setName("Electronics");

        Category category2 = new Category();
        category2.setName("Mobiles");

        //link category to product
        product1.addCategory(category1);
        product1.addCategory(category2);

        product2.addCategory(category1);
        product2.addCategory(category2);

        //link product to category
        category1.addProduct(product1);
        category1.addProduct(product2);

        category2.addProduct(product1);
        category2.addProduct(product2);

        session.persist(product1);
        session.persist(product2);
        session.persist(category1);
        session.persist(category2);
        transaction.commit();
        HibernateUtility.shutdown();
//        orderService.disconnect();

        System.out.println("Program end...");

    }


}