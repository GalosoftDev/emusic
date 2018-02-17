package com.galosoft.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.galosoft.dao.CartDao;
import com.galosoft.model.Cart;


@Repository
public class CartDaoImpl implements CartDao{
	
	private Map<String, Cart> listOfCarts;
	
	public CartDaoImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Can not create a cart, exists", cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not update a cart, does not exists", cart.getCartId()));
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not remove a cart, does not exists", cartId ));
		}
		listOfCarts.remove(cartId);
	}

}
