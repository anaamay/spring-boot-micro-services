package com.ril.fb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ril.fb.domain.Cart;
import com.ril.fb.domain.Item;
import com.ril.fb.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping("/additems")
	public ResponseEntity<Cart> addItems(@RequestBody List<Item> items) {
		return new ResponseEntity<>(shoppingCartService.add(items), HttpStatus.CREATED);
	}

	@GetMapping("/cardinfo/{cartId}")
	public ResponseEntity<Cart> getCartInfo(@PathVariable("cartId") Long cartId) {
		return ResponseEntity.ok(shoppingCartService.getCartInfo(cartId));
	}

	@GetMapping("/deleteitem/{itemId}")
	public ResponseEntity<Void> deleteItem(@PathVariable("itemId") Long itemId) {
		shoppingCartService.deleteItem(itemId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/clearcart/{cartId}")
	public ResponseEntity<Void> clearCart(@PathVariable("cartId") Long cartId) {
		shoppingCartService.clearCart(cartId);
		return ResponseEntity.noContent().build();
	}

}
