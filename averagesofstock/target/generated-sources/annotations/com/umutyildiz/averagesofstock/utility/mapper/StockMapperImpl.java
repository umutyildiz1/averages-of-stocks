package com.umutyildiz.averagesofstock.utility.mapper;

import com.umutyildiz.averagesofstock.entity.Amount;
import com.umutyildiz.averagesofstock.entity.Category;
import com.umutyildiz.averagesofstock.entity.Stock;
import com.umutyildiz.averagesofstock.utility.dto.AmountDto;
import com.umutyildiz.averagesofstock.utility.dto.CategoryDto;
import com.umutyildiz.averagesofstock.utility.dto.StockDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T01:31:53+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class StockMapperImpl implements StockMapper {

    @Override
    public StockDto entityToDto(Stock stock) {
        if ( stock == null ) {
            return null;
        }

        StockDto stockDto = new StockDto();

        stockDto.setName( stock.getName() );
        stockDto.setCategory( categoryToCategoryDto( stock.getCategory() ) );
        stockDto.setAmount( amountToAmountDto( stock.getAmount() ) );

        return stockDto;
    }

    @Override
    public Stock dtoToEntity(StockDto stockDto) {
        if ( stockDto == null ) {
            return null;
        }

        Stock stock = new Stock();

        stock.setName( stockDto.getName() );
        stock.setCategory( categoryDtoToCategory( stockDto.getCategory() ) );
        stock.setAmount( amountDtoToAmount( stockDto.getAmount() ) );

        return stock;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setName( category.getName() );

        return categoryDto;
    }

    protected AmountDto amountToAmountDto(Amount amount) {
        if ( amount == null ) {
            return null;
        }

        AmountDto amountDto = new AmountDto();

        amountDto.setAverageAmount( amount.getAverageAmount() );
        amountDto.setQuantity( amount.getQuantity() );

        return amountDto;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( categoryDto.getName() );

        return category;
    }

    protected Amount amountDtoToAmount(AmountDto amountDto) {
        if ( amountDto == null ) {
            return null;
        }

        Amount amount = new Amount();

        amount.setAverageAmount( amountDto.getAverageAmount() );
        amount.setQuantity( amountDto.getQuantity() );

        return amount;
    }
}
