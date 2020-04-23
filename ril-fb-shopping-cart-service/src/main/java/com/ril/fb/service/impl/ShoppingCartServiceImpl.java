package com.ril.fb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ril.fb.domain.Cart;
import com.ril.fb.domain.Item;
import com.ril.fb.exception.ShoppingcartException;
import com.ril.fb.repository.ItemRepository;
import com.ril.fb.repository.ShoppingCartRepository;
import com.ril.fb.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Autowired
	private ItemRepository itemRepository;

	private volatile int counter;

	@Override
	public Cart add(List<Item> items) {
		Cart cart = new Cart();
		Item item1 = new Item();
		item1.setItemId("123-223-11");
		item1.setQuantity(5);
		item1.setUnitPrice(10.5f);
		items.add(item1);
		cart.setItems(items);

		return shoppingCartRepository.save(cart);
	}

	@Override
	public void deleteItem(Long itemId) {
		Optional<Item> item = itemRepository.findById(itemId);
		if (item.isPresent()) {
			itemRepository.delete(item.get());
		} else {
			throw new ShoppingcartException(itemId);
		}
	}

	@Override
	public void clearCart(Long cartId) {
		Optional<Cart> optional = shoppingCartRepository.findById(cartId);
		if (optional.isEmpty()) {
			List<Item> itemList = optional.get().getItems();
			if (!CollectionUtils.isEmpty(itemList)) {
				itemList.clear();
			} else {
				throw new ShoppingcartException("There is not items in cart to remove.");
			}
		}
	}

	@Override
	public Cart getCartInfo(Long cartId) {
		return shoppingCartRepository.findById(cartId).orElseThrow(() -> new ShoppingcartException(cartId));
	}

}
