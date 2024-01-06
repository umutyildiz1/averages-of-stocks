package com.umutyildiz.averagesofstock.utility.mapper;

import com.umutyildiz.averagesofstock.entity.Amount;
import com.umutyildiz.averagesofstock.entity.Category;
import com.umutyildiz.averagesofstock.utility.dto.AmountDto;
import com.umutyildiz.averagesofstock.utility.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AmountMapper {

    AmountMapper mapper = Mappers.getMapper(AmountMapper.class);

    @Mapping(target = "averageAmount", source = "amount.averageAmount")
    @Mapping(target = "quantity", source = "amount.quantity")
    AmountDto entityToDto(Amount amount);

    @Mapping(target = "averageAmount", source = "amountDto.averageAmount")
    @Mapping(target = "quantity", source = "amountDto.quantity")
    Amount dtoToEntity(AmountDto amountDto);
}
