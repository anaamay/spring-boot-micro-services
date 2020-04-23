package com.ril.fb.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ril.fb.domain.Order;
import com.ril.fb.exception.OrderServiceException;
import com.ril.fb.repository.ItemRepository;
import com.ril.fb.repository.OrderRepository;
import com.ril.fb.service.OrderService;
import com.ril.fb.util.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;	
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Order placeOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderDetails(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(()-> new OrderServiceException(String.format("No order details is found with orderId:[%d]", orderId)));
	}

	@Override
	public Order cancelOrder(Long orderId) {
		Optional<Order> optional =  orderRepository.findById(orderId);
		if(optional.isPresent()) {
			Order order = optional.get();
			order.setOrderStatus(OrderStatus.CANCELLED);
			orderRepository.save(order);
		}else {
			throw new OrderServiceException(String.format("No order details is found with orderId:[%d]", orderId));
		}
		return optional.get();
	}

}
