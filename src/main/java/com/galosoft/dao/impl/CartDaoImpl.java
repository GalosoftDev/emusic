package com.galosoft.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			 throw new IllegalArgumentException(String.format("Can not create cart"
	                    + "Cart with specified id (%) already exists.",cart.getCartId()));
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
			throw new IllegalArgumentException(String.format("Can not update cart"
                    + "Cart with specified id (%) already exists.",cart.getCartId()));
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not update cart"
                    + "Cart with specified id (%) already exists.",cartId));
		}
		listOfCarts.remove(cartId);
	}

}
