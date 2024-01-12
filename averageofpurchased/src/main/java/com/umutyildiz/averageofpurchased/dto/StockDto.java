package com.umutyildiz.averageofpurchased.dto;

import javafx.beans.property.SimpleStringProperty;


public class StockDto {

    private String name;
    private CategoryDto category;
    private AmountDto amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public AmountDto getAmount() {
        return amount;
    }

    public void setAmount(AmountDto amount) {
        this.amount = amount;
    }

    public SimpleStringProperty getNameProperty() {
        return new SimpleStringProperty(name);
    }

    public SimpleStringProperty getQuantityProperty() {
        return new SimpleStringProperty(String.valueOf(amount != null ? amount.getQuantity() : null));
    }

    public SimpleStringProperty getAveragePriceProperty() {
        return new SimpleStringProperty(String.valueOf(amount != null ? amount.getAverageAmount() : null));
    }
}
