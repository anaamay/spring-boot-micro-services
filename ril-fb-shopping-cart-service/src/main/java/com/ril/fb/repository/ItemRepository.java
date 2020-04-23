package com.ril.fb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ril.fb.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
