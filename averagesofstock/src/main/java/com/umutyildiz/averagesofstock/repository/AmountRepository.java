package com.umutyildiz.averagesofstock.repository;

import com.umutyildiz.averagesofstock.entity.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountRepository extends JpaRepository<Amount,Integer> {
}
