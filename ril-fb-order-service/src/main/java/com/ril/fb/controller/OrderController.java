package com.ril.fb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ril.fb.domain.Order;
import com.ril.fb.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/placeorder")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		return new ResponseEntity<>(orderService.placeOrder(order), HttpStatus.CREATED);
	}

	@PutMapping("/updateorder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		return ResponseEntity.ok(orderService.placeOrder(order));
	}

	@GetMapping("/orderdetails/{orderId}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable("orderId") Long orderId) {
		return ResponseEntity.ok(orderService.getOrderDetails(orderId));
	}

	
	@GetMapping("/cancelorder/{orderId}")
	public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId) {
		return ResponseEntity.ok(orderService.cancelOrder(orderId));
	}
}
