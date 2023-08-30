package com.example.currency.services;

import java.util.*;

public class CurrencyImpl implements Currency{

    public CurrencyImpl(){
        this.setExchangesData();
    }

    private final ArrayList<String> countriesISOCurrency = new ArrayList(Arrays.asList("CRC", "EUR", "USD", "GBP", "JPY", "KRW"));
    private Map<String, Double> exchangeRates = new HashMap<>();

    @Override
    public float getConversion(String fromCurrency, String toCurrency, float quantity) {
        if (!exchangeRates.containsKey(fromCurrency) && !exchangeRates.containsKey(toCurrency)) return 0;
        double amountInBase = quantity / exchangeRates.get(fromCurrency);
        return  (float) (amountInBase * exchangeRates.get(toCurrency));
    }
    private void setExchangesData(){
        exchangeRates.put(countriesISOCurrency.get(0), 536.04);
        exchangeRates.put(countriesISOCurrency.get(1), 0.92);
        exchangeRates.put(countriesISOCurrency.get(2), 1.0);
        exchangeRates.put(countriesISOCurrency.get(3), 0.79);
        exchangeRates.put(countriesISOCurrency.get(4), 146.23);
        exchangeRates.put(countriesISOCurrency.get(5), 1323.93);
    }
    @Override
    public Collection<String> getCountries() {
        return countriesISOCurrency;
    }
}
