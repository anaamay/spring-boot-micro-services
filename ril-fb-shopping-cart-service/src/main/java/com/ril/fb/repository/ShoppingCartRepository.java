package com.ril.fb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ril.fb.domain.Cart;

public interface ShoppingCartRepository extends JpaRepository<Cart, Long> {

}
