package com.ril.fb.service;

import com.ril.fb.domain.Order;

public interface OrderService {

	Order placeOrder(Order order);

	Order getOrderDetails(Long orderId);

	Order cancelOrder(Long orderId);

}
