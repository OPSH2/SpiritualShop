package com.example.demo.Connect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ResourceBundle;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        try
        {
            ResourceBundle rb = ResourceBundle.getBundle("sqlserver");
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.setProperty("hibernate.connection.url", rb.getString("db.url"));
            cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
            cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));
            sessionFactory = cfg.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("SessionFactory initial creation error."+ ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
