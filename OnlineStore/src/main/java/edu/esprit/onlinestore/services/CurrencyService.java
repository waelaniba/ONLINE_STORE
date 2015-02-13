package edu.esprit.onlinestore.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class CurrencyService
 */
@Singleton
public class CurrencyService implements CurrencyServiceLocal {

    public CurrencyService() {
        // TODO Auto-generated constructor stub
    }
    
    private Map<String, Float> currencies = new HashMap<>();
    
    @PostConstruct
    public void init(){
    	
    	currencies.put("EU", 0.43F);
    	currencies.put("USD", 0.52F);
    	currencies.put("TND", 1F);
    }

    @Override
	public Map<String, Float> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, Float> currencies) {
		this.currencies = currencies;
	}

}
