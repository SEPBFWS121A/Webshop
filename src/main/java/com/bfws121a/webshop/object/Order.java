package com.bfws121a.webshop.object;

import java.util.List;

public class Order {

    Integer orderID;
    String address;
    String name;
    String creditCardNumber;
    String checkDigit;
    String expiryDate;
    List<Integer> productIDs;
    List<Integer> amounts;

    public Order(Integer orderID, String address, String name, String creditCardNumber, String checkDigit, String expiryDate, List<Integer> productIDs, List<Integer> amounts) {
        this.orderID = orderID;
        this.address = address;
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        this.checkDigit = checkDigit;
        this.expiryDate = expiryDate;
        this.productIDs = productIDs;
        this.amounts = amounts;
    }

    public Order(String address, String name, String creditCardNumber, String checkDigit, String expiryDate, List<Integer> productIDs, List<Integer> amounts) {
        this.orderID = null;
        this.address = address;
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        this.checkDigit = checkDigit;
        this.expiryDate = expiryDate;
        this.productIDs = productIDs;
        this.amounts = amounts;
    }

    public String getAddress() {return address;}
    public String getName() {return name;}
    public String getCreditCardNumber() {return creditCardNumber;}
    public String getCheckDigit() {return checkDigit;}
    public String getExpiryDate() {return expiryDate;}
    public List<Integer> getProductIDs() {return productIDs;}
    public List<Integer> getAmounts() {return amounts;}
}
