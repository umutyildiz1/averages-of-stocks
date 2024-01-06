package com.umutyildiz.averagesofstock.utility.mapper;

import com.umutyildiz.averagesofstock.entity.Amount;
import com.umutyildiz.averagesofstock.entity.Stock;
import com.umutyildiz.averagesofstock.utility.dto.AmountDto;
import com.umutyildiz.averagesofstock.utility.dto.StockDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {

    StockMapper mapper = Mappers.getMapper(StockMapper.class);

    @Mapping(target = "name", source = "stock.name")
    @Mapping(target = "category", source = "stock.category")
    @Mapping(target = "amount", source = "stock.amount")
    StockDto entityToDto(Stock stock);

    @Mapping(target = "name", source = "stockDto.name")
    @Mapping(target = "category", source = "stockDto.category")
    @Mapping(target = "amount", source = "stockDto.amount")
    Stock dtoToEntity(StockDto stockDto);
}
