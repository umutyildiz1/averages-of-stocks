package com.umutyildiz.averagesofstock.service.impl;

import com.umutyildiz.averagesofstock.entity.Amount;
import com.umutyildiz.averagesofstock.repository.AmountRepository;
import com.umutyildiz.averagesofstock.service.AmountService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AmountServiceImpl implements AmountService {

    private final AmountRepository amountRepository;

    public AmountServiceImpl(AmountRepository amountRepository) {
        this.amountRepository = amountRepository;
    }

    @Override
    public void add(Amount amount) {
        amountRepository.save(amount);
    }
}
