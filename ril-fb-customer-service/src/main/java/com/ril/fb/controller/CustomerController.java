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

import com.ril.fb.domian.Customer;
import com.ril.fb.service.CustomerService;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping("/getcustomer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Long customerId) {
		return ResponseEntity.ok(customerService.getCustomer(customerId));
	}

	@GetMapping("/delete/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/updateaddress/{customerId}")
	public ResponseEntity<Customer> updateAddress(@PathVariable("customerId") Long customerId) {
		return ResponseEntity.ok(customerService.updateAddress(customerId));
	}

}
