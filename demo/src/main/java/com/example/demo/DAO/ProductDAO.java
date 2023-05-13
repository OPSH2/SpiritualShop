package com.example.demo.DAO;

import com.example.demo.Connect.HibernateUtil;
import com.example.demo.Entities.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.util.List;

public class ProductDAO {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private List<Product> getProductList(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Product ");
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session!=null)
                session.close();
        }
        return null;
    }

    private Product getProductById(String id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery("FROM Product where id=:eid");
            query.setParameter("eid", id);
            return (Product) query.getSingleResult();
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }
        return null;
    }

    private void addProduct(Product product){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }
    }

    private void updateProduct(Product product){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }
    }

    private void deleteProduct(Product product){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.remove(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }
    }
}
