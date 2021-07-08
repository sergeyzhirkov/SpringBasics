package org.sergeyzhirkov.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class MainApp {
    private static SessionFactory factory;

    public static void init() {
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        forcePrepareData();
    }


    public static void main(String[] args) {
        try {
            init();
            ProductDao productDao = new ProductDao(factory);

            productDao.saveOrUpdate(new Product(Long.valueOf(1), "prod1", 100));
            productDao.saveOrUpdate(new Product(Long.valueOf(2), "prod2", 200));

            System.out.println(productDao.findById(Long.valueOf(2)));

            System.out.println(productDao.findAll());

            productDao.deleteById(Long.valueOf(1));

            System.out.println(productDao.findAll());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void forcePrepareData() {
        try (Session session = factory.getCurrentSession()) {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void shutdown() {
        factory.close();
    }
}
