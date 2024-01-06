package com.umutyildiz.averagesofstock.repository;

import com.umutyildiz.averagesofstock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query(value = "SELECT s FROM Stock s WHERE s.category.name= :categoryName")
    List<Stock> getStocksByCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "SELECT s FROM Stock s WHERE s.name= :name")
    Stock getStock(@Param("name") String name);
}
