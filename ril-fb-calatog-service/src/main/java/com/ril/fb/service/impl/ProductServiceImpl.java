package com.ril.fb.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ril.fb.domain.Product;
import com.ril.fb.exception.ProductNotFoundException;
import com.ril.fb.repository.ProductRepository;
import com.ril.fb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product searchProduct(String productname) {
		return productRepository.findByName(productname).orElseThrow(() -> new ProductNotFoundException(productname));
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<Product> saveAllProducts(@Valid List<Product> products) {
		return productRepository.saveAll(products);
	}

}
