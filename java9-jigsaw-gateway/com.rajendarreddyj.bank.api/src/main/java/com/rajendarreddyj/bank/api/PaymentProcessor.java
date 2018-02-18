package com.rajendarreddyj.bank.api;

import com.rajendarreddyj.bank.response.CustomerResponse;

/**
 * @author rajendarreddy.jagapathi
 */
public interface PaymentProcessor {
    CustomerResponse processPayment(final String cardNumber, final String cardType, final String expDate, final String cvv, final double amount);
}
