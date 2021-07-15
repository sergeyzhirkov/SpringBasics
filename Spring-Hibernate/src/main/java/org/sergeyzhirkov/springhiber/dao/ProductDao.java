package org.sergeyzhirkov.springhiber.dao;

import org.hibernate.Session;
import org.sergeyzhirkov.springhiber.model.Product;
import org.sergeyzhirkov.springhiber.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

    @Autowired
    private MainService service;

    public void printProductInfo(Long id) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }


}
