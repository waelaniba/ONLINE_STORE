package edu.esprit.onlinestore.services;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface CurrencyServiceLocal {

	Map<String, Float> getCurrencies();

}
