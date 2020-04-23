package com.ril.fb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ril.fb.domian.Address;
import com.ril.fb.domian.Customer;
import com.ril.fb.exception.CustomerServiceException;
import com.ril.fb.repository.CustomerRepository;
import com.ril.fb.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		customer = new Customer();
		customer.setFirstName("Shiva");
		customer.setLastName("Srivastava");
		customer.setUsername("anaamay");
		List<Address> addresses = new ArrayList<>();

		Address address = new Address();
		address.setCity("Delhi");
		address.setCountry("Inida");
		address.setCustomer(customer);
		address.setNumber("8750319118");
		address.setPostcode("110096");
		address.setStreet("New Ashok Nagar");

		addresses.add(address);
		customer.setAddresses(addresses);
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(Long customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new CustomerServiceException(customerId));
	}

	@Override
	public void deleteCustomer(Long customerId) {
		customerRepository.deleteById(customerId);

	}

	@Override
	public Customer updateAddress(Long customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new CustomerServiceException(customerId));

	}

}
