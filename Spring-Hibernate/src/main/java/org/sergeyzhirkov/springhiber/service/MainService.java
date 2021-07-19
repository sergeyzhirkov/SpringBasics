package org.sergeyzhirkov.springhiber.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Component
public class MainService {
    private SessionFactory factory;

    @PostConstruct
    public void init() {

        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        forcePrepareData();
    }


    public void forcePrepareData() {
        try (Session session = factory.getCurrentSession()) {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }
}
