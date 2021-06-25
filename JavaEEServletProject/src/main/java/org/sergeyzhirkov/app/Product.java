package org.sergeyzhirkov.app;

import java.util.Random;

public class Product {
    private int number;
    private int id;
    private String title;
    private int cost;

    public Product(int number) {
        this.number = number;
        this.id = Math.abs(new Random().nextInt());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append((char)(new Random().nextInt(26) + 'A'));
        }
        this.title = stringBuilder.toString();
        this.cost = Math.abs(new Random().nextInt(1000));
    }

    @Override
    public String toString() {
        return "Product #" + number +
                "\n\t id = " + id +
                "\n\t title = " + title  +
                "\n\t cost = " + cost + " $";
    }
}
