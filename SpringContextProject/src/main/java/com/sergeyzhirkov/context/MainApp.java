package com.sergeyzhirkov.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart1 = applicationContext.getBean(Cart.class);
        Cart cart2 = applicationContext.getBean(Cart.class);

        System.out.println(cart1);
        System.out.println(cart2);

        cart1.addProductById(1);
        cart1.addProductById(4);

        cart2.addProductById(3);
        cart2.addProductById(5);

        System.out.println(cart1);
        System.out.println(cart2);

        cart1.removeProductById(1);
        cart1.removeProductById(2);
        cart2.removeProductById(3);
        cart2.addProductById(100500);

        System.out.println(cart1);
        System.out.println(cart2);

        applicationContext.close();
    }
}
