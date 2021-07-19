package org.sergeyzhirkov.springhiber.dao;

import org.hibernate.Session;
import org.sergeyzhirkov.springhiber.model.Consumer;
import org.sergeyzhirkov.springhiber.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerDao {
    @Autowired
    public MainService service;

    public void printConsumerInfo(Long id) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Consumer consumer = session.get(Consumer.class, id);
            System.out.println(consumer);
            session.getTransaction().commit();
        }
    }
}
