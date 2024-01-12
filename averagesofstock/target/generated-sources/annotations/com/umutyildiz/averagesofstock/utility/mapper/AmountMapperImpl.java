package com.umutyildiz.averagesofstock.utility.mapper;

import com.umutyildiz.averagesofstock.entity.Amount;
import com.umutyildiz.averagesofstock.utility.dto.AmountDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T01:31:53+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class AmountMapperImpl implements AmountMapper {

    @Override
    public AmountDto entityToDto(Amount amount) {
        if ( amount == null ) {
            return null;
        }

        AmountDto amountDto = new AmountDto();

        amountDto.setAverageAmount( amount.getAverageAmount() );
        amountDto.setQuantity( amount.getQuantity() );

        return amountDto;
    }

    @Override
    public Amount dtoToEntity(AmountDto amountDto) {
        if ( amountDto == null ) {
            return null;
        }

        Amount amount = new Amount();

        amount.setAverageAmount( amountDto.getAverageAmount() );
        amount.setQuantity( amountDto.getQuantity() );

        return amount;
    }
}
