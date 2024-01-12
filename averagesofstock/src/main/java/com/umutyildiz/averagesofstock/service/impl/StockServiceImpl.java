package com.umutyildiz.averagesofstock.service.impl;

import com.umutyildiz.averagesofstock.entity.Amount;
import com.umutyildiz.averagesofstock.entity.Stock;
import com.umutyildiz.averagesofstock.repository.StockRepository;
import com.umutyildiz.averagesofstock.service.AmountService;
import com.umutyildiz.averagesofstock.service.CategoryService;
import com.umutyildiz.averagesofstock.service.StockService;
import com.umutyildiz.averagesofstock.utility.formatter.BigDecimalFormatter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final AmountService amountService;
    private final CategoryService categoryService;

    private final BigDecimalFormatter bigDecimalFormatter;

    public StockServiceImpl(StockRepository stockRepository,
                            AmountService amountService,
                            CategoryService categoryService,
                            BigDecimalFormatter bigDecimalFormatter) {
        this.stockRepository = stockRepository;
        this.amountService = amountService;
        this.categoryService = categoryService;
        this.bigDecimalFormatter = bigDecimalFormatter;
    }

    public List<Stock> getStocksByCategoryName(String categoryName) {
        return stockRepository.getStocksByCategoryName(categoryName);
    }

    @Override
    public void add(Stock stock) {
        Amount tempAmount = new Amount();
        tempAmount.setStock(stock);
        tempAmount.setQuantity(BigDecimal.ZERO);
        tempAmount.setAverageAmount(BigDecimal.ZERO);

        stock.setCategory(categoryService.getCategoryByName(stock.getCategory().getName()));
        stock.setAmount(null);

        stockRepository.save(stock);
        amountService.add(tempAmount);
    }

    @Override
    public void addQuantityPrice(String name, BigDecimal price, BigDecimal quantity) {
        Stock stock = stockRepository.getStock(name);
        Amount newAmount = new Amount();
        Amount oldAmount = stock.getAmount();

        BigDecimal addedTotalPrice = price.multiply(quantity);
        BigDecimal oldTotalPrice = oldAmount.getAverageAmount().multiply(oldAmount.getQuantity());
        BigDecimal newTotalPrice = addedTotalPrice.add(oldTotalPrice);
        BigDecimal newTotalQuantity = oldAmount.getQuantity().add(quantity);
        BigDecimal newAverageAmount = newTotalPrice.divide(newTotalQuantity, RoundingMode.HALF_UP);

        newAmount.setId(oldAmount.getId());
        newAmount.setStock(stock);
        newAmount.setAverageAmount(newAverageAmount);
        newAmount.setQuantity(newTotalQuantity);

        amountService.add(newAmount);

    }

    public void reduceQuantity(String name, BigDecimal reducedQuantity) {
        Amount amount = stockRepository.getStock(name).getAmount();
        BigDecimal quantity = amount.getQuantity();

        if(Arrays.asList(0,1).contains(quantity.subtract(reducedQuantity).compareTo(BigDecimal.ZERO))){
            BigDecimal lastQuantity = quantity.subtract(reducedQuantity);
            if (lastQuantity.compareTo(BigDecimal.ZERO) == 0)
                amount.setAverageAmount(BigDecimal.ZERO);
            amount.setQuantity(lastQuantity);
            amountService.add(amount);
        }
    }

    private BigDecimal formatBigDecimal(BigDecimal number) {
        return bigDecimalFormatter.formatBigDecimal(number);
    }

    private List<Stock> formatBigDecimals(List<Stock> stocks) {
        for (Stock stock : stocks) {
            stock.getAmount().setAverageAmount(formatBigDecimal(stock.getAmount().getAverageAmount()));
            stock.getAmount().setQuantity(formatBigDecimal(stock.getAmount().getQuantity()));
        }
        return stocks;
    }

}
