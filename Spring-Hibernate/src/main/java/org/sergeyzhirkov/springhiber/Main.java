package org.sergeyzhirkov.springhiber;

import org.sergeyzhirkov.springhiber.dao.ConsumerDao;
import org.sergeyzhirkov.springhiber.dao.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        ConsumerDao consumerDao = applicationContext.getBean(ConsumerDao.class);
        consumerDao.printConsumerInfo(Long.valueOf(1));

        ProductDao productDao = applicationContext.getBean(ProductDao.class);
        productDao.printProductInfo(Long.valueOf(2));

        applicationContext.close();
    }
}
