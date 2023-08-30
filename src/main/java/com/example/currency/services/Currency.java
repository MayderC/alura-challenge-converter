package com.example.currency.services;

import java.util.Collection;

public interface Currency {

 Collection<String> getCountries();

 float getConversion(String from, String to, float quantity);

}
