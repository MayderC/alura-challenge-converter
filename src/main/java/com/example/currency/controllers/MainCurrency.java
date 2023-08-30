package com.example.currency.controllers;

import com.example.currency.services.Currency;
import com.example.currency.services.CurrencyImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainCurrency {
    @FXML
    private Label welcomeText;
    public ComboBox<String> fromCurrency;
    public ComboBox<String> toCurrency;
    public TextField fromCountryText;
    private ObservableList<String> fromCountryList = FXCollections.observableArrayList();
    private ObservableList<String> toCountryList = FXCollections.observableArrayList();
    private Currency _currencyService;


    @FXML
    private void onInputFrom(){
        this.validInput(this.fromCountryText);
    }
    private void validInput(TextField input){
        String newValue = input.getText();
        if (!newValue.matches("\\d*")) {
            input.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
    @FXML
    protected void onConverterClick(){
        float result = _currencyService.getConversion(this.fromCurrency.getValue(), this.toCurrency.getValue(), Float.parseFloat(this.fromCountryText.getText()));
        welcomeText.setText(Float.toString(result));
    }
    private void setCountriesInComboBoxes(){
        this.fromCountryList.addAll(this._currencyService.getCountries());
        fromCurrency.setItems(this.fromCountryList);

        this.toCountryList.addAll(this._currencyService.getCountries());
        toCurrency.setItems(this.toCountryList);
    }
    @FXML
    protected void initialize(){
        _currencyService = new CurrencyImpl();
        this.setCountriesInComboBoxes();
    }
}