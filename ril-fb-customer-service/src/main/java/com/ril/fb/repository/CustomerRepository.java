package com.ril.fb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ril.fb.domian.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
