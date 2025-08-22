package com.sevices;

import com.data.entity.Product;
import com.data.utility.HibernateUtility;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService {
    public void findByProductName(String name){
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        /* Nomal HQL query */
//        String findproductbynameHQL = "FROM Product p where p.name = :name";
//        Query<Product> productQuery = session.createQuery(findproductbynameHQL, Product.class);

        /*using @findProductByName in entity class*/
        Query<Product> productQuery = session.createNamedQuery("findProductByName", Product.class);

        productQuery.setParameter("name" , name);
        List<Product> productList = productQuery.getResultList();
        productList.forEach(product -> {
            System.out.println(product);
        });
        tx.commit();
        HibernateUtility.shutdown();
    }
    public void findByProductPrice(double price){
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

//        String findproductbynameHQL = "FROM Product p where p.price > :price";
//        Query<Product> productQuery = session.createQuery(findproductbynameHQL, Product.class);

        Query<Product> productQuery = session.createNamedQuery("findProductByPrice", Product.class);
        productQuery.setParameter("price" , price);
        List<Product> productList = productQuery.getResultList();
        productList.forEach(product -> {
            System.out.println(product);
        });
        tx.commit();
        HibernateUtility.shutdown();
    }

    /*using CriteriaBuilder*/
    public void findByName(String name){
        Session session = HibernateUtility.getSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> productCQ = cb.createQuery(Product.class);

        Root<Product> productRoot = productCQ.from(Product.class);
        productCQ.select(productRoot)
                .where(cb.equal(productRoot.get("name"),name));

        List<Product> results = session.createQuery(productCQ).getResultList();
        for(Product p : results){
            System.out.println(p);
        }
        transaction.commit();
        HibernateUtility.shutdown();

    }
}
