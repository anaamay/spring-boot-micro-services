package com.ril.fb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ril.fb.domain.Product;
import com.ril.fb.service.ProductService;

@RestController
@RequestMapping("/catalog/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
	}

	public ResponseEntity<List<Product>> createEmployee(@Valid @RequestBody List<Product> products) {
		return new ResponseEntity<List<Product>>(productService.saveAllProducts(products), HttpStatus.CREATED);
	}

	@PutMapping("/updateproduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.addProduct(product));
	}

	@GetMapping("/getproduct/{productname}")
	public ResponseEntity<Product> getProduct(@PathVariable("productname") String productname) {
		return ResponseEntity.ok(productService.searchProduct(productname));
	}

	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.noContent().build();
	}

}
