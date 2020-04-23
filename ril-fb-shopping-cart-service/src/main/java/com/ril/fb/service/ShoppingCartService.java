package com.ril.fb.service;

import java.util.List;

import com.ril.fb.domain.Cart;
import com.ril.fb.domain.Item;

public interface ShoppingCartService {
	Cart add(List<Item> items);
	void deleteItem(Long itemId);
	void clearCart(Long cartId);
	Cart getCartInfo(Long cartId);
}
