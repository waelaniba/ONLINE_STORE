package edu.esprit.onlinestore.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import edu.esprit.onlinestore.domain.Product;

/**
 * Session Bean implementation class CartService
 */
@Stateful
public class CartService implements CartServiceRemote {

	private List<Product> cart;
	
	@EJB CurrencyServiceLocal currencyService;
	
    public CartService() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void init(){
    	
    	System.out.println("Cart " + hashCode() + " Service Initiated");
    	cart = new ArrayList<Product>();
    	
    }

	@Override
	public void addToCart(Product product) {
		
		cart.add(product);
		System.out.println("Product [" + product.getDesignation() + "] added to Cart" + hashCode());
		
	}

	@Override
	public void cleanCart() {

		cart.clear();
		System.out.println("Cart " + hashCode() + " content cleared.");
	}

	@Override
	@Remove
	public void validateCart() {
		
		Float total = 0F;
		
		System.out.println("You've purshased :");
		for (Product product : cart) {
			
			System.out.println("- " + product.getDesignation());
			total += product.getPrice();
		}
		
		System.out.println("Total cart " + hashCode() + " = " + total);
		
	}
	
	@Override
	public void validateCartWithForeignCurrency(String currency){
		
		Float rate = currencyService.getCurrencies().get(currency);
		Float total = 0F;
		
		System.out.println("You've purshased :");
		for (Product product : cart) {
			
			System.out.println("- " + product.getDesignation());
			total += product.getPrice();
		}
		
		System.out.println("Total cart " + hashCode() + " = " + total * rate);
		
		
	}
	
	@PreDestroy
	public void tearDown(){
		
		System.out.println("Releasing instanse for cart " + hashCode());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
