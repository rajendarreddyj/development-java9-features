package com.rajendarreddyj.payment.gateway.api;

import com.rajendarreddyj.bank.response.CustomerResponse;

/**
 * @author rajendarreddy.jagapathi
 */
public interface GatewayProcessor {
    CustomerResponse processPayment(final String cardNumber, final String cardType, final String expDate, final String cvv, final double amount);
}
