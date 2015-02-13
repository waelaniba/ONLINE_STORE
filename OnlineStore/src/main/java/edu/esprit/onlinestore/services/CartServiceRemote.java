package edu.esprit.onlinestore.services;

import javax.ejb.Remote;

import edu.esprit.onlinestore.domain.Product;

@Remote
public interface CartServiceRemote {
	
	void addToCart(Product product);
	void cleanCart();
	void validateCart();
	void validateCartWithForeignCurrency(String currency);

}
