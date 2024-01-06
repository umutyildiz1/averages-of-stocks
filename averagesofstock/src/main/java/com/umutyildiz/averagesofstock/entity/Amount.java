package com.umutyildiz.averagesofstock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "amount")
public class Amount {

    @Id
    private Integer id;

    @Column(name = "average_amount",columnDefinition = "numeric(32,8)")
    private BigDecimal averageAmount;

    @Column(name = "quantity",columnDefinition = "numeric(32,8)")
    private BigDecimal quantity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Stock stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
