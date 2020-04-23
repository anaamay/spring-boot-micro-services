package com.ril.fb.service;

import com.ril.fb.domian.Customer;

public interface CustomerService  {

	Customer addCustomer(Customer customer);

	Customer getCustomer(Long customerId);

	void deleteCustomer(Long customerId);

	Customer updateAddress(Long customerId);

}
