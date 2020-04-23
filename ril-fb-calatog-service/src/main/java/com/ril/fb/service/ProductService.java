package com.ril.fb.service;

import java.util.List;

import javax.validation.Valid;

import com.ril.fb.domain.Product;

public interface ProductService {

	Product addProduct(Product product);

	Product searchProduct(String productname);

	void deleteProduct(Long productId);

	List<Product> saveAllProducts(@Valid List<Product> products);

}
