package com.umutyildiz.averageofpurchased.dto;

import java.math.BigDecimal;

public class AmountDto {
    private BigDecimal averageAmount;
    private BigDecimal quantity;

    public BigDecimal getAverageAmount() {
        return averageAmount;
    }

    public void setAverageAmount(BigDecimal averageAmount) {
        this.averageAmount = averageAmount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
