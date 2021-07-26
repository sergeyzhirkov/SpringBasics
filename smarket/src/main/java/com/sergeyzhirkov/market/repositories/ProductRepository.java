package com.sergeyzhirkov.market.repositories;

import com.sergeyzhirkov.market.dto.ProductDto;
import com.sergeyzhirkov.market.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findAllByPriceGreaterThanEqual(int minPrice);
//    List<Product> findAllByIdLessThanEqual(Long maxId);
//    List<Product> findAllByIdBetweenAndPriceGreaterThan(Long minId, Long maxId, int minPrice);
}