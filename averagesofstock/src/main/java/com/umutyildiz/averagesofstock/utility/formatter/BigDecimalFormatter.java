package com.umutyildiz.averagesofstock.utility.formatter;

import com.umutyildiz.averagesofstock.config.BigDecimalConfig;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class BigDecimalFormatter {

    private final BigDecimalConfig bigDecimalConfig;

    public BigDecimalFormatter(BigDecimalConfig bigDecimalConfig) {
        this.bigDecimalConfig = bigDecimalConfig;
    }

    public BigDecimal formatBigDecimal(BigDecimal number){
        return number.setScale(this.bigDecimalConfig.getPlaceCount(), RoundingMode.HALF_UP);
    }
}
