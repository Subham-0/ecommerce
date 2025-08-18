package com.data.repo;

import com.data.entity.Orders;
import com.data.entity.ShippingAddress;
import com.data.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdersRepository {

    public void disConnect() {
        HibernateUtility.shutdown();
    }

    public void createOrder(Orders orders) {
        Session session = HibernateUtility.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(orders);
        transaction.commit();

        session.close();

    }



    public boolean findOrderById(int i) {
        Session session = HibernateUtility.getSession();

        Orders order = session.find(Orders.class, i);
        if (order == null) {
            return false;
        }
        System.out.println(order);
        session.close();
        return true;
    }

    public boolean updateOrderById(int i) {
        Session session = HibernateUtility.getSession();
        Transaction transaction = session.beginTransaction();
        Orders order = session.find(Orders.class, i);
        if (order == null) {
            return false;
        }
        order.setQuantity(12);
        order.setPrice(500);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean updateShippingById(int i) {
        Session session = HibernateUtility.getSession();
        Transaction transaction = session.beginTransaction();
        ShippingAddress shippingAddress = session.find(Orders.class, i).getShippingAddress();
        if (shippingAddress == null) {
            return false;
        }
        shippingAddress.setType("office");
        shippingAddress.setCity("kolkata");
        shippingAddress.setArea("Chabil");
        shippingAddress.setPin_code(342453);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean deleteOrderById(int i) {
        Session session = HibernateUtility.getSession();
        Transaction transaction = session.beginTransaction();
        Orders order = session.find(Orders.class, i);
        if (order == null) {
            return false;
        }
        session.remove(order);
        transaction.commit();
        session.close();
        return true;
    }
}
