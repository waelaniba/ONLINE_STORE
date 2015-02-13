package edu.esprit.onlinestore.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import edu.esprit.onlinestore.domain.Product;
import edu.esprit.onlinestore.services.CartServiceRemote;

public class CartTest {

	
	CartServiceRemote cartSRVC;
	
	@Before
	public void setUp() throws Exception {
		
		Context ctx = new InitialContext();
		cartSRVC = (CartServiceRemote) ctx.
				lookup("/OnlineStore/CartService!edu.esprit.onlinestore.services.CartServiceRemote");
	}

	@Test
	public void test() {

		Product p = new Product("sony", 10000F);
		cartSRVC.addToCart(p);
		
	}

}
