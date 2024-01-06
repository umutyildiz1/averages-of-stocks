package com.umutyildiz.averagesofstock.service;

import com.umutyildiz.averagesofstock.entity.Stock;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {

    List<Stock> getStocksByCategoryName(String categoryName);
    void add(Stock stock);
    void addQuantityPrice(String name, BigDecimal price, BigDecimal quantity);
    void reduceQuantity(String name, BigDecimal reducedQuantity);
}
