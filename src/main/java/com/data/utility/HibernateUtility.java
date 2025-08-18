package com.data.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static final String hibernatecfgfile = "hibernate.cfg.xml";

    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    public static Session getSession(){
        //Load configuration
       try{
           Configuration configuration = new Configuration();
           configuration.configure(hibernatecfgfile);

           if(sessionFactory == null) {
               sessionFactory = configuration.buildSessionFactory();
               System.out.println("Session factory created");
           }
           session = sessionFactory.openSession();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
        System.out.println("Session created");
        return session;
    }

    public static void shutdown(){
       if( session.isOpen()){
           session.close();
       }
        sessionFactory.close();

        session = null;
        sessionFactory = null;
        System.out.println("session closed");
        System.out.println("sessionFactory closed");
    }
}
