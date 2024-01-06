package com.umutyildiz.averagesofstock.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BigDecimalConfig {

    @Value("${big.decimal.place.count}")
    private Integer placeCount;

    public Integer getPlaceCount() {
        return placeCount;
    }
}
