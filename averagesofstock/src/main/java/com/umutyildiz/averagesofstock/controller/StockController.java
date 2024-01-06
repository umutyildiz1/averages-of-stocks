package com.umutyildiz.averagesofstock.controller;

import com.umutyildiz.averagesofstock.entity.Category;
import com.umutyildiz.averagesofstock.entity.Stock;
import com.umutyildiz.averagesofstock.service.StockService;
import com.umutyildiz.averagesofstock.utility.dto.CategoryDto;
import com.umutyildiz.averagesofstock.utility.dto.StockDto;
import com.umutyildiz.averagesofstock.utility.mapper.CategoryMapper;
import com.umutyildiz.averagesofstock.utility.mapper.StockMapper;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/stock/")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("{categoryName}")
    public List<StockDto> getStocksByCategoryName(@PathVariable String categoryName) {
        List<Stock> stocks = stockService.getStocksByCategoryName(categoryName);
        List<StockDto> stockDtos = new ArrayList<>();

        if (stocks.isEmpty())
            return null;

        for (Stock stock : stocks) {
            System.out.println(stock);
            stockDtos.add(mapToDto(stock));
        }
        return stockDtos;
    }

    @PostMapping("")
    public void addStock(@RequestBody StockDto stockDto) {
        Stock stock = mapToEntity(stockDto);
        stockService.add(stock);
    }

    @PostMapping("quantity-price")
    public void addQuantityPrice(@RequestParam String name,
                                 @RequestParam BigDecimal price,
                                 @RequestParam BigDecimal quantity) {
        stockService.addQuantityPrice(name, price, quantity);
    }

    @PutMapping("quantity-price")
    public void reduceQuantity(@RequestParam String name,
                                    @RequestParam BigDecimal quantity) {
        stockService.reduceQuantity(name, quantity);
    }


    private StockDto mapToDto(Stock stock) {
        return StockMapper.mapper.entityToDto(stock);
    }

    private Stock mapToEntity(StockDto stockDto) {
        return StockMapper.mapper.dtoToEntity(stockDto);
    }
}
