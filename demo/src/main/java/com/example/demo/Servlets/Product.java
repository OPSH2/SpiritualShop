package com.example.demo.Servlets;

import jakarta.persistence.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Product", value = "/Product")
public class Product extends HttpServlet {
    private static final String persistenceUnitName = "product";
    private EntityManagerFactory factory;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Product p where p.id like "+id);
        com.example.demo.Entities.Product prod = (com.example.demo.Entities.Product) query.getSingleResult();
        request.setAttribute("result", prod);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        com.example.demo.Entities.Product prd = new com.example.demo.Entities.Product();
        prd.setId(request.getParameter("id"));
        prd.setName(request.getParameter("name"));
        prd.setImportPrice(Float.parseFloat(request.getParameter("importPrice")));
        prd.setSellingPrice(Float.parseFloat(request.getParameter("sellingPrice")));
        prd.setNumberInStock(Integer.parseInt(request.getParameter("numberInStock")));
        String action = request.getParameter("action");
        initPers();
        if(action.equals("add"))
            pushProductToDB(prd);
        else if (action.equals("delete"))
            deleteProductByID(prd.getId());
        else if (action.equals("update"))
            updateProduct(prd);

    }

    private void initPers(){
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }
    private void pushProductToDB(com.example.demo.Entities.Product prd){
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(prd);
        em.getTransaction().commit();
        em.close();
    }
    private void deleteProductByID(String id){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select p from Product p where id like "+id+"%");
        com.example.demo.Entities.Product prd = (com.example.demo.Entities.Product) q.getSingleResult();
        em.remove(prd);
        em.getTransaction().commit();
        em.close();
    }
    private void updateProduct(com.example.demo.Entities.Product prd){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select p from Product p where p.id ="+prd.getId());
        com.example.demo.Entities.Product temp =(com.example.demo.Entities.Product) q.getSingleResult();
        em.remove(temp);
        em.persist(prd);
        em.getTransaction().commit();
        em.close();
    }
}
